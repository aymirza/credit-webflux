package com.example.ServiceSecond.service;

import com.example.ServiceSecond.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserServiceIml implements UserService {

    @Autowired
    private UserService userService;



    @Override
    public Flux<User> findAll() {
        return null;
    }

    @Override
    public Mono<User> findById(Long id) {
        return null;
    }

    @Override
    public Mono<User> findByPasport(String pasport) {
            WebClient webClient = WebClient
                    .create("http://localhost:8080/api/user/pasport");
            return webClient.get()
                    .uri("/" + pasport)
                    .accept(MediaType.APPLICATION_JSON)
                    .retrieve()
                    .bodyToMono(User.class);
    }

    @Override
    public Mono<User> create(User user) {
        return null;
    }

    @Override
    public Mono<User> update(User user) {
        return null;
    }

    @Override
    public Mono<Void> delete(Integer id) {
        return null;
    }

    @Override
    public String getCredit(String pasport) {
        WebClient webClient = WebClient.create("http://localhost:8080/api/user/pasport");
        Mono<User> user2 = webClient.get()
                .uri("/" + pasport)
                .retrieve()
                .bodyToMono(User.class);
        Integer credit = user2.block().getCreditSummasi();
        Integer zpyil = (user2.block().getZarpPlata() - ((user2.block().getZarpPlata()*30/100)))*12;
        if (zpyil >= credit) {
            return "Tabriklaymiz sizga: "+credit +" so'm miqdorida kredit ajratildi";
        } else {
            Integer polojeno = credit-zpyil;
            return "Uzur sizga "+ credit + " miqdorida kredit ajrata olmaymiz, chunki ylik daromadingiz yetmaydi, sizga "+polojeno +" so'm miqdorida kredit ajrata olamiz";
        }
    }


}
