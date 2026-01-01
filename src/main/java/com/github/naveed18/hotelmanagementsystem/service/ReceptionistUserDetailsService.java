package com.github.naveed18.hotelmanagementsystem.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;

import com.github.naveed18.hotelmanagementsystem.entity.ReceptionistEntity;
import com.github.naveed18.hotelmanagementsystem.repository.ReceptionistRepository;

@Service
public class ReceptionistUserDetailsService implements UserDetailsService  {
    private final ReceptionistRepository receptionistRepository;

    public ReceptionistUserDetailsService(
            ReceptionistRepository receptionistRepository) {
        this.receptionistRepository = receptionistRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {

        ReceptionistEntity receptionist = receptionistRepository
                .findByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found"));

        return User.builder()
                .username(receptionist.getEmail())
                .password(receptionist.getPassword())
                .roles("RECEPTIONIST")
                .build();
    }
    
}
