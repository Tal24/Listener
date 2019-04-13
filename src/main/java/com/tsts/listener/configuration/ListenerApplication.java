package com.tsts.listener.configuration;

import com.tsts.listener.client.messaging.show.liveshow.LiveShowEventConsumer;
import com.tsts.listener.client.messaging.show.newshow.NewShowEventConsumer;
import com.tsts.listener.client.rest.listenerdetails.ListenerDetailsController;
import com.tsts.listener.configuration.database.mongodb.MongoCustomConfiguration;
import com.tsts.listener.configuration.messaging.channels.NotificationsChannels;
import com.tsts.listener.configuration.messaging.channels.ShowChannels;
import com.tsts.listener.domain.listener.details.ListenerDetailsRepository;
import com.tsts.listener.domain.listener.details.ListenerDetailsService;
import com.tsts.listener.domain.listener.details.ListenerRegistrationService;
import com.tsts.listener.domain.show.details.ShowDetailsRepository;
import com.tsts.listener.domain.show.liveshow.LiveShowRepository;
import com.tsts.listener.domain.show.liveshow.LiveShowService;
import com.tsts.listener.domain.show.newshow.NewShowService;
import com.tsts.listener.infrastructure.NotificationMapper;
import com.tsts.listener.infrastructure.NotificationToListenersEventProducer;
import com.tsts.listener.mapper.listenerdetails.ListenerDetailsMapper;
import com.tsts.listener.mapper.show.ShowMapper;
import com.tsts.listener.mapper.show.liveshow.LiveShowMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableAutoConfiguration
@SpringBootConfiguration
@EnableBinding({ShowChannels.class, NotificationsChannels.class})
@EnableConfigurationProperties(MongoCustomConfiguration.class)
@EnableMongoRepositories(basePackageClasses = {ListenerDetailsRepository.class, ShowDetailsRepository.class, LiveShowRepository.class})
public class ListenerApplication {

    private final ListenerDetailsRepository listenerDetailsRepository;
    private final ShowDetailsRepository showDetailsRepository;
    private final LiveShowRepository liveShowRepository;
    private final NotificationsChannels notificationsChannels;

    public ListenerApplication (ListenerDetailsRepository listenerDetailsRepository,
                                ShowDetailsRepository showDetailsRepository, LiveShowRepository liveShowRepository,
                                NotificationsChannels notificationsChannels) {
        this.listenerDetailsRepository = listenerDetailsRepository;
        this.showDetailsRepository = showDetailsRepository;
        this.liveShowRepository = liveShowRepository;
        this.notificationsChannels = notificationsChannels;
    }

    public static void main (String[] args) {
        SpringApplication.run(ListenerApplication.class, args);
    }

    @Bean
    public ListenerDetailsController listenerDetailsController () {
        return new ListenerDetailsController(listenerRegistrationService(),
                listenerDetailsService(), listenerDetailsMapper());
    }

    @Bean
    public ListenerRegistrationService listenerRegistrationService () {
        return new ListenerRegistrationService(listenerDetailsRepository);
    }

    @Bean
    public ListenerDetailsService listenerDetailsService () {
        return new ListenerDetailsService(listenerDetailsRepository);
    }

    @Bean
    public NewShowEventConsumer newShowEventConsumer () {
        return new NewShowEventConsumer(newShowService(), showMapper());
    }

    @Bean
    public NewShowService newShowService () {
        return new NewShowService(listenerDetailsService(), pushNotificationService(), showDetailsRepository);
    }

    @Bean
    public LiveShowEventConsumer liveShowEventConsumer () {
        return new LiveShowEventConsumer(liveShowService(), liveShowMapper());
    }

    @Bean
    public LiveShowService liveShowService () {
        return new LiveShowService(liveShowRepository);
    }

    @Bean
    public NotificationToListenersEventProducer pushNotificationService () {
        return new NotificationToListenersEventProducer(notificationsChannels, notificationMapper());
    }

    @Bean
    public ListenerDetailsMapper listenerDetailsMapper() {
        return new ListenerDetailsMapper();
    }

    @Bean
    public LiveShowMapper liveShowMapper () {
        return new LiveShowMapper();
    }

    @Bean
    public ShowMapper showMapper () {
        return new ShowMapper();
    }

    @Bean
    public NotificationMapper notificationMapper () {
        return new NotificationMapper(showMapper(), listenerDetailsMapper());
    }

}
