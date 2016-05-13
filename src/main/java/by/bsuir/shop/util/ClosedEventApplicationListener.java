package by.bsuir.shop.util;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by dmitriy on 21.3.16.
 */

@Component
public class ClosedEventApplicationListener implements ApplicationListener<ContextClosedEvent> {

    @Override
    public void onApplicationEvent(ContextClosedEvent contextClosedEvent) {
        System.out.println("------------------Context closed event occurred");
    }
}
