package com.BackPackerXl.blog.service;

import com.BackPackerXl.blog.dao.UserRepository;
import com.BackPackerXl.blog.model.User;
import com.BackPackerXl.blog.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Author by：Backpackersxl
 * Date: 2021/5/5/005
 * Time: 17:43
 **/
@Service
public class UserServiceImp implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Override
    public User checkUser(String username, String password) {
        User user = userRepository.findByUsernameAndPassword(username, MD5Utils.code(password));
        return user;
    }
}
