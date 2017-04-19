package com.bee.study.service;

import com.bee.study.util.BaseSearch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.io.Serializable;
import java.util.List;

/**
 * Created by liangbe on 2017/4/17.
 */
public interface CRUDService <T,ID extends Serializable>{

    List<T> findAll();

    List<T> findAll(BaseSearch<T> baseSearch);

    Page<T> findAll(BaseSearch<T> baseSearch, Pageable pageable);

    List<T> findAll(BaseSearch<T> baseSearch, Sort sort);

    <S extends T> S save(S entity);

    T findOne(ID id);

    void delete(ID id);

    void delete(T entity);

    void deleteAll();

}
