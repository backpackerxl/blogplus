package com.BackPackerXl.blog.service;

import com.BackPackerXl.blog.model.Blog;
import com.BackPackerXl.blog.vomodel.BlogQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

/**
 * Author by：Backpackersxl
 * Date: 2021/5/7/007
 * Time: 17:54
 **/
public interface BlogsService {
     Blog getBlog(Long id);
     Page<Blog> listBlog(Pageable pageable, BlogQuery blog);
     Blog saveBlog(Blog blog);
     Blog updateBlog(Long id,Blog blog);
     void deleteBlog(Long id);
     Page<Blog> listBlog(Pageable pageable);
     Page<Blog> listBlog(Long tagId,Pageable pageable);
     List<Blog> listBlognew(Integer num);
     Map<String,List<Blog>> archivesBlog();
     Long countBlog();
     Page<Blog> listBlogSearch(String query,Pageable pageable);
     Blog getAndConvert(Long id);

     Long countBlogs();

    List<Object> listBlogViewCount();
}
