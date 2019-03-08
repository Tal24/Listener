package com.tsts.listener.listener.details.database.couchbase;

import com.tsts.listener.couchbase.CouchbaseConfiguration;
import com.tsts.listener.domain.Listener;
import com.tsts.listener.listener.details.ListenerDetailsRepository;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.data.couchbase.repository.CouchbaseRepository;

import java.util.UUID;

@ConditionalOnBean(CouchbaseConfiguration.class)
public interface ListenerDetailsCouchbaseRepository extends CouchbaseRepository<Listener, UUID>, ListenerDetailsRepository {
}
