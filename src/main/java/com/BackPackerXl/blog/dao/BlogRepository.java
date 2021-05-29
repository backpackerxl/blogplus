package com.BackPackerXl.blog.dao;

import com.BackPackerXl.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.List;

/**
 * Author by：Backpackersxl
 * Date: 2021/5/7/007
 * Time: 18:02
 **/
public interface BlogRepository extends JpaRepository<Blog, Long >, JpaSpecificationExecutor<Blog> {
    @Query("select b from Blog b where b.recommend = true ")
    List<Blog> findTop(Pageable pageable);

    @Query("select b from Blog b where b.title like ?1 or b.discreption like ?1")
    Page<Blog> findByQuery(String query,Pageable pageable);

    @Query("select function('date_format',b.updateTime,'%Y') as years from Blog b group by function('date_format',b.updateTime,'%Y') order by function('date_format',b.updateTime,'%Y') desc ")
    List<String> findGroupYear();

    @Query("select b from Blog b where function('date_format',b.updateTime,'%Y') = ?1")
    List<Blog> findByYear(String year);

    @Query("select b from Blog b where b.published=true")
    Page<Blog> findAllByPublished(Pageable pageable);

    @Query("select count(b) from Blog b where b.published=true")
    Long countByPublished();

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "update t_blog t set t.views=t.views+1 where id=?1")
    void updateViews(Long id);

    @Query(nativeQuery = true,value = "select b.title,b.views from t_blog b limit 7")
    List<Object> findBlogViewCount();
}
