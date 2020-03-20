package io.namoosori.auction.user.store.repository;

import io.namoosori.auction.user.store.jpo.UserJpo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserJpo, String> {

    boolean existsByName(String name);

}
