package com.tsts.listener.domain.details;

import com.tsts.listener.BaseIT;
import com.tsts.listener.domain.entity.Listener;
import com.tsts.listener.domain.entity.Name;
import com.tsts.listener.domain.entity.PhoneNumber;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.text.MessageFormat;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class ListenerDetailsIT extends BaseIT {

    @Autowired
    private ListenerDetailsRepository listenerDetailsRepository;

    @Before
    public void setUp () {
        listenerDetailsRepository.deleteAll();
    }

    @Test
    public void registerShouldSaveListenerDetailsSuccessfully () {
        UUID id = UUID.randomUUID();
        Listener listener = new Listener(id, new Name("John"), new Name("Red"), new PhoneNumber("0505-999999"));

        ResponseEntity<Listener> saveResponse = testRestTemplate.postForEntity("/register", listener, Listener.class);
        ResponseEntity<Listener> getResponse = testRestTemplate.getForEntity(MessageFormat.format("/listener/{0}", id.toString()),
                Listener.class);

        assertThat(saveResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(saveResponse.getBody()).isEqualTo(listener);
        assertThat(getResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(getResponse.getBody()).isEqualTo(listener);
    }

}
