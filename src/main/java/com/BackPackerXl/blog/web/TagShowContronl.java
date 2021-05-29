package com.BackPackerXl.blog.web;

import com.BackPackerXl.blog.model.Tag;
import com.BackPackerXl.blog.service.BlogsService;
import com.BackPackerXl.blog.service.TagService;
import com.BackPackerXl.blog.vomodel.BlogQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Author by：Backpackersxl
 * Date: 2021/5/12/012
 * Time: 20:30
 **/
@Controller
public class TagShowContronl {
    @Autowired
    private TagService tagService;
    @Autowired
    private BlogsService blogsService;
    @GetMapping("/tags/{id}")
    public String tages(@PageableDefault(size = 6,sort = {"updateTime"},direction = Sort.Direction.DESC) Pageable pageable,
                        @PathVariable Long id, Model model){
        List<Tag> tags = tagService.listTagTop(10000);
        if(id == -1){
            id = tags.get(0).getId();
        }
        model.addAttribute("tags",tags);
        model.addAttribute("page",blogsService.listBlog(id,pageable));
        model.addAttribute("activeTagId",id);
        return "tags";
    }
}
