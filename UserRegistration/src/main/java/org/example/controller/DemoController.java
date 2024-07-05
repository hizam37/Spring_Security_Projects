package org.example.controller;


import lombok.RequiredArgsConstructor;
import org.example.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/example")
@RequiredArgsConstructor
public class DemoController {

    private final UserService userService;

    @GetMapping
    public String hello()
    {
        return "HELLO WORLD!";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String helloAdmin()
    {
        return "HELLO ADMIN";
    }


    @GetMapping("/get-admin")
    public void getAdmin()
    {
        userService.getAdmin();
    }


}
