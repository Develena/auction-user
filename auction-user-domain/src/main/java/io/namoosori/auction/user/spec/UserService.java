package io.namoosori.auction.user.spec;

import io.namoosori.auction.user.entity.User;

import java.util.List;

public interface UserService {

    String registerUser(User user);
    List<User> findAllUsers();
    User findUser(String id);
}
