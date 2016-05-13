package by.bsuir.shop.util;

import org.springframework.context.ApplicationEvent;

/**
 * Created by dmitriy on 21.3.16.
 */

public class MyEvent extends ApplicationEvent {

    public MyEvent(Object source) {
        super(source);
    }
}
