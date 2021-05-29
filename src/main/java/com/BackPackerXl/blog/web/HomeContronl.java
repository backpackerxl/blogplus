package com.BackPackerXl.blog.web;

import com.BackPackerXl.blog.service.BlogsService;
import com.BackPackerXl.blog.service.TagService;
import com.BackPackerXl.blog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Author by：Backpackersxl
 * Date: 2021/5/2/002
 * Time: 15:12
 **/
@Controller
public class HomeContronl {
    @Autowired
    private BlogsService blogsService;
    @Autowired
    private TypeService typeService;
    @Autowired
    private TagService tagService;
//    @Autowired
//    private TagRepository tagRepository;
    @RequestMapping("/community")
    public String index(@PageableDefault(size = 6,sort = {"updateTime"},direction = Sort.Direction.DESC) Pageable pageable,
                        Model model) {
        model.addAttribute("page",blogsService.listBlog(pageable));
        model.addAttribute("types",typeService.listTypeTop(6));
        model.addAttribute("tags",tagService.listTagTop(10));
        model.addAttribute("recommendBlogs",blogsService.listBlognew(6));
        //System.out.println(blogsService.listBlognew(6));
        return "home";
    }
    @PostMapping("/search")
    public String search(@PageableDefault(size = 6,sort = {"updateTime"},direction = Sort.Direction.DESC) Pageable pageable,
                         @RequestParam String query, Model model){
        model.addAttribute("page",blogsService.listBlogSearch("%"+query+"%",pageable));
        model.addAttribute("query",query);
        return "search";
    }
    @RequestMapping("/blog/{id}")
    public String blog(@PathVariable Long id,Model model) {
        model.addAttribute("blog",blogsService.getAndConvert(id));
        return "blog";
    }
    @GetMapping("/footer/newblog")
    public String newblogList(Model model){
        model.addAttribute("footer",blogsService.listBlognew(3));
       // System.out.println(blogsService.listBlognew(3));
        return "_fragments :: blogLists";
    }
    @RequestMapping("/")
    public String home(){
        return "index";
    }
}
