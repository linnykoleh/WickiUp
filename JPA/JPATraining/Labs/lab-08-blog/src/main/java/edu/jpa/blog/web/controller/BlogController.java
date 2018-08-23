package edu.jpa.blog.web.controller;

import edu.jpa.blog.service.BlogService;
import edu.jpa.blog.service.dto.BlogDTO;
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
@RequestMapping("/blog/*")
public class BlogController {

    @Autowired
    private BlogService service;


    /**
     *
     */
    @RequestMapping("/list.do")
    public ModelAndView list() {
        final List<BlogDTO> blogs = service.getBlogs();

        final ModelAndView mav = new ModelAndView();
        mav.setViewName("blog/list");
        mav.addObject("blogs", blogs);

        return mav;
    }

    /**
     *
     */
    @RequestMapping("/edit.do")
    public ModelAndView edit(@RequestParam(value = "id", required = false, defaultValue = "0") final int id) {
        final BlogDTO blog;
        if (id > 0) {
            blog = service.getBlog(id);
            if (blog == null) {
                throw new RuntimeException("Cannot find blog: " + id);
            }
        } else {
            blog = new BlogDTO();
            blog.setId(0);
        }

        final ModelAndView mav = new ModelAndView();
        mav.setViewName("blog/edit");
        mav.addObject("blog", blog);

        return mav;
    }

    /**
     *
     */
    @RequestMapping("/modify.do")
    public ModelAndView modify(final BlogDTO blog) {
        service.modifyBlog(blog);
        return new ModelAndView("redirect:/blog/list.do");
    }

    /**
     *
     */
    @RequestMapping("/remove.do")
    public ModelAndView remove(@RequestParam(value = "id", required = true) final int id) {
        service.removeBlog(id);
        return new ModelAndView("redirect:/blog/list.do");
    }
}
