package com.tsts.listener.database.mongodb.configuration;

import com.mongodb.MongoClientOptions;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

@ConfigurationProperties(prefix = "spring.data.mongodb")
public class MongoCustomConfiguration {

    private int socketTimeout;

    @Bean
    public MongoClientOptions mongoClientOptions () {
        return MongoClientOptions.builder().socketTimeout(socketTimeout).build();
    }

    public int getSocketTimeout () {
        return socketTimeout;
    }

    public void setSocketTimeout (int socketTimeout) {
        this.socketTimeout = socketTimeout;
    }
}
