package io.namoosori.auction.user.rest;

import io.namoosori.auction.user.entity.User;
import io.namoosori.auction.user.lifecycle.ServiceLifeCycle;
import io.namoosori.auction.user.spec.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserResource implements UserService {

    private final UserService userService;

    public UserResource(ServiceLifeCycle serviceLifeCycle) {
        this.userService = serviceLifeCycle.requestUserService();
    }

    @PostMapping(value={"", "/"})
    public String registerUser(@RequestBody  User user) {
        return userService.registerUser(user);
    }

    @GetMapping(value={"", "/"})
    public List<User> findAllUsers() {
        return userService.findAllUsers();
    }

    @GetMapping(value={"/{userId}"})
    public User findUser(@PathVariable(value="userId") String id) {
        return userService.findUser(id);
    }
}