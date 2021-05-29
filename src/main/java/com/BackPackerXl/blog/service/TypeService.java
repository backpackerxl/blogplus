package com.BackPackerXl.blog.service;

import com.BackPackerXl.blog.model.Type;
import com.BackPackerXl.blog.vomodel.BlogComment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Author by：Backpackersxl
 * Date: 2021/5/5/005
 * Time: 23:34
 **/
public interface TypeService {
    Type saveType(Type type);
    Type getType(Long id);
    Type getTypeByName(String name);
    Page<Type> listType(Pageable pageable);
    Type updateType(Long id,Type type);
    void deleteType(Long id);
    List<Type> listType();
    List<Type> listTypeTop(Integer size);
    List<Object> listTypeCount();
}
