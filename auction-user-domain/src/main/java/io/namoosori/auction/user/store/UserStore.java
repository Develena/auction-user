package io.namoosori.auction.user.store;

import io.namoosori.auction.user.entity.User;

import java.util.List;

public interface UserStore {

    void createUser(User user);
    List<User> retrieveAllUsers();
    User retrieveUserById(String id);
    boolean existUserByName(String name);
}
