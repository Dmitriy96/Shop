package by.bsuir.shop.controller;


import by.bsuir.shop.model.Laptop;
import by.bsuir.shop.service.LaptopService;
import by.bsuir.shop.util.LaptopSample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
public class SearchController {
    @Autowired
    private LaptopService laptopService;

    @RequestMapping(value = { "/search" }, method = RequestMethod.GET)
    public String searchPage(Model model) {
        model.addAttribute("laptopSample", new LaptopSample());
        return "search";
    }

    @RequestMapping(value = { "/search" }, method = RequestMethod.POST)
    public String searchResult(@Valid @ModelAttribute("laptopSample") LaptopSample laptopSample, Model model) {
        List<Laptop> laptopList = laptopService.getLaptops(laptopSample);
        model.addAttribute("laptops", laptopList);
        return "home";
    }
}
