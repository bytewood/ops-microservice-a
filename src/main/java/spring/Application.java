package spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.model.Microservice;

import java.util.UUID;

/**
 * © 2016 org.bytewood
 */
@SpringBootApplication
@RestController
public class Application {

    @Autowired
    String hostName;

    public static void main(final String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @RequestMapping(value="/loop")
    public Microservice loop() {
        return Microservice.builder()
                .name("microservice-a")
                .instance(hostName)
                .build();
    }

    @Bean
    public String hostName() {
        return UUID.randomUUID().toString();
    }
}
