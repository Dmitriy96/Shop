package by.bsuir.shop.controller;

import by.bsuir.shop.model.User;
import by.bsuir.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;


@Controller
public class SignupController
{
    @Autowired
    private UserService userService;
    @Autowired
    protected AuthenticationManager authenticationManager;
    @Value("${files.path}")
    private String filesPath;


    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registrationPage(Model model, Principal principal) {
        model.addAttribute(new User());
        model.addAttribute("rolesMap", getRolesMap());
        return "registration";
    }


    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult,
                               Model model, HttpServletRequest request) {
        if (bindingResult.hasErrors()) {
            model.addAttribute(new User());
            model.addAttribute("rolesMap", getRolesMap());
            model.addAttribute("error", bindingResult.getFieldError().getField() + " field error.");
            return "registration";
        }
        User verifyingUser = userService.getUserByUsername(user.getUsername());
        if (verifyingUser != null) {
            model.addAttribute((new User()));
            model.addAttribute("usernameExists", "User with this username already exists");
            model.addAttribute("rolesMap", getRolesMap());
            return "registration";
        }
        else {
            verifyingUser = userService.getUserByEmail(user.getEmail());
            if (verifyingUser != null) {
                model.addAttribute((new User()));
                model.addAttribute("emailExists", "User with this username already exists");
                model.addAttribute("rolesMap", getRolesMap());
                return "registration";
            }
        }
        user.setAvailable(true);
        userService.saveUser(user);
        authenticateUserAndSetSession(user, request);
        return "redirect:/home";
    }


    private Map<String, String> getRolesMap()
    {
        Map<String, String> rolesMap = new HashMap<String, String>();
        rolesMap.put("ROLE_USER", "User");
        return rolesMap;
    }

    private void authenticateUserAndSetSession(User user, HttpServletRequest request)
    {
        String username = user.getUsername();
        String password = user.getPassword();
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);

        request.getSession();

        token.setDetails(new WebAuthenticationDetails(request));
        Authentication authenticatedUser = authenticationManager.authenticate(token);

        SecurityContextHolder.getContext().setAuthentication(authenticatedUser);
    }
}
