package io.namoosori.auction.user.logic;

import io.namoosori.auction.user.entity.User;
import io.namoosori.auction.user.exception.AlreadyUserNameExistsException;
import io.namoosori.auction.user.lifecycle.StoreLifeCycle;
import io.namoosori.auction.user.spec.UserService;
import io.namoosori.auction.user.store.UserStore;

import java.util.List;

public class UserLogic implements UserService {

    private final UserStore userStore;

    public UserLogic(StoreLifeCycle storeLifeCycle) {
        this.userStore = storeLifeCycle.requestUserStore();
    }

    @Override
    public String registerUser(User user) {
       if(userStore.existUserByName(user.getName())) {
           throw new AlreadyUserNameExistsException("");
       }

       this.userStore.createUser(user);
       return user.getId();
    }

    @Override
    public List<User> findAllUsers() {
        return userStore.retrieveAllUsers();
    }

    @Override
    public User findUser(String id) {
        return userStore.retrieveUserById(id);
    }
}
