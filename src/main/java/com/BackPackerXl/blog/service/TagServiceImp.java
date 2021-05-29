package com.BackPackerXl.blog.service;

import com.BackPackerXl.blog.dao.TagRepository;
import com.BackPackerXl.blog.model.Tag;
import com.BackPackerXl.blog.web.NotFoundException;
import lombok.SneakyThrows;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Author by：Backpackersxl
 * Date: 2021/5/5/005
 * Time: 23:39
 **/
@Service
public class TagServiceImp implements TagService {
    @Autowired
    private TagRepository tagRepository;

    /**
     * 保存
     *
     * @param tag
     * @return
     */
    @Transactional
    @Override
    public Tag saveTag(Tag tag) {
        return tagRepository.save(tag);
    }

    /**
     * 查询
     *
     * @param id
     * @return
     */
    @Transactional
    @Override
    public Tag getTag(Long id) {
        return tagRepository.findById(id).get();
    }

    @Override
    public Tag getTagByName(String name) {
        return tagRepository.findByName(name);
    }

    /**
     * 分页查询
     *
     * @param pageable
     * @return
     */
    @Transactional
    @Override
    public Page<Tag> listTag(Pageable pageable) {
        return tagRepository.findAll(pageable);
    }

    /**
     * 更新
     *
     * @param id
     * @param tag
     * @return
     */
    @SneakyThrows
    @Transactional
    @Override
    public Tag updateTag(Long id, Tag tag) {
        Tag t = tagRepository.findById(id).get();
        if (t == null) {
            throw new NotFoundException("不存在该类型");
        }
        BeanUtils.copyProperties(tag, t);

        return tagRepository.save(t);
    }

    /**
     * 删除
     *
     * @param id
     */
    @Transactional
    @Override
    public void deleteTag(Long id) {
        tagRepository.deleteById(id);
    }

    @Override
    public List<Tag> listTag() {
        return tagRepository.findAll();
    }

    @Override
    public List<Tag> listTag(String ids) {
        return tagRepository.findAllById(convertToList(ids));
    }

    @Override
    public List<Tag> listTagTop(Integer size) {
        Sort sort = Sort.by(Sort.Direction.DESC,"blogs.size");
        Pageable pageable = PageRequest.of(0,size,sort);
        return tagRepository.findTop(pageable);
    }

    @Override
    public List<Object> listTypeCount() {
        List<Object> blogCommentList = tagRepository.findCountTag();
        return blogCommentList;
    }

    /**
     * 将前端传回来的字符串转储存为集合
     * @param ids
     * @return
     */
    private List<Long> convertToList(String ids) {
        List<Long> list = new ArrayList<>();
        if (!"".equals(ids) && ids != null) {
            String[] idarray = ids.split(",");
            for (int i = 0; i < idarray.length; i++) {
                list.add(new Long(idarray[i]));
            }
        }
        return list;
    }
}
