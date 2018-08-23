package edu.jpa.blog.service;

import edu.jpa.blog.service.dto.BlogDTO;

import java.util.List;

/**
 * @author Anton German &lt;AGerman@luxoft.com&gt;
 * @version 1.0 09.03.15
 */
public interface BlogService {
    List<BlogDTO> getBlogs();
    BlogDTO getBlog(int id);
    void removeBlog(int id);
    void modifyBlog(BlogDTO blog);
}
