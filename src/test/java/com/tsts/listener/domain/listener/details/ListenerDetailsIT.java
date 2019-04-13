package com.tsts.listener.domain.listener.details;

import com.tsts.listener.BaseIT;
import com.tsts.listener.dto.listenerdetails.ListenerDTO;
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
        String id = UUID.randomUUID().toString();
        ListenerDTO listenerDTO = ListenerDTO.builder(id, "John", "Red", "0505-999999").build();

        ResponseEntity<ListenerDTO> saveResponse = testRestTemplate.postForEntity("/register", listenerDTO, ListenerDTO.class);
        ResponseEntity<ListenerDTO> getResponse = testRestTemplate.getForEntity(MessageFormat.format("/listener/{0}", id), ListenerDTO.class);

        assertThat(saveResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(saveResponse.getBody()).isEqualTo(listenerDTO);
        assertThat(getResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(getResponse.getBody()).isEqualTo(listenerDTO);
    }

}
