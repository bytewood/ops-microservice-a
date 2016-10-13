package spring;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import spring.model.Microservice;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Optional;
import java.util.UUID;

/**
 * © 2016 org.bytewood
 */
@Slf4j
@SpringBootApplication
@RestController
public class Application {

    @Autowired
    String hostName;

    public static void main(final String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @RequestMapping(value="/echo")
    public Microservice echo(@RequestParam(name = "message", required = false, defaultValue = "___oooOOO") String message) {
        return Microservice.builder()
                .message(urlDecode(message))
                .name("microservice-a")
                .instance(hostName)
                .build();
    }

    @SneakyThrows
    private String urlDecode(@RequestParam(name = "message", required = false, defaultValue = "___oooOOO") String message)  {
        return URLDecoder.decode(message, "UTF-8");
    }

    @Bean
    public String hostName() {
        String hostname = Optional
                .ofNullable(System.getProperty("HOSTNAME"))
                .orElse(UUID.randomUUID().toString());
        log.debug("host instance id :: " + hostname);
        return hostname;
    }

}
