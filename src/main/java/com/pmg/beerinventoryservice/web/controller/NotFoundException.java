package com.pmg.beerinventoryservice.web.controller;

public class NotFoundException extends RuntimeException {

    public NotFoundException() {
        super("No se ha encontrado ningun elemento a devolver.");
    }
}
