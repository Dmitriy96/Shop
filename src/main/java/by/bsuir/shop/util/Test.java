package by.bsuir.shop.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by dmitriy on 17.3.16.
 */

@Component
public class Test {

    private String name;

    @Autowired
    private ApplicationEventPublisher publisher;

    public Test() {
        System.out.println("------------------Constructor of Test called");
    }

    @Autowired
    public Test(AutowiredClass autowiredClass) {
        System.out.println("------------------Constructor with parameter of Test called");
    }

    public void execute() {
        System.out.println("------------------Execute method of Test called");
        MyEvent myEvent = new MyEvent("my event");
        publisher.publishEvent(myEvent);
    }

    @PostConstruct
    public void initTest() {
        System.out.println("------------------Init method of Test called");
    }

    @PreDestroy
    public void destroyTest() {
        System.out.println("------------------Destroy method of Test called");
    }

    public ApplicationEventPublisher getPublisher() {
        return publisher;
    }

    public void setPublisher(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
