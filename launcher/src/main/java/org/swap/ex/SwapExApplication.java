package org.swap.ex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"org.swap.ex"})
public class SwapExApplication {


    public static void main(String[] args) {
        SpringApplication.run(SwapExApplication.class, args);
    }
}
