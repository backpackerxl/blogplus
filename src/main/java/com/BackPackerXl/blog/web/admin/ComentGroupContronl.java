package com.BackPackerXl.blog.web.admin;

import com.BackPackerXl.blog.model.Comment;
import com.BackPackerXl.blog.service.CommentService;
import com.BackPackerXl.blog.vomodel.BlogComment;
import com.BackPackerXl.blog.vomodel.BlogQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Author by：Backpackersxl
 * Date: 2021/5/14/014
 * Time: 21:47
 **/
@Controller
@RequestMapping("/admin")
public class ComentGroupContronl {
    @Autowired
    private CommentService commentService;
    @GetMapping("/groupcoment")
    public String groupComments(@PageableDefault(size = 5,sort = {"id"},direction = Sort.Direction.DESC) Pageable pageable,
                                Model model){
        model.addAttribute("page",commentService.findAll(pageable));
        return "admin/comments";
    }
    @GetMapping("/comments/{id}/delete")
    public String deleteTag(@PathVariable Long id, RedirectAttributes attributes){
        commentService.deleteComment(id);
        attributes.addFlashAttribute("message","删除成功");
        return "redirect:/admin/groupcoment";
    }

}
