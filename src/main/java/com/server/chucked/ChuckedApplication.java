package com.server.chucked;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class ChuckedApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChuckedApplication.class, args);
    }

}
