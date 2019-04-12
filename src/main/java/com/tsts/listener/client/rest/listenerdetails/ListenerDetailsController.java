package com.tsts.listener.client.rest.listenerdetails;

import com.tsts.listener.domain.details.ListenerDetailsService;
import com.tsts.listener.domain.details.ListenerRegistrationService;
import com.tsts.listener.domain.entity.Listener;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class ListenerDetailsController {

    private final ListenerRegistrationService listenerRegistrationService;
    private final ListenerDetailsService listenerDetailsService;

    public ListenerDetailsController (ListenerRegistrationService listenerRegistrationService,
                                      ListenerDetailsService listenerDetailsService) {
        this.listenerRegistrationService = listenerRegistrationService;
        this.listenerDetailsService = listenerDetailsService;
    }

    @GetMapping("/listener/{id}")
    public ResponseEntity<Listener> getListenerDetails (@PathVariable String id) {
        return listenerDetailsService.getListenerDetails(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @ExceptionHandler
    public ResponseEntity<String> handleIllegalArgumentException (IllegalArgumentException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @PostMapping("register")
    public ResponseEntity<Listener> registerListener (@Valid @RequestBody Listener listener) {
        return ResponseEntity.ok(listenerRegistrationService.register(listener));
    }

}
