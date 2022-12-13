package com.uniassignment.commerce.user.Impl;

import com.uniassignment.commerce.user.LoggedUser;
import com.uniassignment.commerce.user.Role;
import com.uniassignment.commerce.user.User;
import com.uniassignment.commerce.user.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private UserRepository userRepository;
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);

        if(user == null) {
            throw new UsernameNotFoundException("User with username: " + email + " does not exist!");
        }

        Set<Role> roles = user.getRoles();

        return new LoggedUser(user, roles);
    }
}
