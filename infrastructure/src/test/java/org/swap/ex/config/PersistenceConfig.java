package org.swap.ex.config;


import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.TestPropertySource;

@Configuration
@EnableJpaRepositories(basePackages = {
        "org.swap.ex.repository"
})
@EntityScan(basePackages = "org.swap.ex.entity")
@TestPropertySource("classpath:application-test.properties")
public class PersistenceConfig {
}
