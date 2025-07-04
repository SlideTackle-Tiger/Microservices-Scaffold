package org.tiger.clintone;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.tiger.clintone.mapper")
public class ClintOneApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClintOneApplication.class, args);
    }

}
