package com.tsts.listener.domain.show.liveshow;

import com.tsts.listener.domain.entity.Name;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface LiveShowRepository extends CrudRepository<LiveShow, Name> {

    default Optional<LiveShow> getLiveShow () {
        return findTopBy();
    }

    Optional<LiveShow> findTopBy ();

}
