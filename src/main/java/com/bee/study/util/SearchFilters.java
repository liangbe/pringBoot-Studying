package com.bee.study.util;

/**
 * Created by liangbe on 2017/4/17.
 */
public class SearchFilters {
    /** 拼接类型，and或者or */
//    private String type;
    private String key;
    private String operation;
    private Object value;

    public SearchFilters(String key, String operation, Object value) {

        this.key = key;
        this.operation = operation;
        this.value = value;
    }


    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
