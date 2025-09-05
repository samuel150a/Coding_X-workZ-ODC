package com.xworkz.center.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan("com.xworkz.center")
public class CenterConfiguration {
    public CenterConfiguration()
    {
        System.out.println("Running in the CenterConfiguration method");
    }

    @Bean
    public InternalResourceViewResolver viewResolver()
    {
        System.out.println("Running in the viewResolver method");
        InternalResourceViewResolver resolver=new InternalResourceViewResolver();
        resolver.setPrefix("/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
}
