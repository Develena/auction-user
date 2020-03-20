package io.namoosori.auction.user.exception;

public class AlreadyUserNameExistsException extends RuntimeException {

    public AlreadyUserNameExistsException(String message){
        super(message);
    }
}
