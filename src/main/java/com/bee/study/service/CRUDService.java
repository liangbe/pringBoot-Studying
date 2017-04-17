package com.bee.study.service;

import org.springframework.data.domain.Sort;

import java.io.Serializable;
import java.util.List;

/**
 * Created by liangbe on 2017/4/17.
 */
public interface CRUDService <T,ID extends Serializable>{

    List<T> findAll();

    <S extends T> S save(S entity);

    T findOne(ID id);

    void delete(ID id);

    void delete(T entity);

    void deleteAll();

}
