package com.tsts.listener.show.liveshow;

import com.tsts.listener.domain.Name;
import org.springframework.data.repository.CrudRepository;

public interface LiveShowRepository extends CrudRepository<LiveShow, Name> {
}
