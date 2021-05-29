package com.BackPackerXl.blog.web.admin;


import com.BackPackerXl.blog.service.BlogsService;
import com.BackPackerXl.blog.service.CommentService;
import com.BackPackerXl.blog.service.TagService;
import com.BackPackerXl.blog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Author by：Backpackersxl
 * Date: 2021/5/6/006
 * Time: 0:00
 **/
@Controller
@RequestMapping("/admin")
public class BlogViewContronl {
    @Autowired
    private TagService tagService;
    @Autowired
    private BlogsService blogsService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private TypeService typeService;
    @GetMapping("/views")
    public String views(Model model){
        model.addAttribute("blogcount",blogsService.countBlogs());
        model.addAttribute("commentcount",commentService.countComment());
        return "admin/dynamic";
    }
    @RequestMapping("/loadtypeinfo")
    @ResponseBody
    public List<Object> loadTypeInfo(){
        List<Object> list = typeService.listTypeCount();
        return list;
    }
    @RequestMapping("/loadtagsinfo")
    @ResponseBody
    public List<Object> loadTagsInfo(){
        List<Object> list = tagService.listTypeCount();
        return list;
    }

    @RequestMapping("/loadcommentinfo")
    @ResponseBody
    public List<Object> loadCommentInfo(){
        List<Object> list = commentService.listCommentCount();
        return list;
    }

    @RequestMapping("/loadblogviewsinfo")
    @ResponseBody
    public List<Object> loadBlogviewsInfo(){
        List<Object> list = blogsService.listBlogViewCount();
        return list;
    }
}
