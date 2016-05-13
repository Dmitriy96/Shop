package by.bsuir.shop.util;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by dmitriy on 21.3.16.
 */

@Component
public class StoppedEventApplicationListener implements ApplicationListener<ContextStoppedEvent> {

    @Override
    public void onApplicationEvent(ContextStoppedEvent contextStoppedEvent) {
        System.out.println("------------------Context stopped event occurred");
    }
}
