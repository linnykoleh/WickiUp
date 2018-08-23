package edu.jpa.blog.domain;

import javax.persistence.*;
import java.util.List;

/**
 * @author Anton German &lt;AGerman@luxoft.com&gt;
 * @version 1.0 09.03.15
 */
@Entity
@NamedQuery(
        name ="findAll",
        query = "select B from Blog B order by B.name")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "BLOG_ID")),
        @AttributeOverride(name = "version", column = @Column(name = "BLOG_VERSION"))
})
@Table(name = "BLOG")
public class Blog extends DomainObject {

    @Column(name = "BLOG_NAME")
    private String name;

    @Column(name = "BLOG_AUTHOR")
    private String author;

    @OneToMany(mappedBy = "blog", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<BlogPost> posts;


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

    public List<BlogPost> getPosts() {
        return posts;
    }

    public void setPosts(List<BlogPost> posts) {
        this.posts = posts;
    }
}
