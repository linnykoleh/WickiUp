package edu.jpa.blog.service;

import edu.jpa.blog.domain.Blog;
import edu.jpa.blog.domain.BlogPost;
import edu.jpa.blog.service.dto.BlogPostDTO;
import edu.jpa.blog.service.dto.SearchCriteriaDTO;
import edu.jpa.blog.util.BlogUtils;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Anton German &lt;AGerman@luxoft.com&gt;
 * @version 1.0 09.03.15
 */
@Repository
@Transactional(Transactional.TxType.REQUIRED)
public class BlogPostServiceImpl implements BlogPostService {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<BlogPostDTO> getBlogPosts(int id) {
        final TypedQuery<BlogPost> query = em.createNamedQuery("findByBlog", BlogPost.class);
        query.setParameter("id", id);
        final List<BlogPost> posts = query.getResultList();

        final List<BlogPostDTO> result = new ArrayList<BlogPostDTO>(posts.size());
        for (final BlogPost post : posts) {
            result.add(new BlogPostDTO(post));
        }
        return result;
    }

    @Override
    public BlogPostDTO getBlogPost(int id) {
        final BlogPost post = em.find(BlogPost.class, id);
        return new BlogPostDTO(post);
    }

    @Override
    public void removePost(int id) {
        final BlogPost post = em.find(BlogPost.class, id);
        /* set Blog -> NULL to avoid canceling of removal due to having CascadeType.PERSIST on parent entity */
        post.setBlog(null);

        em.remove(post);
    }

    @Override
    public void modifyBlogPost(BlogPostDTO post) {
        final BlogPost persistedBlogPost;
        if (post.getId() > 0) {
            persistedBlogPost = em.find(BlogPost.class, post.getId());
        } else {
            final Blog persistedBlog = em.find(Blog.class, post.getBlogId());
            persistedBlogPost = new BlogPost();
            persistedBlogPost.setBlog(persistedBlog);
            persistedBlogPost.setDate(new Date());
        }

        persistedBlogPost.setTitle(post.getTitle());
        persistedBlogPost.setText(post.getText());

        em.persist(persistedBlogPost);
    }

    @Override
    public List<BlogPostDTO> findBlogPosts(final SearchCriteriaDTO criteria) {
        // build query
        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<BlogPost> cq = cb.createQuery(BlogPost.class);
        Root<BlogPost> bp = cq.from(BlogPost.class);

        Expression<Boolean> where = cb.equal(bp.<Integer>get("blog").get("id"), cb.parameter(Integer.class, "blogid"));
        if (StringUtils.hasText(criteria.getText())) {
            Expression<Boolean> expression = cb.like(bp.<String>get("text"), cb.parameter(String.class, "text"));
            where = cb.and(where, expression);
        }
        if (StringUtils.hasText(criteria.getFromDate())) {
            Expression<Boolean> expression = cb.greaterThanOrEqualTo(bp.<Date>get("date"), cb.parameter(Date.class, "from"));
            where = cb.and(where, expression);
        }
        if (StringUtils.hasText(criteria.getTillDate())) {
            Expression<Boolean> expression = cb.lessThanOrEqualTo(bp.<Date>get("date"), cb.parameter(Date.class, "till"));
            where = cb.and(where, expression);
        }
        cq.where(where);

        // execute query
        final TypedQuery<BlogPost> query = em.createQuery(cq);
        query.setParameter("blogid", criteria.getBlogId());
        if (StringUtils.hasText(criteria.getText())) {
            query.setParameter("text", criteria.getText());
        }
        if (StringUtils.hasText(criteria.getFromDate())) {
            query.setParameter("from", BlogUtils.convertStringToDate(criteria.getFromDate()));
        }
        if (StringUtils.hasText(criteria.getTillDate())) {
            query.setParameter("till", BlogUtils.convertStringToDate(criteria.getTillDate()));
        }

        // prepare result
        final List<BlogPost> posts = query.getResultList();

        final List<BlogPostDTO> result = new ArrayList<BlogPostDTO>(posts.size());
        for (final BlogPost post : posts) {
            result.add(new BlogPostDTO(post));
        }
        return result;
    }
}
