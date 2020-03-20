package io.namoosori.auction.user.entity;

import com.google.gson.Gson;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class User {

    private String id;
    private String name;
    private List<UserRole> roles;

    public User(){
        this.id = UUID.randomUUID().toString();
        roles = new ArrayList<>();
    }

    public User(String id){
        this();
        this.id = id;
    }

    public User(String id, String name){
        this(id);
        this.name = name;
    }

    public boolean hasRole(UserRole userRole){
        return roles.contains(userRole);
    }

    public static User sampleSeller(){
        User sample = new User();
        sample.setName("Seller#1");
        sample.setRoles(Arrays.asList(UserRole.Seller));
        return sample;
    }

    public static User sampleBidder(){
        User sample = new User();
        sample.setName("Bidder#1");
        sample.setRoles(Arrays.asList(UserRole.Bidder));
        return sample;
    }

    public static void main(String[] args) {
        System.out.println((new Gson()).toJson(User.sampleSeller()));
        System.out.println((new Gson()).toJson(User.sampleBidder()));
    }
}
