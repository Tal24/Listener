package com.tsts.listener.mongo;

import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

@ConditionalOnProperty(value = "spring.datasource.name", havingValue = "mongo")
@ImportAutoConfiguration(MongoAutoConfiguration.class)
public class MongoConfiguration {
}