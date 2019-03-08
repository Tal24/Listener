package com.tsts.listener.listener.details.database.mongo;

import com.tsts.listener.domain.Listener;
import com.tsts.listener.listener.details.ListenerDetailsRepository;
import com.tsts.listener.mongo.MongoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

@ConditionalOnBean(MongoConfiguration.class)
public interface ListenerDetailsMongoRepository extends MongoRepository<Listener, UUID>, ListenerDetailsRepository {
}
