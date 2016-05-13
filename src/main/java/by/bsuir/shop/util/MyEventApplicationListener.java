package by.bsuir.shop.util;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Created by dmitriy on 21.3.16.
 */

@Component
public class MyEventApplicationListener implements ApplicationListener<MyEvent> {
    @Override
    public void onApplicationEvent(MyEvent myEvent) {
        System.out.println("------------------My event occurred");
    }
}
