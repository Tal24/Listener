package com.tsts.listener.couchbase;


import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.couchbase.CouchbaseAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;

import java.util.Collections;
import java.util.List;

@ConditionalOnProperty(value = "db", havingValue = "couchbase")
@ImportAutoConfiguration(CouchbaseAutoConfiguration.class)
@ConfigurationProperties(prefix = "spring.data.couchbase")
public class CouchbaseConfiguration extends AbstractCouchbaseConfiguration {

    private String host;

    public void setHost (String host) {
        this.host = host;
    }

    @Override
    protected List<String> getBootstrapHosts () {
        return Collections.singletonList(host);
    }

    @Override
    protected String getBucketName () {
        return "listener";
    }

    @Override
    protected String getBucketPassword () {
        return "listener";
    }
}
