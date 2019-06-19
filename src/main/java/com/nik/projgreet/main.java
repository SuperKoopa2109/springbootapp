package com.nik.projgreet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import java.util.Collections;

@SpringBootApplication
public class main extends SpringBootServletInitializer {
    public String getGreeting() {
        return "Hello world.";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication app = new SpringApplication(main.class);
        app.setDefaultProperties(Collections.singletonMap("server.port", "9011"));
        app.run(args);

        /*
        SpringApplication.run(main.class, args);
        System.out.println(new main().getGreeting());
*/
    }


    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(getClass());
    }

}