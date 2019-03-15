package com.tsts.listener.show.liveshow;

import java.util.Optional;

public class LiveShowService {

    private final LiveShowRepository liveShowRepository;

    public LiveShowService (LiveShowRepository liveShowRepository) {
        this.liveShowRepository = liveShowRepository;
    }

    public void handleLiveShowEvent (LiveShow show) {
        liveShowRepository.save(show);
    }

    public Optional<LiveShow> getLiveShow () {
        return liveShowRepository.getLiveShow();
    }
}
