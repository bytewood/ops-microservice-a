package spring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * © 2016 org.bytewood
 */
@Slf4j
@Profile("consul")
@Configuration
@EnableDiscoveryClient
public class ConsulConfiguration {

    @Bean
    String discovery() {
        String s = "CONSUL DISCOVERY ENABLED";
        log.info(s);
        return s;
    }
}
