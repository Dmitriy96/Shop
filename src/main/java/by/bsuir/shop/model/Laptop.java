package by.bsuir.shop.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

@Entity
public class Laptop {

    @Id
    @GeneratedValue
    @Column
    private Long idLaptop;
    @NotBlank
    @Column
    private String brandName;
    @NotBlank
    @Column
    private String series;
    @NotBlank
    @Column
    private String modelNumber;
    @NotBlank
    @Column
    private String operatingSystem;
    @NotNull
    @Column
    private Double weight;
    @NotNull
    @Column
    private Integer dimensionL;
    @NotNull
    @Column
    private Integer dimensionW;
    @NotNull
    @Column
    private Integer dimensionH;
    @NotBlank
    @Column
    private String color;
    @NotBlank
    @Column
    private String batteryType;
    @NotNull
    @Column
    private Integer averageBatteryLife;
    @NotNull
    @Column
    private Double screenSize;
    @NotNull
    @Column
    private Integer screenResolutionY;
    @NotNull
    @Column
    private Integer screenResolutionX;
    @NotBlank
    @Column
    private String processorBrand;
    @NotBlank
    @Column
    private String processorModel;
    @NotNull
    @Column
    private Integer processorClockFrequency;
    @NotNull
    @Column
    private Integer processorCount;
    @NotBlank
    @Column
    private String memoryType;
    @NotNull
    @Column
    private Integer memorySize;
    @NotNull
    @Column
    private Integer hardDriveCapacity;
    @NotNull
    @Column
    private Integer hardDriveRotationalSpeed;
    @NotNull
    @Column
    private Integer USB2_0Count;
    @NotNull
    @Column
    private Integer USB3_0Count;
    @DecimalMin("1")
    @Column
    private Double cost;
    @Column(columnDefinition = "BIT")
    private boolean available;


    public Laptop() {}

    public Long getIdLaptop() {
        return idLaptop;
    }

