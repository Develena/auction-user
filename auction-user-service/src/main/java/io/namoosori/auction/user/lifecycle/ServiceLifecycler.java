package io.namoosori.auction.user.lifecycle;

import io.namoosori.auction.user.logic.UserLogic;
import io.namoosori.auction.user.spec.UserService;
import org.springframework.stereotype.Component;

@Component
public class ServiceLifecycler implements ServiceLifeCycle {

    private final StoreLifeCycle storeLifeCycle;

    public ServiceLifecycler(StoreLifeCycle storeLifeCycle) {
        this.storeLifeCycle = storeLifeCycle;
    }

    @Override
    public UserService requestUserService() {
        return new UserLogic(storeLifeCycle);
    }

}
