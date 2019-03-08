package com.tsts.listener;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ListenerDetailsRepository extends CrudRepository<Listener, UUID> {
}
