package com.BackPackerXl.blog.web;

import com.BackPackerXl.blog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Author by：Backpackersxl
 * Date: 2021/5/12/012
 * Time: 23:33
 **/
@Controller
public class AboutContronl {
    @Autowired
    private TypeService typeService;

    @GetMapping("/about")
    public String about(@PageableDefault(size = 5,sort = {"updateTime"},direction = Sort.Direction.DESC)
                        Model model){
        model.addAttribute("typeslist",typeService.listTypeTop(5));
        return "about";
    }
}
