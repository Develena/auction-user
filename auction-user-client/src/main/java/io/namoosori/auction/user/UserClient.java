package io.namoosori.auction.user;

import io.namoosori.auction.user.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="auction-user")
public interface UserClient {
    @GetMapping(value="/{userId}")
    User findUser(@PathVariable(value = "userId") String id);
}
