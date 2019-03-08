package com.tsts.listener;


import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.couchbase.CouchbaseAutoConfiguration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;

import java.util.Arrays;
import java.util.List;

@ConditionalOnProperty(value = "db", havingValue = "couchbase")
@EnableCouchbaseRepositories
@ImportAutoConfiguration(classes = {CouchbaseAutoConfiguration.class})
public class CouchbaseConfiguration extends AbstractCouchbaseConfiguration {

    @Override
    protected List<String> getBootstrapHosts () {
        return Arrays.asList("localhost");
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
