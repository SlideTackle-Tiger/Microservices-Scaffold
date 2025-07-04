package org.tiger.clintone.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ClassName PatternProperties
 * @Description
 * @Author tiger
 * @Date 2025/7/1 22:23
 */
@Data
@Component
@ConfigurationProperties(prefix = "pattern") //获取nacos配置文件中patter下面的属性
public class PatternProperties {
    private String dateformat;
}
