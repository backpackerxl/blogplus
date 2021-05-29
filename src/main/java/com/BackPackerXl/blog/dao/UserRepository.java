package com.BackPackerXl.blog.dao;

import com.BackPackerXl.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Author by：Backpackersxl
 * Date: 2021/5/5/005
 * Time: 17:46
 **/
public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsernameAndPassword(String username,String password);
}
