package com.bee.study.util;

import org.springframework.data.jpa.domain.Specification;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liangbe on 2017/4/17.
 */

enum Operator {
    GTE,
    GT,
    LTE,
    LT,
    LIKE,
    LIKEBE,
    NLIKE,
    NLIKEBE,
    EQ,
    NEQ,
    ISNULL
}
public class BaseSearch<T> implements Specification<T> {
    private List<SearchDto> criteriaList;

    public BaseSearch(List<SearchDto>  criteriaList) {

        this.criteriaList = criteriaList;
    }
    @Override
    public Predicate toPredicate
            (Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        List<Predicate> list = new ArrayList<Predicate>();
     for(SearchDto criteria:criteriaList) {
         String opt = criteria.getOperation();
         String key = criteria.getKey();
         String value = criteria.getValue().toString();

         if (opt.equalsIgnoreCase(String.valueOf(Operator.GTE))) { //大于等于
             list.add(builder.greaterThanOrEqualTo(root.<String>get(key), value));
         } else if (opt.equalsIgnoreCase(String.valueOf(Operator.GT))) { //大于
             list.add(builder.greaterThan(root.<String>get(key), value));
         } else if (opt.equalsIgnoreCase(String.valueOf(Operator.LTE))) { //小于等于
             list.add(builder.lessThanOrEqualTo(root.<String>get(key), value));
         } else if (opt.equalsIgnoreCase(String.valueOf(Operator.LT))) { //小于
             list.add(builder.lessThan(root.<String>get(key), value));
         } else if (opt.equalsIgnoreCase(String.valueOf(Operator.LIKE)) || opt.equalsIgnoreCase(String.valueOf(Operator.LIKEBE))) { //like '%?%'
             list.add(builder.like(root.<String>get(key), "%" + value + "%"));
         } else if (opt.equalsIgnoreCase(String.valueOf(Operator.NLIKE)) || opt.equalsIgnoreCase(String.valueOf(Operator.NLIKEBE))) { //not like '%?%'
             list.add(builder.notLike(root.<String>get(key), "%" + value + "%"));
         } else if (opt.equalsIgnoreCase(String.valueOf(Operator.EQ))) { //equal
             list.add(builder.equal(root.get(key), value));
         } else if (opt.equalsIgnoreCase(String.valueOf(Operator.NEQ))) { //not equal
             list.add(builder.notEqual(root.get(key), value));
         } else if (opt.equalsIgnoreCase(String.valueOf(Operator.ISNULL))) { // is null
             list.add(builder.isNull(root.get(key)));
         }
     }
     Predicate[] p = new Predicate[criteriaList.size()];
     Predicate result=  builder.and(list.toArray(p));
     return result;
    }
}
