package by.bsuir.shop.controller;

import by.bsuir.shop.model.Laptop;
import by.bsuir.shop.service.LaptopService;
import by.bsuir.shop.util.LaptopAttributes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;

@Controller
public class MainController {

    private static Logger logger = LoggerFactory.getLogger(MainController.class);
    @Autowired
    LaptopService laptopService;
    @Autowired
    LaptopAttributes laptopAttributes;
    private final Integer LAPTOPS_PER_PAGE = 12;


	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public String defaultPage(@RequestParam(value = "page", required = false) Integer page, Model model) {
        logger.debug("Get defaultPage");
        List<Laptop> laptopList = laptopService.getAllLaptops();
        /*if (page == null) {
            laptopList = laptopService.getLaptops(0);
            model.addAttribute("currentPageNumber", 1);
        } else {
            laptopList = laptopService.getLaptops(page - 1);
            model.addAttribute("currentPageNumber", page);
        }*/
        int pagesNumber = laptopService.getLaptopCount() / LAPTOPS_PER_PAGE;
        model.addAttribute("pagesNumber", pagesNumber);
        model.addAttribute("laptops", laptopList);
		return "home";
	}

    @RequestMapping(value = "/laptops", method = RequestMethod.GET)
    public List<Laptop> getLaptopsToPage(@RequestParam(value = "page") Integer page) {
        logger.debug("Get laptops for page: {}", page);
        List<Laptop> laptopList = laptopService.getLaptops(page - 1);
        return laptopList;
    }

    @RequestMapping(value = "/laptop/{id}", method = RequestMethod.GET)
    public String productDescription(@PathVariable Long id, Model model) {
        model.addAttribute("laptop", laptopService.getLaptop(id));
        return "description";
    }


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(@RequestParam(value = "error", required = false) String error,
                        @RequestParam(value = "logout", required = false) String logout, Principal principal, HttpServletRequest request, Model model) {
        logger.debug("Try login: {}", principal);
        if (principal == null)                //if user unauthenticated
        {
            if (error != null) {
                model.addAttribute("error", getErrorMessage(request, "SPRING_SECURITY_LAST_EXCEPTION"));
            }
            if (logout != null) {
                model.addAttribute("msg", "You've been logged out successfully.");
            }
            return "login";
        }
        else return "redirect:/home";
    }


    private String getErrorMessage(HttpServletRequest request, String key) {
        Exception exception = (Exception) request.getSession().getAttribute(key);
        String error = "";
        if (exception instanceof BadCredentialsException) {
            error = "Invalid username or password!";
        } else if (exception instanceof LockedException) {
            error = exception.getMessage();
        } else {
            error = "Invalid username or password!";
        }
        return error;
    }


	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public String accesssDenied(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken))
        {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
            model.addAttribute("username", userDetail.getUsername());
		}
		return "errors/403";
	}

}