package com.uniassignment.commerce.user;

import com.uniassignment.commerce.user.Impl.UserDetailsServiceImpl;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@RestController
public class UserController {
    private UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/register")
    public User register(
            @RequestParam(value = "firstName") String firstName,
            @RequestParam(value = "lastName") String lastName,
            @RequestParam(value = "username") String username,
            @RequestParam(value = "email") String email,
            @RequestParam(value = "password") String password,
            @RequestParam(value = "confirmPassword") String confirmPassword
    ) {
        return userService.saveUser(firstName, lastName, username, email, password, confirmPassword);
    }

    @PostMapping("/login")
    public String login(@RequestParam(value = "email") String email,
                      @RequestParam(value = "password") String password,
                      HttpSession session) {

        User user = userService.login(email, password, session);

        if(user == null) {
            return "error.html";
        }

        return "dashboard.html";
    }
}
