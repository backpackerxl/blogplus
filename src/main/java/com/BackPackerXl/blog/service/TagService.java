package com.BackPackerXl.blog.service;

import com.BackPackerXl.blog.model.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Author by：Backpackersxl
 * Date: 2021/5/5/005
 * Time: 23:34
 **/
public interface TagService {
    Tag saveTag(Tag tag);
    Tag getTag(Long id);
    Tag getTagByName(String name);
    Page<Tag> listTag(Pageable pageable);
    Tag updateTag(Long id, Tag tag);
    void deleteTag(Long id);
    List<Tag> listTag();
    List<Tag> listTag(String ids);
    List<Tag> listTagTop(Integer size);
    List<Object> listTypeCount();
}
