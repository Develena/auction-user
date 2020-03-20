package io.namoosori.auction.user.store;

import io.namoosori.auction.user.entity.User;
import io.namoosori.auction.user.store.jpo.UserJpo;
import io.namoosori.auction.user.store.repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class UserJpoStore implements UserStore {

    private final UserRepository userRepository;

    public UserJpoStore(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void createUser(User user) {
        this.userRepository.save(new UserJpo(user));
    }

    @Override
    public List<User> retrieveAllUsers() {
      List<UserJpo> userJpos = this.userRepository.findAll();
      return userJpos.stream().map(UserJpo::toDomain).collect(Collectors.toList());
    }

    @Override
    public User retrieveUserById(String id) {
        Optional<UserJpo> userJpo = this.userRepository.findById(id);

        if(!userJpo.isPresent()) {
            throw new NoSuchElementException(String.format("User is not found"));
        }
        return userJpo.get().toDomain();
    }

    @Override
    public boolean existUserByName(String name) {
        return this.userRepository.existsByName(name);
    }
}
