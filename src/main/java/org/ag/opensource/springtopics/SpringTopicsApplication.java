package org.ag.opensource.springtopics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing(auditorAwareRef = "auditorAwareImpl")
@SpringBootApplication
public class SpringTopicsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringTopicsApplication.class, args);
    }

}
