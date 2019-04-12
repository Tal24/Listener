package com.tsts.listener.domain.listener.details;

import com.tsts.listener.domain.entity.Category;
import com.tsts.listener.domain.entity.Listener;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface ListenerDetailsRepository extends CrudRepository<Listener, UUID> {

    List<Listener> findAllByFavoriteCategoriesContaining (Category category);

}
