package io.namoosori.auction.user.lifecycle;

import io.namoosori.auction.user.store.UserStore;

public interface StoreLifeCycle {

    UserStore requestUserStore();
}
