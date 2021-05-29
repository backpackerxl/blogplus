package com.BackPackerXl.blog.dao;

import com.BackPackerXl.blog.model.Comment;
import com.BackPackerXl.blog.vomodel.BlogComment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Author by：Backpackersxl
 * Date: 2021/5/11/011
 * Time: 19:23
 **/
public interface CommentRepository extends JpaRepository<Comment,Long> {
    List<Comment> findByBlogId(Long blogId, Sort sort);

    void deleteById(Long id);

    @Query("select c from Comment c where c.blog.title like ?1")
    Page<Comment> findByQuery(String query,Pageable pageable);

    @Query(nativeQuery = true,value = "select b.title,count(c.blog_id) as total from t_comment c left join t_blog b on c.blog_id=b.id group by b.id limit 7")
    List<Object> findCountComment();
}
