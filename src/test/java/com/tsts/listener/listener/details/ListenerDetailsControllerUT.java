package com.tsts.listener.listener.details;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tsts.listener.domain.Listener;
import com.tsts.listener.domain.Name;
import com.tsts.listener.domain.PhoneNumber;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.UUID;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(MockitoJUnitRunner.class)
public class ListenerDetailsControllerUT {

    private MockMvc mockMvc;

    private ListenerDetailsController listenerDetailsController;

    @Mock
    private ListenerRegistrationService listenerRegistrationService;

    @Mock
    private ListenerDetailsService listenerDetailsService;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Before
    public void setUp () {
        listenerDetailsController = new ListenerDetailsController(listenerRegistrationService, listenerDetailsService);
        mockMvc = MockMvcBuilders.standaloneSetup(listenerDetailsController).build();
    }

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
