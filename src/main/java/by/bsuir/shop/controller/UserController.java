package by.bsuir.shop.controller;

import by.bsuir.shop.model.Laptop;
import by.bsuir.shop.model.PlacedOrder;
import by.bsuir.shop.model.User;
import by.bsuir.shop.service.LaptopService;
import by.bsuir.shop.service.OrderService;
import by.bsuir.shop.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


@Controller
@RequestMapping("/user")
public class UserController {
    private static Logger logger = LoggerFactory.getLogger(UserController.class);
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
        List<PlacedOrder> placedOrders = orderService.getOrders(user);
        for (PlacedOrder placedOrder : user.getPlacedOrders()) {
            logger.debug("listOrders: {}", Arrays.toString(placedOrder.getLaptopList().toArray()));
        }
        model.addAttribute("user", user);
        model.addAttribute("placedOrderList", placedOrders);
        return "orders/list";
    }

    @RequestMapping(value="/basket", method=RequestMethod.GET)
    public String getBasket(Model model, Principal principal) {
        if (principal == null) return "redirect:/login";
        String username = principal.getName();
        User user = userService.getUserByUsername(username);
        List<Laptop> laptops = user.getLaptopList();
        List<Laptop> removeLaptopList = new ArrayList<Laptop>();
        for (Laptop laptop : laptops) {
            if (laptop.isAvailable())
                removeLaptopList.add(laptop);
        }
        laptops.removeAll(removeLaptopList);
        model.addAttribute("laptops", laptops);
        return "basket";
    }

    @RequestMapping(value="/basket", method=RequestMethod.POST)
    public String makePurchase(@RequestParam("basketLaptopIds") String basketLaptopIds, Model model, Principal principal) {
        logger.debug("======================makePurchase: {}", basketLaptopIds);
        if (principal == null) return "redirect:/login";
        String username = principal.getName();
        User user = userService.getUserByUsername(username);
        List<Laptop> orderedLaptops = new ArrayList<Laptop>();
        basketLaptopIds = basketLaptopIds.substring(1);
        for (String laptopId : basketLaptopIds.split(" ")) {
            logger.debug("======================makePurchase: before loaded laptop - {}", laptopId);
            Laptop laptop = laptopService.getLaptop(Long.parseLong(laptopId));
            orderedLaptops.add(laptop);
            logger.debug("======================makePurchase: loaded laptop - {}", laptop);
        }
        logger.debug("======================makePurchase: size - {}", orderedLaptops != null ? orderedLaptops.size() : "null");
        logger.debug("======================makePurchase: id - {}", orderedLaptops.get(0) != null ? orderedLaptops.get(0).getIdLaptop() : "null");
        PlacedOrder placedOrder = new PlacedOrder();
        placedOrder.setOrderingDate(new Date());
        placedOrder.setUser(user);
        Integer id = orderService.saveOrder(placedOrder);
        logger.debug("======================makePurchase: placed order id - {}", placedOrder.getIdOrder());
        placedOrder.setLaptopList(orderedLaptops);
        orderService.updateOrder(placedOrder);
        //List<PlacedOrder> placedOrders = new ArrayList<PlacedOrder>();
        //placedOrders.add(placedOrder);
        user.getPlacedOrders().add(placedOrder);
        logger.debug("======================makePurchase: total orders - {}", user.getPlacedOrders().size());
        //user.setPlacedOrders(placedOrders);
        //userService.updateUser(user);
        return "redirect:/user/orders";
    }


    @RequestMapping(value="/basket/add/{id}", method=RequestMethod.POST)
    public String addLaptopToBasket(@PathVariable Long id, Principal principal, Model model) {
        logger.debug("addLaptopToBasket: id: {}", id);
        if (principal == null) return "redirect:/login";
        String username = principal.getName();
        User user = userService.getUserByUsername(username);
        Laptop laptop = laptopService.getLaptop(id);
        laptop.setAvailable(false);
        user.getLaptopList().add(laptop);
        userService.updateUser(user);
        return "redirect:/user/basket";
    }

    @RequestMapping(value="/basket/remove/{id}", method=RequestMethod.POST)
    public String deleteLaptopFromBasket(@PathVariable Long id, Principal principal, Model model) {
        if (principal == null) return "redirect:/login";
        String username = principal.getName();
        User user = userService.getUserByUsername(username);
        Laptop laptop = laptopService.getLaptop(id);
        laptop.setAvailable(true);
        laptopService.updateLaptop(laptop);
        return "redirect:/user/basket";
    }
}
