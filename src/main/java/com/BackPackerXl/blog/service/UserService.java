package com.BackPackerXl.blog.service;

import com.BackPackerXl.blog.model.User;

/**
 * Author by：Backpackersxl
 * Date: 2021/5/5/005
 * Time: 17:39
 **/
public interface UserService {
    User checkUser(String username,String password);
}
