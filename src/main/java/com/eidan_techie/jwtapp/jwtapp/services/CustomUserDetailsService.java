package com.eidan_techie.jwtapp.jwtapp.services;

import java.util.List;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final List<UserDetails> users;

    public CustomUserDetailsService(PasswordEncoder passwordEncoder) {
        this.users = List.of(
            User.withUsername("user1").password(passwordEncoder.encode("password1")).roles("USER").build(),
            User.withUsername("admin").password(passwordEncoder.encode("adminpassword")).roles("ADMIN").build()
        );
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return users.stream()
                .filter(user -> user.getUsername().equals(username))
                .findFirst()
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
