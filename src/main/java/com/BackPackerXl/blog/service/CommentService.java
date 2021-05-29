package com.BackPackerXl.blog.service;

import com.BackPackerXl.blog.model.Comment;
import com.BackPackerXl.blog.vomodel.BlogComment;
import com.BackPackerXl.blog.web.admin.BlogsContronl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Author by：Backpackersxl
 * Date: 2021/5/11/011
 * Time: 19:16
 **/
public interface CommentService {
    Comment saveComment(Comment comment);

    List<Comment> listCommentByBlogId(Long blogId);

    Page<Comment> findAll(Pageable pageable);

    void deleteComment(Long id);

    Page<Comment> listComment(String query,Pageable pageable);

    Long countComment();

    List<Object> listCommentCount();
}
