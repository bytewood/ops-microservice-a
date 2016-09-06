package spring;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * © 2016 org.bytewood
 */
@Profile("consul")
@Configuration
@EnableDiscoveryClient
public class ConsulConfiguration {
}
