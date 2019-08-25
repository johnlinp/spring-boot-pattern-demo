package com.example.demo;

import javax.validation.MessageInterpolator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
public class ValidationConfig {
    @Bean
    public static LocalValidatorFactoryBean myValidatorFactory () {
        LocalValidatorFactoryBean factoryBean = new LocalValidatorFactoryBean();
        factoryBean.setMessageInterpolator(messageInterpolator());
        return factoryBean;
    }

    private static MessageInterpolator messageInterpolator () {
        return new MyResourceBundleMessageInterpolator();
    }
}
