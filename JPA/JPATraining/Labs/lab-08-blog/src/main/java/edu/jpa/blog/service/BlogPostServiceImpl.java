package edu.jpa.blog.service;

import edu.jpa.blog.service.dto.BlogPostDTO;
import edu.jpa.blog.service.dto.SearchCriteriaDTO;

import java.util.List;

/**
 * @author Anton German &lt;AGerman@luxoft.com&gt;
 * @version 1.0 09.03.15
 */
public class BlogPostServiceImpl implements BlogPostService {
    public List<BlogPostDTO> getBlogPosts(int id) {
        throw new UnsupportedOperationException("Method is not implemented yet.");
    }

    public BlogPostDTO getBlogPost(int id) {
        throw new UnsupportedOperationException("Method is not implemented yet.");
    }

    public void modifyBlogPost(BlogPostDTO post) {
        throw new UnsupportedOperationException("Method is not implemented yet.");
    }

    public void removePost(int id) {
        throw new UnsupportedOperationException("Method is not implemented yet.");
    }

    public List<BlogPostDTO> findBlogPosts(SearchCriteriaDTO criteria) {
        throw new UnsupportedOperationException("Method is not implemented yet.");
    }
}
