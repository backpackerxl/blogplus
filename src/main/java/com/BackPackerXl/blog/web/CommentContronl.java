package com.BackPackerXl.blog.web;

import com.BackPackerXl.blog.model.Comment;
import com.BackPackerXl.blog.model.User;
import com.BackPackerXl.blog.service.BlogsService;
import com.BackPackerXl.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

/**
 * Author by：Backpackersxl
 * Date: 2021/5/11/011
 * Time: 19:08
 **/
@Controller
public class CommentContronl {
    @Autowired
    private CommentService commentService;
    @Autowired
    private BlogsService blogsService;
    @Value("${comment.avater}")
    private String avater;
    @GetMapping("/comments/{blogId}")
    public String commentList(@PathVariable Long blogId, Model model){
        model.addAttribute("comments",commentService.listCommentByBlogId(blogId));
        //System.out.println(commentService.listCommentByBlogId(blogId).toString());
        return "blog :: commentList";
    }
    @PostMapping("/comments")
    public String post(Comment comment, HttpSession session){
        Long blogId = comment.getBlog().getId();
        comment.setBlog(blogsService.getBlog(blogId));
        User user = (User) session.getAttribute("user");
        if(user != null){
            comment.setAvater(user.getAvater());
            comment.setAdminComent(true);
        }else{
            comment.setAvater(avater);
        }

        commentService.saveComment(comment);
        return "redirect:/comments/"+ blogId;
    }
}
