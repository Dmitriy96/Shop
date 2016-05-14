package by.bsuir.shop.controller;

import by.bsuir.shop.model.Laptop;
import by.bsuir.shop.model.User;
import by.bsuir.shop.service.LaptopService;
import by.bsuir.shop.service.UserService;
import by.bsuir.shop.util.LaptopAttributes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
@RequestMapping(value = "/admin")
public class AdminController {
    private static Logger logger = LoggerFactory.getLogger(AdminController.class);
    @Autowired
    private LaptopService laptopService;
    @Autowired
    private LaptopAttributes laptopAttributes;
    @Autowired
    private UserService userService;


    @RequestMapping(value = "/product/add", method = RequestMethod.GET)
    public String adminProductAdd(Model model) {
        model.addAttribute("laptop", new Laptop());
        laptopAttributes.completeModel(model);
        return "admin/addingProduct";
    }


    @RequestMapping(value = "/product/add", method = RequestMethod.POST)
    public String addProduct(@Valid @ModelAttribute Laptop laptop, BindingResult bindingResult, Model model) {
        logger.debug("addProduct: {}", laptop);
        if (bindingResult.hasErrors()) {
            model.addAttribute("laptop", new Laptop());
            laptopAttributes.completeModel(model);
            model.addAttribute("error", bindingResult.getFieldError().getField() + " field has error.");
            return "admin/addingProduct";
        }
        Long id = (Long) laptopService.saveLaptop(laptop);
        return "redirect:/home";
    }

    @RequestMapping(value = "/product/delete", method = RequestMethod.GET)
    public String adminProductDelete(Model model) {
        return "admin/deleteProduct";
    }

    @RequestMapping(value = "/product/delete/{id}", method = RequestMethod.POST)
    public String adminProductDelete(@PathVariable Long id, Model model) {
        Laptop laptop = laptopService.getLaptop(id);
        laptop.setAvailable(false);
        laptopService.updateLaptop(laptop);
        return "redirect:/home";
    }


    @RequestMapping(value = "/user/delete", method = RequestMethod.GET)
    public String deleteUserPage(Model model) {
        model.addAttribute("user", new User());
        return "admin/deleteUser";
    }

    @RequestMapping(value = "/user/delete", method = RequestMethod.POST)
    public String deleteUser(@RequestParam(value="username", required=false) String username, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors())
        {
            model.addAttribute("user", new User());
            return "admin/deleteUser";
        }
        User user = userService.getUserByUsername(username);
        userService.deleteUser(user);
        return "redirect:/user/delete";
    }


    public LaptopService getLaptopService() {
        return laptopService;
    }

    public void setLaptopService(LaptopService laptopService) {
        this.laptopService = laptopService;
    }

    public LaptopAttributes getLaptopAttributes() {
        return laptopAttributes;
    }

    public void setLaptopAttributes(LaptopAttributes laptopAttributes) {
        this.laptopAttributes = laptopAttributes;
    }
}
