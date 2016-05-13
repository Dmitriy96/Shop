package by.bsuir.shop.controller;

import by.bsuir.shop.model.Laptop;
import by.bsuir.shop.model.PlacedOrder;
import by.bsuir.shop.model.User;
import by.bsuir.shop.service.LaptopService;
import by.bsuir.shop.service.OrderService;
import by.bsuir.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    OrderService orderService;
    @Autowired
    LaptopService laptopService;

    @RequestMapping(value="/orders", method = RequestMethod.GET)
    public String listOrders(Principal principal, Model model) {
        if (principal == null) return "redirect:/login";
        String username = principal.getName();
        User user = userService.getUserByUsername(username);
        model.addAttribute("user", user);
        model.addAttribute("placedOrderList", user.getPlacedOrders());
        return "orders/list";
    }

    @RequestMapping(value="/basket", method=RequestMethod.GET)
    public String getBasket(Model model, Principal principal) {
        if (principal == null) return "redirect:/login";
        String username = principal.getName();
        User user = userService.getUserByUsername(username);
        List<Laptop> laptops = user.getLaptopList();
        model.addAttribute("laptops", laptops);
        return "basket";
    }

    @RequestMapping(value="/basket", method=RequestMethod.POST)
    public String makePurchase(@ModelAttribute("laptops") List<Laptop> laptops, Model model, Principal principal) {
        if (principal == null) return "redirect:/login";
        String username = principal.getName();
        User user = userService.getUserByUsername(username);
        List<Laptop> unavailableLaptops = new ArrayList<Laptop>();
        for (Laptop laptop : laptops) {
            if (laptop.getInStock().isAvailable()) {
                laptop.getInStock().setAvailable(false);
            }
            else {
                unavailableLaptops.add(laptop);
                laptops.remove(laptop);
            }
        }
        if (!laptops.isEmpty()) {
            PlacedOrder placedOrder = new PlacedOrder();
            placedOrder.setOrderingDate(new Date());
            placedOrder.setLaptopList(laptops);
            user.getPlacedOrders().add(placedOrder);
        }
        userService.saveUser(user);
        if (!unavailableLaptops.isEmpty()) {
            model.addAttribute("laptops", unavailableLaptops);
            model.addAttribute("message", "This laptops were bought.");
        }
        return "basket";
    }

    @RequestMapping(value="/basket/{id}", method=RequestMethod.GET)
    public String addLaptopToBasket(@PathVariable Long id, Principal principal, Model model) {
        if (principal == null) return "redirect:/login";
        String username = principal.getName();
        User user = userService.getUserByUsername(username);
        Laptop laptop = laptopService.getLaptop(id);
        user.getLaptopList().add(laptop);
        userService.saveUser(user);
        return "redirect:basket";
    }

    @RequestMapping(value="/basket/{id}", method=RequestMethod.POST)
    public String deleteLaptopFromBasket(@PathVariable Long id, Principal principal, Model model) {
        if (principal == null) return "redirect:/login";
        String username = principal.getName();
        User user = userService.getUserByUsername(username);
        Laptop laptop = laptopService.getLaptop(id);
        user.getLaptopList().remove(laptop);
        userService.saveUser(user);
        return "redirect:basket";
    }
}