    public void setIdLaptop(Long idLaptop) {
        this.idLaptop = idLaptop;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Integer getDimensionL() {
        return dimensionL;
    }

    public void setDimensionL(Integer dimensionL) {
        this.dimensionL = dimensionL;
    }

    public Integer getDimensionW() {
        return dimensionW;
    }

    public void setDimensionW(Integer dimensionW) {
        this.dimensionW = dimensionW;
    }

    public Integer getDimensionH() {
        return dimensionH;
    }

    public void setDimensionH(Integer dimensionH) {
        this.dimensionH = dimensionH;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBatteryType() {
        return batteryType;
    }

    public void setBatteryType(String batteryType) {
        this.batteryType = batteryType;
    }

    public Integer getAverageBatteryLife() {
        return averageBatteryLife;
    }

    public void setAverageBatteryLife(Integer averageBatteryLife) {
        this.averageBatteryLife = averageBatteryLife;
    }

    public Double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(Double screenSize) {
        this.screenSize = screenSize;
    }

    public Integer getScreenResolutionY() {
        return screenResolutionY;
    }

    public void setScreenResolutionY(Integer screenResolutionY) {
        this.screenResolutionY = screenResolutionY;
    }

    public Integer getScreenResolutionX() {
        return screenResolutionX;
    }

    public void setScreenResolutionX(Integer screenResolutionX) {
        this.screenResolutionX = screenResolutionX;
    }

    public String getProcessorBrand() {
        return processorBrand;
    }

    public void setProcessorBrand(String processorBrand) {
        this.processorBrand = processorBrand;
    }

    public String getProcessorModel() {
        return processorModel;
    }

    public void setProcessorModel(String processorModel) {
        this.processorModel = processorModel;
    }

    public Integer getProcessorClockFrequency() {
        return processorClockFrequency;
    }

    public void setProcessorClockFrequency(Integer processorClockFrequency) {
        this.processorClockFrequency = processorClockFrequency;
    }

    public Integer getProcessorCount() {
        return processorCount;
    }

    public void setProcessorCount(Integer processorCount) {
        this.processorCount = processorCount;
    }

    public String getMemoryType() {
        return memoryType;
    }

    public void setMemoryType(String memoryType) {
        this.memoryType = memoryType;
    }

    public Integer getMemorySize() {
        return memorySize;
    }

    public void setMemorySize(Integer memorySize) {
        this.memorySize = memorySize;
    }

    public Integer getHardDriveCapacity() {
        return hardDriveCapacity;
    }

    public void setHardDriveCapacity(Integer hardDriveCapacity) {
        this.hardDriveCapacity = hardDriveCapacity;
    }

    public Integer getHardDriveRotationalSpeed() {
        return hardDriveRotationalSpeed;
    }

    public void setHardDriveRotationalSpeed(Integer hardDriveRotationalSpeed) {
        this.hardDriveRotationalSpeed = hardDriveRotationalSpeed;
    }

    public Integer getUSB2_0Count() {
        return USB2_0Count;
    }

    public void setUSB2_0Count(Integer USB2_0Count) {
        this.USB2_0Count = USB2_0Count;
    }

    public Integer getUSB3_0Count() {
        return USB3_0Count;
    }

    public void setUSB3_0Count(Integer USB3_0Count) {
        this.USB3_0Count = USB3_0Count;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Laptop)) return false;

        Laptop laptop = (Laptop) o;

        if (available != laptop.available) return false;
        if (!idLaptop.equals(laptop.idLaptop)) return false;
        if (!brandName.equals(laptop.brandName)) return false;
        if (!series.equals(laptop.series)) return false;
        if (!modelNumber.equals(laptop.modelNumber)) return false;
        if (!operatingSystem.equals(laptop.operatingSystem)) return false;
        if (!weight.equals(laptop.weight)) return false;
        if (!dimensionL.equals(laptop.dimensionL)) return false;
        if (!dimensionW.equals(laptop.dimensionW)) return false;
        if (!dimensionH.equals(laptop.dimensionH)) return false;
        if (!color.equals(laptop.color)) return false;
        if (!batteryType.equals(laptop.batteryType)) return false;
        if (!averageBatteryLife.equals(laptop.averageBatteryLife)) return false;
        if (!screenSize.equals(laptop.screenSize)) return false;
        if (!screenResolutionY.equals(laptop.screenResolutionY)) return false;
        if (!screenResolutionX.equals(laptop.screenResolutionX)) return false;
        if (!processorBrand.equals(laptop.processorBrand)) return false;
        if (!processorModel.equals(laptop.processorModel)) return false;
        if (!processorClockFrequency.equals(laptop.processorClockFrequency)) return false;
        if (!processorCount.equals(laptop.processorCount)) return false;
        if (!memoryType.equals(laptop.memoryType)) return false;
        if (!memorySize.equals(laptop.memorySize)) return false;
        if (!hardDriveCapacity.equals(laptop.hardDriveCapacity)) return false;
        if (!hardDriveRotationalSpeed.equals(laptop.hardDriveRotationalSpeed)) return false;
        if (!USB2_0Count.equals(laptop.USB2_0Count)) return false;
        if (!USB3_0Count.equals(laptop.USB3_0Count)) return false;
        return cost.equals(laptop.cost);

    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + brandName.hashCode();
        result = 31 * result + series.hashCode();
        result = 31 * result + modelNumber.hashCode();
        result = 31 * result + operatingSystem.hashCode();
        result = 31 * result + weight.hashCode();
        result = 31 * result + dimensionL.hashCode();
        result = 31 * result + dimensionW.hashCode();
        result = 31 * result + dimensionH.hashCode();
        result = 31 * result + color.hashCode();
        result = 31 * result + batteryType.hashCode();
        result = 31 * result + averageBatteryLife.hashCode();
        result = 31 * result + screenSize.hashCode();
        result = 31 * result + screenResolutionY.hashCode();
        result = 31 * result + screenResolutionX.hashCode();
        result = 31 * result + processorBrand.hashCode();
        result = 31 * result + processorModel.hashCode();
        result = 31 * result + processorClockFrequency.hashCode();
        result = 31 * result + processorCount.hashCode();
        result = 31 * result + memoryType.hashCode();
        result = 31 * result + memorySize.hashCode();
        result = 31 * result + hardDriveCapacity.hashCode();
        result = 31 * result + hardDriveRotationalSpeed.hashCode();
        result = 31 * result + USB2_0Count.hashCode();
        result = 31 * result + USB3_0Count.hashCode();
        result = 31 * result + cost.hashCode();
        result = 31 * result + (available ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "idLaptop=" + idLaptop +
                ", brandName='" + brandName + '\'' +
                ", series='" + series + '\'' +
                ", modelNumber='" + modelNumber + '\'' +
                ", operatingSystem='" + operatingSystem + '\'' +
                ", weight=" + weight +
                ", dimensionL=" + dimensionL +
                ", dimensionW=" + dimensionW +
                ", dimensionH=" + dimensionH +
                ", color='" + color + '\'' +
                ", batteryType='" + batteryType + '\'' +
                ", averageBatteryLife=" + averageBatteryLife +
                ", screenSize=" + screenSize +
                ", screenResolutionY=" + screenResolutionY +
                ", screenResolutionX=" + screenResolutionX +
                ", processorBrand='" + processorBrand + '\'' +
                ", processorModel='" + processorModel + '\'' +
                ", processorClockFrequency=" + processorClockFrequency +
                ", processorCount=" + processorCount +
                ", memoryType='" + memoryType + '\'' +
                ", memorySize=" + memorySize +
                ", hardDriveCapacity=" + hardDriveCapacity +
                ", hardDriveRotationalSpeed=" + hardDriveRotationalSpeed +
                ", USB2_0Count=" + USB2_0Count +
                ", USB3_0Count=" + USB3_0Count +
                ", cost=" + cost +
                ", available=" + available +
                '}';
    }
}
