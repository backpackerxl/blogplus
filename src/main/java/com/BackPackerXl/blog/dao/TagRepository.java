package com.BackPackerXl.blog.dao;

import com.BackPackerXl.blog.model.Tag;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Author by：Backpackersxl
 * Date: 2021/5/5/005
 * Time: 23:41
 **/
public interface TagRepository extends JpaRepository<Tag,Long> {
   Tag findByName(String name);
    @Query("select t from Tag t ")
    List<Tag> findTop(Pageable pageable);
    @Query(nativeQuery = true, value = "select t.name,count(b.blogs_id) as total from t_blog_tags b left join t_tag t on b.tags_id = t.id group by t.id limit 6")
    List<Object> findCountTag();
}
