package edu.jpa.blog.service.dto;

import edu.jpa.blog.domain.Blog;

/**
 * @author Anton German &lt;AGerman@luxoft.com&gt;
 * @version 1.0 09.03.15
 */
public class BlogDTO {
    private int id;
    private String name;
    private String author;

    public BlogDTO() {
    }

    public BlogDTO(Blog blog) {
        this.id = blog.getId();
        this.name = blog.getName();
        this.author = blog.getAuthor();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
