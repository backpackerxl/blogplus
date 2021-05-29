package com.BackPackerXl.blog.web.admin;

import com.BackPackerXl.blog.model.Type;
import com.BackPackerXl.blog.service.TypeService;
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

import javax.servlet.http.HttpSession;

/**
 * Author by：Backpackersxl
 * Date: 2021/5/6/006
 * Time: 0:00
 **/
@Controller
@RequestMapping("/admin")
public class TypeContronl {
    @Autowired
    private TypeService typeService;
    @GetMapping("/types")
    public String types(@PageableDefault(size = 5,sort = {"id"},direction = Sort.Direction.DESC)
                                    Pageable pageable,
                                    Model model
    ){
        model.addAttribute("page", typeService.listType(pageable));
        return "admin/type";
    }
    @GetMapping("/type/input")
    public String input(Model model){
        model.addAttribute("type",new Type());
        return "admin/type-input";
    }
    @GetMapping("types/{id}/input")
    public String editInput(@PathVariable Long id, Model model){
        model.addAttribute("type",typeService.getType(id));
        return "admin/types-input";
    }
    @PostMapping("/types")
    public String post(Type type, BindingResult result, RedirectAttributes attributes,Model model){
        Type type1 = typeService.getTypeByName(type.getName());
        System.out.println(type1);
        model.addAttribute("typname","分类名称");
        if (type1 != null){
             result.rejectValue("name","nameError","不能重复提交相同的分类");

        }
        if(result.hasErrors()){
            return "redirect:/admin/type/input";
        }
        Type t = typeService.saveType(type);
        if(t == null){
            attributes.addFlashAttribute("message","新增失败");
        }else{
            attributes.addFlashAttribute("message","新增成功");
        }
        return "redirect:/admin/types";
    }
    @SneakyThrows
    @PostMapping("/types/{id}")
    public String editPost(Type type, BindingResult result, @PathVariable Long id,RedirectAttributes attributes){
        Type type1 = typeService.getTypeByName(type.getName());
        if (type1 != null){
            result.rejectValue("name","nameError","不能重复提交相同的分类");
            //attributes.addFlashAttribute("msg","不能重复提交相同的分类");
        }
        if(result.hasErrors()){
            return "admin/type-input";
        }
        Type t = typeService.updateType(id,type);
        if(t == null){
            attributes.addFlashAttribute("message","更新失败");
        }else{
            attributes.addFlashAttribute("message","更新成功");
        }
        return "redirect:/admin/types";
    }
    @GetMapping("/types/{id}/delete")
    public String deleteType(@PathVariable Long id,RedirectAttributes attributes){
        typeService.deleteType(id);
        attributes.addFlashAttribute("message","删除成功");
        return "redirect:/admin/types";
    }
}
