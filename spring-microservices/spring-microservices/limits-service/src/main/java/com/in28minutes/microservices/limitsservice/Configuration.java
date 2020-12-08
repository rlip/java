package com.in28minutes.microservices.limitsservice;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@org.springframework.context.annotation.Configuration
@ConfigurationProperties(prefix = "limits-service")
@Getter
@Setter
public class Configuration {

    private int minimum;
    private int maximum;

}