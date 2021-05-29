package com.BackPackerXl.blog.web;

import com.BackPackerXl.blog.service.BlogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Author by：Backpackersxl
 * Date: 2021/5/12/012
 * Time: 22:19
 **/
@Controller
public class ArchivesContronl {
    @Autowired
    private BlogsService blogsService;
    @GetMapping("/archives")
    public String archives(Model model){
        model.addAttribute("archivesMap",blogsService.archivesBlog());
        model.addAttribute("blogCount",blogsService.countBlog());
        return "archives";
    }
}
