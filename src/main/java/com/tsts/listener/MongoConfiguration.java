package com.tsts.listener;

import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

@ConditionalOnProperty(value = "db", havingValue = "mongo")
@ImportAutoConfiguration(classes = {MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})
public class MongoConfiguration {
}
