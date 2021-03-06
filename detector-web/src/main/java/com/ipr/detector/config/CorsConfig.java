package com.ipr.detector.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * <br/>
 *
 * @author chenshuli
 * @title 》CorsConfig
 * @data 2018-10-19 18:34
 * @since 1.0.1
 */

@Configuration
public class CorsConfig {
    /**
     *  根据配置文件来判断是否开启跨域访问
     */
    @Value("${custom.flag}")
    private boolean flag;

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        if(flag){
            corsConfiguration.addAllowedOrigin("*");
            corsConfiguration.addAllowedHeader("*");
            corsConfiguration.addAllowedMethod("*");
            source.registerCorsConfiguration("/**", corsConfiguration);
        }
        return new CorsFilter(source);
    }

}
