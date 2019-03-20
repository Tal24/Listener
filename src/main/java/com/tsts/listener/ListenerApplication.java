package com.tsts.listener;

import com.tsts.listener.listener.details.ListenerDetailsController;
import com.tsts.listener.listener.details.ListenerDetailsRepository;
import com.tsts.listener.listener.details.ListenerDetailsService;
import com.tsts.listener.listener.details.ListenerRegistrationService;
import com.tsts.listener.notification.PushNotificationService;
import com.tsts.listener.show.liveshow.LiveShowEvent;
import com.tsts.listener.show.liveshow.LiveShowEventConsumer;
import com.tsts.listener.show.liveshow.LiveShowRepository;
import com.tsts.listener.show.liveshow.LiveShowService;
import com.tsts.listener.show.newshow.NewShowEvent;
import com.tsts.listener.show.newshow.NewShowEventConsumer;
import com.tsts.listener.show.newshow.NewShowService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;

@EnableAutoConfiguration
@SpringBootConfiguration
@EnableBinding({NewShowEvent.class, LiveShowEvent.class})
public class ListenerApplication {

    public static void main (String[] args) {
        SpringApplication.run(ListenerApplication.class, args);
    }

    @Bean
    public ListenerDetailsController listenerDetailsController (ListenerDetailsRepository listenerDetailsRepository) {
        return new ListenerDetailsController(listenerRegistrationService(listenerDetailsRepository), listenerDetailsService(listenerDetailsRepository));
    }

    @Bean
    public ListenerRegistrationService listenerRegistrationService (ListenerDetailsRepository listenerDetailsRepository) {
        return new ListenerRegistrationService(listenerDetailsRepository);
    }

    @Bean
    public ListenerDetailsService listenerDetailsService (ListenerDetailsRepository listenerDetailsRepository) {
        return new ListenerDetailsService(listenerDetailsRepository);
    }

    @Bean
    public NewShowEventConsumer newShowEventConsumer (ListenerDetailsRepository listenerDetailsRepository) {
        return new NewShowEventConsumer(newShowService(listenerDetailsRepository));
    }

    @Bean
    public NewShowService newShowService (ListenerDetailsRepository listenerDetailsRepository) {
        return new NewShowService(listenerDetailsService(listenerDetailsRepository), pushNotificationService());
    }

    @Bean
    public LiveShowEventConsumer liveShowEventConsumer (LiveShowRepository liveShowRepository) {
        return new LiveShowEventConsumer(liveShowService(liveShowRepository));
    }

    @Bean
    public LiveShowService liveShowService (LiveShowRepository liveShowRepository) {
        return new LiveShowService(liveShowRepository);
    }

    @Bean
    public PushNotificationService pushNotificationService () {
        return new PushNotificationService();
    }

}
