package com.example.ServiceSecond.controller;

import com.example.ServiceSecond.model.User;
import com.example.ServiceSecond.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/client")
public class UserCreditController {

    @Autowired
    private UserService userService;


    @GetMapping("/pas/{pasport}")
    public Mono<User> getByUserPasport(@PathVariable String pasport) {

        return userService.findByPasport(pasport);
    }

    @GetMapping("/pass/{pasport}")
    public String updateUserZp(@PathVariable String pasport) {
        return userService.getCredit(pasport);
    }


}
