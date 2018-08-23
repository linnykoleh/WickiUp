package edu.jpa.blog.service.dto;

import edu.jpa.blog.domain.BlogPost;
import edu.jpa.blog.util.BlogUtils;

/**
 * @author Anton German &lt;AGerman@luxoft.com&gt;
 * @version 1.0 09.03.15
 */
public class BlogPostDTO {
    private int id;
    private int blogId;
    private String date;
    private String title;
    private String text;

    public BlogPostDTO() {
    }

    public BlogPostDTO(BlogPost post) {
        this.id = post.getId();
        this.blogId = post.getBlog().getId();
        this.date = BlogUtils.convertDateString(post.getDate());
        this.title = post.getTitle();
        this.text = post.getText();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBlogId() {
        return blogId;
    }

    public void setBlogId(int blogId) {
        this.blogId = blogId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
