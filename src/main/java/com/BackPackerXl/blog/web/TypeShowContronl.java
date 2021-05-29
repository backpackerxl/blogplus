package com.BackPackerXl.blog.web;

import com.BackPackerXl.blog.model.Type;
import com.BackPackerXl.blog.service.BlogsService;
import com.BackPackerXl.blog.service.TypeService;
import com.BackPackerXl.blog.vomodel.BlogQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Author by：Backpackersxl
 * Date: 2021/5/12/012
 * Time: 19:24
 **/
@Controller
public class TypeShowContronl {
    @Autowired
    private TypeService typeService;
    @Autowired
    private BlogsService blogsService;
    @GetMapping("/types/{id}")
    public String types(@PageableDefault(size = 6,sort = {"updateTime"},direction = Sort.Direction.DESC) Pageable pageable,
                        @PathVariable Long id, Model model){
        List<Type> types = typeService.listTypeTop(10000);
        if(id == -1){
         id = types.get(0).getId();
        }
        BlogQuery blogQuery = new BlogQuery();
        blogQuery.setTypeId(id);
        model.addAttribute("types",types);
        model.addAttribute("page",blogsService.listBlog(pageable,blogQuery));
        model.addAttribute("activeTypeId",id);
        return "type";
    }
}
