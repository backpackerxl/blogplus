package com.BackPackerXl.blog.web.admin;

import com.BackPackerXl.blog.model.Tag;
import com.BackPackerXl.blog.service.TagService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Author by：Backpackersxl
 * Date: 2021/5/6/006
 * Time: 0:00
 **/
@Controller
@RequestMapping("/admin")
public class TagContronl {
    @Autowired
    private TagService tagService;
    @GetMapping("/tags")
    public String tags(@PageableDefault(size = 5,sort = {"id"},direction = Sort.Direction.DESC)
                                    Pageable pageable,
                                    Model model
    ){
        model.addAttribute("page", tagService.listTag(pageable));
        return "admin/tag";
    }
    @GetMapping("/tag/input")
    public String input(){
        return "admin/tag-input";
    }
    @GetMapping("tags/{id}/input")
    public String editInput(@PathVariable Long id, Model model){
        model.addAttribute("tag",tagService.getTag(id));
        return "admin/tags-input";
    }
    @PostMapping("/tags")
    public String post(Tag tag, BindingResult result, RedirectAttributes attributes){
        Tag tag1 = tagService.getTagByName(tag.getName());
        if (tag1 != null){
            result.rejectValue("name","nameError","不能重复提交相同的分类");
            attributes.addFlashAttribute("msg","不能重复提交相同的分类");
        }
        if(result.hasErrors()){
            return "admin/tag-input";
        }
        Tag t = tagService.saveTag(tag);
        if(t == null){
            attributes.addFlashAttribute("message","新增失败");
        }else{
            attributes.addFlashAttribute("message","新增成功");
        }
        return "redirect:/admin/tags";
    }
    @SneakyThrows
    @PostMapping("/tags/{id}")
    public String editPost(Tag tag, BindingResult result, @PathVariable Long id,RedirectAttributes attributes){
        Tag tag1 = tagService.getTagByName(tag.getName());
        if (tag1 != null){
            result.rejectValue("name","nameError","不能重复提交相同的标签");
            attributes.addFlashAttribute("msg","不能重复提交相同的标签");
        }
        if(result.hasErrors()){
            return "admin/tag-input";
        }
        Tag t = tagService.updateTag(id,tag);
        if(t == null){
            attributes.addFlashAttribute("message","更新失败");
        }else{
            attributes.addFlashAttribute("message","更新成功");
        }
        return "redirect:/admin/tags";
    }
    @GetMapping("/tags/{id}/delete")
    public String deleteTag(@PathVariable Long id,RedirectAttributes attributes){
        tagService.deleteTag(id);
        attributes.addFlashAttribute("message","删除成功");
        return "redirect:/admin/tags";
    }
}