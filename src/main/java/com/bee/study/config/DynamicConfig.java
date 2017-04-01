package com.bee.study.config;

/**
 * Created by liangbe on 2017/4/1.
 * 这里模拟动态获取配置信息
 * 添加到Enviroment
 */
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.AbstractEnvironment;
@Configuration
public class DynamicConfig {
    public static final String DYNAMIC_CONFIG_NAME = "dynamic_config";

    @Autowired
    AbstractEnvironment        environment;

    @PostConstruct
    public void init() {
        environment.getPropertySources().addFirst(new DynamicPropertySource(DYNAMIC_CONFIG_NAME));
    }


}
