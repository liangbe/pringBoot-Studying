package com.bee.study.service;

import com.bee.study.util.SearchDto;
import org.hibernate.Filter;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import java.io.Serializable;
import java.util.List;

/**
 * Created by liangbe on 2017/4/17.
 */
public interface CRUDService <T,ID extends Serializable>{

    List<T> findAll();

    List<T> findAll(List<SearchDto> searchDtoList);

    <S extends T> S save(S entity);

    T findOne(ID id);

    void delete(ID id);

    void delete(T entity);

    void deleteAll();

}
