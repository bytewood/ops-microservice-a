package spring.model;

import lombok.Builder;
import lombok.Data;

/**
 * © 2016 org.bytewood
 */
@Data
@Builder
public class Microservice {
    private String name;
    private String instance;
}
