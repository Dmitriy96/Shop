package by.bsuir.shop.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.ui.Model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


@Configuration
@PropertySource("classpath:config.properties")
public class LaptopAttributes {

    @Value("${laptop.brandName}")
    private String[] brandName;

    @Value("${laptop.operatingSystem}")
    private String[] operatingSystem;

    @Value("${processor.brand}")
    private String[] processorBrand;

    @Value("${processor.model}")
    private String[] processorModel;

    @Value("${processor.memory}")
    private String[] memoryType;


    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    public void completeModel(Model model) {
        Map<String, String> brandMap = new HashMap<String, String>();
        for (String brand : Arrays.asList(getBrandName())) {
            brandMap.put(brand, brand);
        }
        model.addAttribute("brandNameMap", brandMap);
        Map<String, String> operatingSystemMap = new HashMap<String, String>();
        for (String operatingSystem : Arrays.asList(getOperatingSystem())) {
            operatingSystemMap.put(operatingSystem, operatingSystem);
        }
        model.addAttribute("operatingSystemMap", operatingSystemMap);
        Map<String, String> processorBrandMap = new HashMap<String, String>();
        for (String processorBrand : Arrays.asList(getProcessorBrand()))
        {
            processorBrandMap.put(processorBrand, processorBrand);
        }
        model.addAttribute("processorBrandMap", processorBrandMap);
        Map<String, String> processorModelMap = new HashMap<String, String>();
        for (String processorModel : Arrays.asList(getProcessorModel()))
        {
            processorModelMap.put(processorModel, processorModel);
        }
        model.addAttribute("processorModelMap", processorModelMap);
        Map<String, String> memoryTypeMap = new HashMap<String, String>();
        for (String memoryType : Arrays.asList(getMemoryType()))
        {
            memoryTypeMap.put(memoryType, memoryType);
        }
        model.addAttribute("memoryTypeMap", memoryTypeMap);
    }

    public String[] getBrandName() {
        return brandName;
    }

    public void setBrandName(String[] brandName) {
        this.brandName = brandName;
    }

    public String[] getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String[] operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String[] getProcessorBrand() {
        return processorBrand;
    }

    public void setProcessorBrand(String[] processorBrand) {
        this.processorBrand = processorBrand;
    }

    public String[] getProcessorModel() {
        return processorModel;
    }

    public void setProcessorModel(String[] processorModel) {
        this.processorModel = processorModel;
    }

    public String[] getMemoryType() {
        return memoryType;
    }

    public void setMemoryType(String[] memoryType) {
        this.memoryType = memoryType;
    }
}
