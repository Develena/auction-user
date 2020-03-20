package io.namoosori.auction.user.lifecycle;

import io.namoosori.auction.user.store.UserStore;
import org.springframework.stereotype.Component;

@Component
public class StoreLifecycler implements StoreLifeCycle {

    private final UserStore userStore;

    public StoreLifecycler(UserStore userStore) {
        this.userStore = userStore;
    }

    @Override
    public UserStore requestUserStore() {
        return this.userStore;
    }
}
