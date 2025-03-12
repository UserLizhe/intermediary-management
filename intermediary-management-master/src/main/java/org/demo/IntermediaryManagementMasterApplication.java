package org.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@MapperScan("org.demo.mapper")
//@MapperScan("com.example.intermediarymanagementmaser.demo.mapper") // 指定 Mapper 接口所在的包
public class IntermediaryManagementMasterApplication {
    public static void main(String[] args) {
        SpringApplication.run(IntermediaryManagementMasterApplication.class, args);
    }

}
