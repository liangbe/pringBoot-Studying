package com.bee.study.util;

import java.util.List;

/**
 * Created by liangbe on 2017/4/19.
 */
public class ResponseEntityDto<T> {
    private List<T> content;
    private  int totalElements;


    public ResponseEntityDto(List<T> content){
        this.content=content;
        this.totalElements=content.size();
    }

    public int getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(int totalElements) {
        this.totalElements = totalElements;
    }

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }
}
