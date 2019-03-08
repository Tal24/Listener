package com.tsts.listener.couchbase;


import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.couchbase.CouchbaseAutoConfiguration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;

import java.util.Collections;
import java.util.List;

@ConditionalOnProperty(value = "db", havingValue = "couchbase")
@ImportAutoConfiguration(classes = {CouchbaseAutoConfiguration.class})
public class CouchbaseConfiguration extends AbstractCouchbaseConfiguration {

    @Override
    protected List<String> getBootstrapHosts () {
        return Collections.singletonList("localhost");
    }

    @Override
    protected String getBucketName () {
        return "listener";
    }

    @Override
    protected String getBucketPassword () {
        return "Administrator";
    }
}
