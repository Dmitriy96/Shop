package by.bsuir.shop.util;

import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;


public class LaptopSample {
    private Integer clockFrom;
    private Integer clockTo;
    private Integer procCountFrom;
    private Integer procCountTo;
    private String brand;
    private String model;
    private String screen;
    private Integer capacity;
    private Integer memory;

    public Criterion buildHibernateCriterion()
    {
        Conjunction conjunction = Restrictions.conjunction();
        if (getClockFrom() != null)
            conjunction.add(Restrictions.ge("clockFrom", getClockFrom()));
        if (getClockTo() != null)
            conjunction.add(Restrictions.ge("clockTo", getClockTo()));
        if (getProcCountFrom() != null)
            conjunction.add(Restrictions.ge("procCountFrom", getProcCountFrom()));
        if (getProcCountTo() != null)
            conjunction.add(Restrictions.ge("procCountTo", getProcCountTo()));
        if (getBrand() != null)
            conjunction.add(Restrictions.eq("brand", getBrand()));
        if (getModel() != null)
            conjunction.add(Restrictions.eq("model", getModel()));
        if (getScreen() != null)
            conjunction.add(Restrictions.eq("screen", getScreen()));
        if (getCapacity() != null)
            conjunction.add(Restrictions.eq("capacity", getCapacity()));
        if (getMemory() != null)
            conjunction.add(Restrictions.eq("memory", getMemory()));
        return conjunction;
    }

    public Integer getClockFrom() {
        return clockFrom;
    }

    public void setClockFrom(Integer clockFrom) {
        this.clockFrom = clockFrom;
    }

    public Integer getClockTo() {
        return clockTo;
    }

    public void setClockTo(Integer clockTo) {
        this.clockTo = clockTo;
    }

    public Integer getProcCountFrom() {
        return procCountFrom;
    }

    public void setProcCountFrom(Integer procCountFrom) {
        this.procCountFrom = procCountFrom;
    }

    public Integer getProcCountTo() {
        return procCountTo;
    }

    public void setProcCountTo(Integer procCountTo) {
        this.procCountTo = procCountTo;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getScreen() {
        return screen;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getMemory() {
        return memory;
    }

    public void setMemory(Integer memory) {
        this.memory = memory;
    }
}
