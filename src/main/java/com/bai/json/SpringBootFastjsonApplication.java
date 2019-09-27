package com.bai.json;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.bai.json.dao")
public class SpringBootFastjsonApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootFastjsonApplication.class, args);
    }

}
