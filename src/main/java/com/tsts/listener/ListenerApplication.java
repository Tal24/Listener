package com.tsts.listener;

import com.tsts.listener.database.mongodb.configuration.MongoCustomConfiguration;
import com.tsts.listener.listener.details.ListenerDetailsController;
import com.tsts.listener.listener.details.ListenerDetailsRepository;
import com.tsts.listener.listener.details.ListenerDetailsService;
import com.tsts.listener.listener.details.ListenerRegistrationService;
import com.tsts.listener.notification.NotificationsChannels;
import com.tsts.listener.notification.PushNotificationToListenersService;
import com.tsts.listener.show.ShowChannels;
import com.tsts.listener.show.details.ShowDetailsRepository;
import com.tsts.listener.show.liveshow.LiveShowEventConsumer;
import com.tsts.listener.show.liveshow.LiveShowRepository;
import com.tsts.listener.show.liveshow.LiveShowService;
import com.tsts.listener.show.newshow.NewShowEventConsumer;
import com.tsts.listener.show.newshow.NewShowService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;

@EnableAutoConfiguration
@SpringBootConfiguration
@EnableBinding({ShowChannels.class, NotificationsChannels.class})
@EnableConfigurationProperties(MongoCustomConfiguration.class)
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
                listenerDetailsService());
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
        return new NewShowEventConsumer(newShowService());
    }

    @Bean
    public NewShowService newShowService () {
        return new NewShowService(listenerDetailsService(), pushNotificationService(), showDetailsRepository);
    }

    @Bean
    public LiveShowEventConsumer liveShowEventConsumer () {
        return new LiveShowEventConsumer(liveShowService());
    }

    @Bean
    public LiveShowService liveShowService () {
        return new LiveShowService(liveShowRepository);
    }

    @Bean
    public PushNotificationToListenersService pushNotificationService () {
        return new PushNotificationToListenersService(notificationsChannels);
    }

}
