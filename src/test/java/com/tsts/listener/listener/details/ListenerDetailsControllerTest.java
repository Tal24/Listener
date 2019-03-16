package com.tsts.listener.listener.details;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tsts.listener.domain.Listener;
import com.tsts.listener.domain.Name;
import com.tsts.listener.domain.PhoneNumber;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.OverrideAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ListenerDetailsController.class)
@OverrideAutoConfiguration(enabled = true)
public class ListenerDetailsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ListenerRegistrationService listenerRegistrationService;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void registerShouldReturnSavedListenerDetails () throws Exception {
        UUID id = UUID.randomUUID();
        Listener listener = new Listener(id, new Name("John"), new Name("Red"), new PhoneNumber("0505-999999"));
        when(listenerRegistrationService.register(listener)).thenReturn(listener);
        String listenerJsonRepresentation = objectMapper.writeValueAsString(listener);
        mockMvc.perform(post("/register").contentType(MediaType.APPLICATION_JSON).content(listenerJsonRepresentation))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.id", is(id.toString())))
               .andExpect(jsonPath("$.firstName", is("John")))
               .andExpect(jsonPath("$.lastName", is("Red")))
               .andExpect(jsonPath("$.phoneNumber", is("0505-999999")));
    }

}
