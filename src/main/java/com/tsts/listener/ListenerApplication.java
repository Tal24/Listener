package com.tsts.listener;

import com.tsts.listener.couchbase.CouchbaseConfiguration;
import com.tsts.listener.listener.details.ListenerDetailsController;
import com.tsts.listener.listener.details.ListenerDetailsRepository;
import com.tsts.listener.mongo.MongoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@EnableAutoConfiguration
@SpringBootConfiguration
@Import({MongoConfiguration.class, CouchbaseConfiguration.class})
public class ListenerApplication {

    public static void main (String[] args) {
        SpringApplication.run(ListenerApplication.class, args);
    }

    @Bean
    public ListenerDetailsController listenerDetailsController (ListenerDetailsRepository listenerDetailsRepository) {
        return new ListenerDetailsController(listenerDetailsRepository);
    }

}
