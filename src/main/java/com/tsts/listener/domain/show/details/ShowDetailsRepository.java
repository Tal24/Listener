package com.tsts.listener.domain.show.details;

import com.tsts.listener.domain.entity.Name;
import com.tsts.listener.domain.entity.Show;
import org.springframework.data.repository.CrudRepository;

public interface ShowDetailsRepository extends CrudRepository<Show, Name> {
}