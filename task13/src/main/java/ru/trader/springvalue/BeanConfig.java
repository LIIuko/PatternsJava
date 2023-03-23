package ru.trader.springvalue;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class BeanConfig {

    @Bean("student")
    public Student streetFighter(){
        return new Student();
    }
}

