package com.tsts.listener.show.details;

import com.tsts.listener.domain.Name;
import com.tsts.listener.domain.Show;
import org.springframework.data.repository.CrudRepository;

public interface ShowDetailsRepository extends CrudRepository<Show, Name> {
}