package com.bee.study.config;

import org.aspectj.lang.annotation.AdviceName;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by liangbe on 2017/4/14.
 */
@Aspect
@Component
public class PointCutClass {



    @Pointcut("execution(* com.bee.study.service.impl.*.*(..))")
    public void excudeService() {
    }

    @Before(value = "excudeService()")
    public void doBefore() {

    }

}
