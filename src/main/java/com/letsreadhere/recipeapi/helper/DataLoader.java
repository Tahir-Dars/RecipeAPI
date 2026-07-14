package com.letsreadhere.recipeapi.helper;

import com.letsreadhere.recipeapi.model.Recipe;
import lombok.AllArgsConstructor;
import org.h2.server.web.JakartaWebServlet;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class DataLoader {
    @Bean
    public ServletRegistrationBean<JakartaWebServlet> h2servletRegistration() {
        ServletRegistrationBean<JakartaWebServlet> registrationBean =
                new ServletRegistrationBean<>(new JakartaWebServlet());
        registrationBean.addUrlMappings("/h2-console/*");
        return registrationBean;
    }

    @Bean
    public CommandLineRunner initData() {
        return args ->  {
            Recipe recipe001 = Recipe.builder()
                    .category("Fast Food")
                    .name("Home made burger")
                    .rating(4)
                    .build();
            Recipe recipe002 = Recipe.builder()
                    .category("Sweet")
                    .name("Custard")
                    .rating(4)
                    .build();
            Recipe recipe003 = Recipe.builder()
                    .category("Hot")
                    .name("Macaroni")
                    .rating(4)
                    .build();
        };
    }

}
