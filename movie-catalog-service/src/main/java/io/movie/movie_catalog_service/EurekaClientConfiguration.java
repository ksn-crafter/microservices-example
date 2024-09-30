package io.movie.movie_catalog_service;

import org.springframework.cloud.commons.util.InetUtils;
import org.springframework.cloud.commons.util.InetUtilsProperties;
import org.springframework.cloud.netflix.eureka.EurekaInstanceConfigBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class EurekaClientConfiguration {
//
//    @Bean
//    public EurekaInstanceConfigBean eurekaInstanceConfig() {
//        InetUtils inetUtils = new InetUtils(new InetUtilsProperties());
//        EurekaInstanceConfigBean config = new EurekaInstanceConfigBean(inetUtils);
//        config.setHostname("localhost");
//        config.setIpAddress("127.0.0.1");
//        config.setNonSecurePort(8081);
//        config.setNonSecurePortEnabled(true);
//        config.setPreferIpAddress(true);
//        return config;
//    }
}
