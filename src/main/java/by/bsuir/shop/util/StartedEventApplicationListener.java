package by.bsuir.shop.util;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by dmitriy on 21.3.16.
 */

@Component
public class StartedEventApplicationListener implements ApplicationListener<ContextStartedEvent> {

    @Override
    public void onApplicationEvent(ContextStartedEvent contextStartedEvent) {
        System.out.println("------------------Context started event occurred");
    }
}
