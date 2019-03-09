package com.tsts.listener;

import com.tsts.listener.couchbase.CouchbaseConfiguration;
import com.tsts.listener.listener.details.ListenerDetailsController;
import com.tsts.listener.listener.details.ListenerDetailsRepository;
import com.tsts.listener.listener.details.ListenerRegistrationService;
import com.tsts.listener.mongo.MongoConfiguration;
import com.tsts.listener.newshow.NewShowEvent;
import com.tsts.listener.newshow.NewShowEventConsumer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.couchbase.CouchbaseAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;

@EnableAutoConfiguration(exclude = {MongoAutoConfiguration.class, CouchbaseAutoConfiguration.class})
@SpringBootConfiguration
@ImportAutoConfiguration({MongoConfiguration.class, CouchbaseConfiguration.class})
@EnableBinding(NewShowEvent.class)
public class ListenerApplication {

    public static void main (String[] args) {
        SpringApplication.run(ListenerApplication.class, args);
    }

    @Bean
    public ListenerDetailsController listenerDetailsController (ListenerDetailsRepository listenerDetailsRepository) {
        return new ListenerDetailsController(listenerRegistrationService(listenerDetailsRepository));
    }

    @Bean
    public ListenerRegistrationService listenerRegistrationService (ListenerDetailsRepository listenerDetailsRepository) {
        return new ListenerRegistrationService(listenerDetailsRepository);
    }

    @Bean
    public NewShowEventConsumer newShowEventConsumer () {
        return new NewShowEventConsumer();
    }

}
