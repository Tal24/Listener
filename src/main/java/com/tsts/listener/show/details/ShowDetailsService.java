package com.tsts.listener.show.details;

import com.tsts.listener.domain.Name;
import com.tsts.listener.domain.Show;

public class ShowDetailsService {

    private final ShowDetailsRepository showDetailsRepository;

    public ShowDetailsService (ShowDetailsRepository showDetailsRepository) {
        this.showDetailsRepository = showDetailsRepository;
    }

    public boolean allowsListenersTalk (Name showName) {
        Show show = showDetailsRepository.findById(showName).orElseThrow(() -> new ShowNotFoundException(showName.get()));
        return show.listenersAllowedToCall();
    }

}
