package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.model.Role;
import org.example.model.User;
import org.example.repository.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User save(User user)
    {
        return userRepository.save(user);
    }

    public User create(User user)
    {
        if(userRepository.existsByUsername(user.getUsername()))
        {
            throw new RuntimeException("This username already exits");
        }
        if(userRepository.existsByEmail(user.getEmail()))
        {
            throw new RuntimeException("This email already exits");
        }

        return save(user);
    }


    public User getByUserName(String username)
    {
        return userRepository.findByUsername(username).orElseThrow(()-> new UsernameNotFoundException("User not found"));
    }

    public UserDetailsService userDetailsService()
    {
        return this::getByUserName;
    }


    public User getCurrentUser()
    {
        var username = SecurityContextHolder.getContext().getAuthentication().getName();
        return getByUserName(username);
    }


    @Deprecated
    public void getAdmin()
    {
        var user = getCurrentUser();
        user.setRole(Role.ROLE_ADMIN);
        save(user);
    }
}

