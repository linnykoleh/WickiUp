package edu.jpa.blog.service;

import edu.jpa.blog.domain.Blog;
import edu.jpa.blog.service.dto.BlogDTO;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Anton German &lt;AGerman@luxoft.com&gt;
 * @version 1.0 09.03.15
 */
@Repository
@Transactional(Transactional.TxType.REQUIRED)
public class BlogServiceImpl implements BlogService {

    @PersistenceContext
    private EntityManager em;

    /**
     *
     */
    @Override
    public List<BlogDTO> getBlogs() {
        final TypedQuery<Blog> query = em.createNamedQuery("findAll", Blog.class);
        final List<Blog> blogs = query.getResultList();

        final List<BlogDTO> result = new ArrayList<BlogDTO>(blogs.size());
        for (final Blog blog : blogs) {
            result.add(new BlogDTO(blog));
        }
        return result;
    }

    /**
     *
     */
    @Override
    public BlogDTO getBlog(final int id) {
        final Blog blog = em.find(Blog.class, id);
        return new BlogDTO(blog);
    }

    /**
     *
     */
    @Override
    public void removeBlog(int id) {
        final Blog blog = em.find(Blog.class, id);
        em.remove(blog);
    }

    /**
     *
     */
    @Override
    public void modifyBlog(BlogDTO blog) {
        final Blog persistedBlog;
        if (blog.getId() > 0) {
            persistedBlog = em.find(Blog.class, blog.getId());
        } else {
            persistedBlog = new Blog();
        }

        persistedBlog.setAuthor(blog.getAuthor());
        persistedBlog.setName(blog.getName());
        em.persist(persistedBlog);
    }
}
