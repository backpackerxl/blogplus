package com.BackPackerXl.blog.web.admin;

import com.BackPackerXl.blog.model.User;
import com.BackPackerXl.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

/**
 * Author by：Backpackersxl
 * Date: 2021/5/2/002
 * Time: 15:51
 **/
@Controller
@RequestMapping("/admin")
public class LoginContronl {
    @Autowired
    private UserService userService;
    @GetMapping
    public String loginPage() {
        return "admin/login";
    }
    @PostMapping("/login")
    public String login(
            @RequestParam String username,
            @RequestParam String password,
            HttpSession session,
            RedirectAttributes attributes
    ){
        User user = userService.checkUser(username,password);
        if( user !=null){
            session.setAttribute("user",user);
            return "admin/index";
        }else {
            attributes.addFlashAttribute("message","用户名或密码错误");
            return "redirect:/admin";
        }

    }
    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        return "redirect:/admin";
    }
//    @GetMapping("/blog")
//    public String blogsPage() {
//        return "admin/blogs";
//    }
//    @GetMapping("/input")
//    public String inputPage() {
//        return "admin/input";
//    }
}
