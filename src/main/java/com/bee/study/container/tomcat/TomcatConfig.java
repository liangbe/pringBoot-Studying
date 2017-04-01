package com.bee.study.container.tomcat;


/**
 * Created by liangbe on 2017/4/1.
 */
import org.apache.catalina.connector.Connector;
import org.apache.coyote.http11.Http11NioProtocol;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;

@Configuration
public class TomcatConfig {

    /*
    * 构建EmbeddedServletContainerFactory的bean，获取到
    * TomcatEmbeddedServletContainerFactory实例以后可以对tomcat进行设置，
    * 例如这里设置编码为UTF-8
    * default 是UTF-8 (所以这里设没有用)
    * */
    @Bean
    public EmbeddedServletContainerFactory servletContainer() {
        TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory();
//        tomcat.setUriEncoding("GBK"); ↑
        tomcat.setUriEncoding("UTF-8");
//        tomcat.addAdditionalTomcatConnectors(createSslConnector());
        return tomcat;
    }
//    private Connector createSslConnector() {
//        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
//        Http11NioProtocol protocol = (Http11NioProtocol) connector.getProtocolHandler();
//        try {
////            File truststore = new File("/Users/liaokailin/software/ca1/keystore");
//            connector.setScheme("https");
//            protocol.setSSLEnabled(true);
//            connector.setSecure(true);
//            connector.setPort(8443);
////            protocol.setKeystoreFile(truststore.getAbsolutePath());
//            protocol.setKeystorePass("123456");
//            protocol.setKeyAlias("springboot");
//            return connector;
//        } catch (Exception ex) {
//            throw new IllegalStateException("cant access keystore: [" + "keystore" + "]  ", ex);
//        }
//    }
}
