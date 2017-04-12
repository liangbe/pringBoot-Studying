package com.bee.study.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * 注入enviroment
 *
 * Created by liangbe on 2017/4/6.
 */
@Component
public class DIEnviroment {

    @Autowired
    Environment environment;

    public String getProValueFromEnviroment(String key) {
        return environment.getProperty(key);
    }
}
