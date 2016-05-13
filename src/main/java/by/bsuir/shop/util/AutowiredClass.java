package by.bsuir.shop.util;

import org.springframework.stereotype.Component;

/**
 * Created by dmitriy on 18.3.16.
 */

@Component
public class AutowiredClass {
    private String className;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
