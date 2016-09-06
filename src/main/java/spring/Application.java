package spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.model.Microservice;

/**
 * © 2016 org.bytewood
 */
@SpringBootApplication
@RestController
public class Application {

    public static void main(final String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @RequestMapping(value="/loop")
    public Microservice loop() {
        return Microservice.builder()
                .name("microservice-a")
                .instance(System.getProperty("spring.cloud.client.hostname"))
                .build();
    }

}
