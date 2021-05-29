package com.BackPackerXl.blog.service;

import com.BackPackerXl.blog.dao.TypeRepository;
import com.BackPackerXl.blog.model.Type;
import com.BackPackerXl.blog.vomodel.BlogComment;
import com.BackPackerXl.blog.web.NotFoundException;
import lombok.SneakyThrows;
import org.springframework.beans.BeanUtils;
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
public class TypeServiceImp implements TypeService{
    @Autowired
    private TypeRepository typeRepository;

    /**
     * 保存
     * @param type
     * @return
     */
    @Transactional
    @Override
    public Type saveType(Type type) {
        return typeRepository.save(type);
    }

    /**
     * 查询
     * @param id
     * @return
     */
    @Transactional
    @Override
    public Type getType(Long id) {
        return typeRepository.findById(id).get();
    }

    @Override
    public Type getTypeByName(String name) {
        return typeRepository.findByName(name);
    }

    /**
     * 分页查询
     * @param pageable
     * @return
     */
    @Transactional
    @Override
    public Page<Type> listType(Pageable pageable) {
        return typeRepository.findAll(pageable);
    }

    /**
     * 更新
     * @param id
     * @param type
     * @return
     */
    @SneakyThrows
    @Transactional
    @Override
    public Type updateType(Long id, Type type) {
        Type t= typeRepository.findById(id).get();
        if(t == null){
            throw new NotFoundException("不存在该类型");
        }
        BeanUtils.copyProperties(type,t);

        return typeRepository.save(t);
    }

    /**
     * 删除
     * @param id
     */
    @Transactional
    @Override
    public void deleteType(Long id) {
    typeRepository.deleteById(id);
    }

    @Override
    public List<Type> listType() {
        return typeRepository.findAll();
    }

    @Override
    public List<Type> listTypeTop(Integer size) {
        Sort sort = Sort.by(Sort.Direction.DESC,"blogs.size");
        Pageable pageable = PageRequest.of(0,size,sort);
        return typeRepository.findTop(pageable);
    }

    @Override
    public List<Object> listTypeCount() {
        List<Object> blogCommentList = typeRepository.findCountType();
        return blogCommentList;
    }


}
