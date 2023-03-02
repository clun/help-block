package com.telusko.block.config;

import com.datastax.astra.sdk.AstraClient;
import com.datastax.oss.driver.api.core.CqlSession;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

import java.nio.file.Paths;

/**
 * Configuration.
 */
@Configuration
@EnableCassandraRepositories
public class AstraConfiguration {

    @Value("${astra.token}")
    private String token;

    @Value("${astra.db.id}")
    private String databaseId;

    @Value("${astra.db.region}")
    private String databaseRegion;

    @Value("${astra.db.keyspace}")
    private String keyspace;

    @Bean
    public CqlSession cqlSession() {
        return AstraClient.builder()
                .withToken(token)
                .withDatabaseRegion(databaseRegion)
                .withDatabaseId(databaseId)
                .withCqlKeyspace(keyspace)
                .enableCql().enableDownloadSecureConnectBundle()
                .build().cqlSession();
    }
}



