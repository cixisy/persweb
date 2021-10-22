package pers.as.pagedb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("pers.as.pagedb.dao")
public class PagedbApplication {
    public static void main(String[] args) {

        SpringApplication.run(PagedbApplication.class,args);
    }
}
