package com.BackPackerXl.blog.dao;

import com.BackPackerXl.blog.model.Blog;
import com.BackPackerXl.blog.model.Type;
import com.BackPackerXl.blog.vomodel.BlogComment;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Author by：Backpackersxl
 * Date: 2021/5/5/005
 * Time: 23:41
 **/
public interface TypeRepository extends JpaRepository<Type,Long> {
   Type findByName(String name);

   // @Query(nativeQuery = true, value = "select t.id,t.name,count(t.name) as sum from t_type t join t_blog tb on t.id = tb.type_id group by t.name order by sum desc limit ?")
   @Query("select t from Type t")
   List<Type> findTop(Pageable pageable);

   @Transactional
   @Query(nativeQuery = true,value="select t.name,count(b.type_id) as count from t_blog b right join t_type t on b.type_id=t.id group by t.id limit 7")
   List<Object> findCountType();
}
