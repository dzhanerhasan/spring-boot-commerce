package com.uniassignment.commerce.user;

import jakarta.servlet.http.HttpSession;

public interface UserService {
    User saveUser(String firstName, String lastName,
                  String username, String email,
                  String password, String confirmPassword);

    User login(String email, String password, HttpSession session);
}
