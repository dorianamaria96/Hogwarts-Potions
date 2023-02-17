package com.codecool.hogwarts_potions.controller.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RoomNotFound extends Exception {
    public RoomNotFound(String message) {
        super(message);
    }
}
