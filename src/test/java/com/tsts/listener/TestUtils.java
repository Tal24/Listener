package com.tsts.listener;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cloud.stream.test.binder.MessageCollector;
import org.springframework.messaging.MessageChannel;

public class TestUtils {

    private static ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    public static <T> T getMessagePayload (MessageCollector messageCollector, MessageChannel messageChannel, Class<T> eventType) throws Exception {
        return objectMapper.readValue(messageCollector.forChannel(messageChannel).remove().getPayload().toString(), eventType);
    }

}
