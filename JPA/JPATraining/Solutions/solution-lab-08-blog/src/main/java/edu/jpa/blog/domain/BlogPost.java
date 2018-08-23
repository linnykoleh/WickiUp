package edu.jpa.blog.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Anton German &lt;AGerman@luxoft.com&gt;
 * @version 1.0 09.03.15
 */
@Entity
@NamedQuery(
        name = "findByBlog",
        query = "select P from BlogPost P where P.blog.id = :id"
)
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "POST_ID")),
        @AttributeOverride(name = "version", column = @Column(name = "POST_VERSION"))
})
@Table(name = "BLOG_POST")
public class BlogPost extends DomainObject {

    @Column(name = "POST_DATE")
    private Date date;

    @Column(name = "POST_TITLE")
    private String title;

    @Lob
    @Basic(fetch = FetchType.EAGER)
    @Column(name = "POST_TEXT")
    private String text;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "BLOG_ID")
    private Blog blog;


    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
