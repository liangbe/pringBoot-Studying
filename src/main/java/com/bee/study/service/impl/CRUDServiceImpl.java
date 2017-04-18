package com.bee.study.service.impl;


import com.bee.study.dao.BaseDao;
import com.bee.study.service.CRUDService;
import com.bee.study.util.BaseSearch;
import com.bee.study.util.SearchDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * Created by liangbe on 2017/4/17.
 */

@Transactional
public abstract class CRUDServiceImpl<T,ID extends Serializable> implements CRUDService <T,ID> {

    @Autowired
    public abstract BaseDao<T,ID> getDao();

    @Override
    public List<T> findAll() {
        return getDao().findAll();
    }

    @Override
    public <S extends T> S save(S entity) {
        S result=(S)getDao().saveAndFlush(entity);
        return result;
    }


    @Override
    public T findOne(ID id) {
        return (T)getDao().findOne(id);
    }

    @Override
    public void delete(ID id) {
        getDao().delete(id);
        getDao().flush();
    }

    @Override
    public void delete(T entity) {
        getDao().delete(entity);
        getDao().flush();
    }


    @Override
    public void deleteAll() {
        getDao().deleteAll();
        getDao().flush();
    }

    @Override
    public List<T> findAll(List<SearchDto> searchDtoList) {

//        SearchDto searchDto=new SearchDto("userName","eq", "user1");

        BaseSearch<T> baseSearch =new BaseSearch<T>(searchDtoList);
        return getDao().findAll(baseSearch);
    }
}
