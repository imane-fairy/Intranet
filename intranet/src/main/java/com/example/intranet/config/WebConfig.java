package com.example.intranet.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final StringToEmployeConverter stringToEmployeConverter;

    public WebConfig(StringToEmployeConverter stringToEmployeConverter) {
        this.stringToEmployeConverter = stringToEmployeConverter;
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(stringToEmployeConverter);
    }
}
