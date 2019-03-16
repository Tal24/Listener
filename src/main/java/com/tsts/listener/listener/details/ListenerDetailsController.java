package com.tsts.listener.listener.details;

import com.tsts.listener.domain.Listener;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Controller
public class ListenerDetailsController {

    private final ListenerRegistrationService listenerRegistrationService;

    public ListenerDetailsController (ListenerRegistrationService listenerRegistrationService) {
        this.listenerRegistrationService = listenerRegistrationService;
    }

    @PostMapping("register")
    public ResponseEntity<Listener> registerListener (@Valid @RequestBody Listener listener) {
        return ResponseEntity.ok(listenerRegistrationService.register(listener));
    }

}
