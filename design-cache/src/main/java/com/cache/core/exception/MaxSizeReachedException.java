package com.cache.core.exception;

public class MaxSizeReachedException extends Exception {

    public MaxSizeReachedException() {
        super("max size reached");
    }


    public MaxSizeReachedException(String message) {
        super(message);
    }
}
