package org.swap.ex.config;

import org.h2.tools.Server;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.sql.SQLException;

@DataJpaTest
@ContextConfiguration(classes = {PersistenceConfig.class})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@EnableTransactionManagement
public class TestConfig {

    private static Server server;

    @BeforeAll
    public static void beforeTest() throws SQLException {
        getServerInstance();
    }

    @AfterAll
    public static void afterTest() throws SQLException {

        getServerInstance().stop();

    }

    public static synchronized Server getServerInstance() {
        try {
            if (server == null) {
                server = Server.createWebServer("-web", "-webAllowOthers", "-webPort", "8083");
            }
        } catch (Exception e) {
            throw new RuntimeException("Exception occured in creating singleton instance");
        }
        return server;
    }
}
