package com.example.shoe_management_ajax;

import com.codegym.model.Shoe;
import com.codegym.service.ShoeService;
import com.codegym.service.ShoeServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.persistence.Entity;

@SpringBootApplication
@Configuration
@EntityScan("com.codegym.model")
@ComponentScan("com.codegym.controller")
@EnableTransactionManagement
@EnableWebMvc
@EnableSpringDataWebSupport
@EnableJpaRepositories("com.codegym.repository")

public class ShoeManagementAjaxApplication {
    @Bean
    public ShoeService shoeService(){
        return new ShoeServiceImpl();
    }

    public static void main(String[] args) {
        SpringApplication.run(ShoeManagementAjaxApplication.class, args);
    }

}
