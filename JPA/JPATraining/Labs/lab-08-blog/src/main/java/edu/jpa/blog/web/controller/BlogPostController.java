package edu.jpa.blog.web.controller;

import edu.jpa.blog.service.BlogPostService;
import edu.jpa.blog.service.dto.BlogPostDTO;
import edu.jpa.blog.service.dto.SearchCriteriaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author Anton German &lt;AGerman@luxoft.com&gt;
 * @version 1.0 09.03.15
 */
@Controller
@RequestMapping("/post/*")
public class BlogPostController {

    @Autowired
    private BlogPostService service;


    /**
     *
     */
    @RequestMapping("/list.do")
    public ModelAndView list(@RequestParam(value = "id") final int id) {
        final List<BlogPostDTO> posts = service.getBlogPosts(id);

        final SearchCriteriaDTO criteria = new SearchCriteriaDTO();
        criteria.setBlogId(id);

        final ModelAndView mav = new ModelAndView();
        mav.setViewName("post/list");
        mav.addObject("posts", posts);
        mav.addObject("criteria", criteria);

        return mav;
    }

    @RequestMapping("/search.do")
    public ModelAndView search(final SearchCriteriaDTO criteria) {
        final List<BlogPostDTO> posts = service.findBlogPosts(criteria);

        final ModelAndView mav = new ModelAndView();
        mav.setViewName("post/list");
        mav.addObject("posts", posts);
        mav.addObject("criteria", criteria);

        return mav;
    }

    /**
     *
     */
    @RequestMapping("/edit.do")
    public ModelAndView edit(
            @RequestParam(value = "id", required = false, defaultValue = "0") final int id,
            @RequestParam(value = "blogid") final int blogId) {

        final BlogPostDTO post;
        if (id > 0) {
            post = service.getBlogPost(id);
            if (post == null) {
                throw new RuntimeException("Cannot find post: " + id);
            }
        } else {
            post = new BlogPostDTO();
            post.setId(0);
            post.setBlogId(blogId);
        }

        final ModelAndView mav = new ModelAndView();
        mav.setViewName("post/edit");
        mav.addObject("post", post);

        return mav;
    }

    /**
     *
     */
    @RequestMapping("/modify.do")
    public ModelAndView modify(final BlogPostDTO post) {
        service.modifyBlogPost(post);

        final ModelAndView mav = new ModelAndView("redirect:/post/list.do");
        mav.addObject("id", post.getBlogId());
        return mav;
    }

    /**
     *
     */
    @RequestMapping("/remove.do")
    public ModelAndView remove(@RequestParam(value = "id", required = true) final int id) {
        final BlogPostDTO post = service.getBlogPost(id);
        if (post == null) {
            throw new RuntimeException("Cannot find post: " + id);
        }

        service.removePost(post.getId());

        final ModelAndView mav = new ModelAndView("redirect:/post/list.do");
        mav.addObject("id", post.getBlogId());
        return mav;
    }
}
