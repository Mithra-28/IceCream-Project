package com.kce.icecream.utils;

public class FlavorNotFoundException extends RuntimeException {
    public FlavorNotFoundException(String message) {
        super(message);
    }
    @Override
    public String toString() {
        return "Flavour not found";
    }
}
