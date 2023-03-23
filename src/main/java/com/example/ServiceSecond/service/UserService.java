package com.example.ServiceSecond.service;

import com.example.ServiceSecond.model.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {
    Flux<User> findAll();
    Mono<User> findById(Long id);
    Mono<User> findByPasport(String pasport);
    Mono<User> create(User user);
    Mono<User> update(User user);
    Mono<Void> delete(Integer id);
    String getCredit(String paspoty);



}
