package com.ssg.ssg_be;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@EnableAspectJAutoProxy
@SpringBootApplication(scanBasePackages = "com.ssg")
public class SsgBeApplication {

    public static void main(String[] args) {
        SpringApplication.run(SsgBeApplication.class, args);
    }

}
