package com.tsts.listener.show.liveshow;

import com.tsts.listener.domain.Name;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface LiveShowRepository extends CrudRepository<LiveShow, Name> {

    default Optional<LiveShow> getLiveShow () {
        return findTopBy();
    }

    Optional<LiveShow> findTopBy ();

}
