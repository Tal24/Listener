package com.tsts.listener.client.rest.listenerdetails;

import com.tsts.listener.domain.entity.Listener;
import com.tsts.listener.domain.listener.details.ListenerDetailsService;
import com.tsts.listener.domain.listener.details.ListenerRegistrationService;
import com.tsts.listener.dto.listenerdetails.ListenerDTO;
import com.tsts.listener.mapper.listenerdetails.ListenerDetailsMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class ListenerDetailsController {

    private final ListenerRegistrationService listenerRegistrationService;
    private final ListenerDetailsService listenerDetailsService;
    private final ListenerDetailsMapper listenerDetailsMapper;

    public ListenerDetailsController (ListenerRegistrationService listenerRegistrationService,
                                      ListenerDetailsService listenerDetailsService,
                                      ListenerDetailsMapper listenerDetailsMapper) {
        this.listenerRegistrationService = listenerRegistrationService;
        this.listenerDetailsService = listenerDetailsService;
        this.listenerDetailsMapper = listenerDetailsMapper;
    }

    @GetMapping("/listener/{id}")
    public ResponseEntity<ListenerDTO> getListenerDetails (@PathVariable String id) {
        return listenerDetailsService.getListenerDetails(id).map(listenerDetailsMapper::mapToListenerDTO).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @ExceptionHandler
    public ResponseEntity<String> handleIllegalArgumentException (IllegalArgumentException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @PostMapping("register")
    public ResponseEntity<ListenerDTO> registerListener (@Valid @RequestBody ListenerDTO listenerDTO) {
        Listener listener = listenerRegistrationService.register(listenerDetailsMapper.mapToListener(listenerDTO));
        return ResponseEntity.ok(listenerDetailsMapper.mapToListenerDTO(listener));
    }

}
