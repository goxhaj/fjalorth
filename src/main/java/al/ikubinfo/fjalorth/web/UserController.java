package al.ikubinfo.fjalorth.web;

import al.ikubinfo.fjalorth.domain.User;
import al.ikubinfo.fjalorth.repository.RoleRepository;
import al.ikubinfo.fjalorth.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private RoleRepository roleRepository;

    @GetMapping(value="/register")
    public ModelAndView registration(){
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("register");
        return modelAndView;
    }

    @PostMapping(value = "/register")
    public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        User userExists = userService.findUserByUsername(user.getUsername());
        if (userExists != null) {
            bindingResult
                    .rejectValue("email", "error.user",
                            "Ekziston nje user tjeter me kete email");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("register");
        } else {
            userService.saveUser(user);
            modelAndView.addObject("successMessage", "Useri u regjistrua me sukses");
            modelAndView.addObject("user", new User());
            modelAndView.setViewName("register");

        }
        return modelAndView;
    }

    @GetMapping(value="/admin/index")
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        log.info(auth.getName());
        User user = userService.findUserByUsername(auth.getName());
        modelAndView.addObject("userName", "Mireserdhe " + user.getFirstname() + " " + user.getLastname() + " (" + user.getEmail() + ")");
        modelAndView.addObject("adminMessage","Kete faqe mund ta aksesoje vetem roli admin");
        modelAndView.setViewName("admin/index");
        return modelAndView;
    }


}