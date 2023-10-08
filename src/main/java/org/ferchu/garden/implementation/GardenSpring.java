package org.ferchu.garden.implementation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@EnableAspectJAutoProxy
@ComponentScan(basePackages = { "org.ferchu" })
@SpringBootApplication
public class GardenSpring {

    public static void main(String[] args) throws Exception {

        SpringApplication.run(GardenSpring.class, args);
    }
}
