package com.tsts.listener;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.UUID;

@Controller
public class ListenerDetailsController {

    private final ListenerDetailsRepository listenerDetailsRepository;

    public ListenerDetailsController (ListenerDetailsRepository listenerDetailsRepository) {
        this.listenerDetailsRepository = listenerDetailsRepository;
    }

    @GetMapping
    public ResponseEntity<String> getYoungestListener () {

        System.out.println("Who Is The Youngest");
        Listener listener = new Listener(UUID.randomUUID(), new Name("Tal"), new Name("Red"), LocalDate.of(2000, 1, 10));
        listenerDetailsRepository.save(listener);
        return ResponseEntity.ok("Who Is The Youngest");
    }

}
