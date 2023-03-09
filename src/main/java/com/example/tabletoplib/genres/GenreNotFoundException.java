package com.example.tabletoplib.genres;

public class GenreNotFoundException extends Exception {
    public GenreNotFoundException(String message){
        super(message);
    }
}