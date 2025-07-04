package org.tiger.clienttwo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.tiger.feign.client.UserClient;
import org.tiger.feign.config.FeignConfiguration;

@SpringBootApplication
@MapperScan("org.tiger.clienttwo.mapper") // mybatis-plus扫描Mapper文件
@EnableFeignClients(defaultConfiguration = FeignConfiguration.class, clients = {UserClient.class}) // 开启Feign客户端,并指定配置类,指定UserClient接口的实现类。由于跨模块所以需要指定
public class ClientTwoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientTwoApplication.class, args);
    }

    @Bean
    @LoadBalanced // 负载均衡
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
