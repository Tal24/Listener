package com.tsts.listener.mongo;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

@ConditionalOnProperty(value = "db", havingValue = "mongo")
public class MongoConfiguration {
}
