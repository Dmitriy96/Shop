package by.bsuir.shop.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * Created by dmitriy on 17.3.16.
 */
public class Main {
    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext("by.bsuir.shop.util");
        context.registerShutdownHook();
        Test test = (Test) context.getBean("test");
        test.execute();
    }
}
