package com.telusko.block;

import com.datastax.oss.driver.api.core.CqlSession;
import com.telusko.block.tokens.TokenRepository;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.cassandra.core.CassandraTemplate;

/**
 * Main Application as a Spring Boot Application
 */
@SpringBootApplication
public class SampleBlockApplication {

    public static final Logger LOGGER = LoggerFactory.getLogger(SampleBlockApplication.class);

    @Autowired
    CqlSession cqlSession;

    @Autowired
    CassandraTemplate cassandraTemplate;

    @Autowired
    TokenRepository tokenRepository;

	@PostConstruct
    public void showAstraConnection() {
        String dcName = cqlSession
                .execute("SELECT data_center from system.local")
                .one().getString("data_center");
        LOGGER.info("Your are now connected to Astra on region '{}'", dcName);
        LOGGER.info("Open http://localhost:8080/tokens/{}", "0x274896f9fa9d92d907d904c07ac50d674e7c710d");
    }

    public static void main(String[] args) {
        SpringApplication.run(SampleBlockApplication.class, args);
    }


}