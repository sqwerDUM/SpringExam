package org.example.springexam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableScheduling

public class SpringExamApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringExamApplication.class, args);
    }

}
