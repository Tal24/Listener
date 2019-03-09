package com.tsts.listener.listener.details;

import com.tsts.listener.domain.Category;
import com.tsts.listener.domain.Listener;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface ListenerDetailsRepository extends CrudRepository<Listener, UUID> {

    List<Listener> findAllByFavoriteCategoriesContaining (Category category);

}
