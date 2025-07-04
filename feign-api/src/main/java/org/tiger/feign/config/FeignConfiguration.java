package org.tiger.feign.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;

/**
 * @ClassName FeignConfiguration
 * @Description feign 配置类
 * @Author tiger
 * @Date 2025/7/2 11:15
 */
public class FeignConfiguration {
    // 配置feign 日志
    @Bean
    public  Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL; // full完全打印 basic只打印基础信息
    }
}
