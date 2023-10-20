package com.youcode.resourcium.Exceptions;

import java.util.NoSuchElementException;

public class EquipementNotFoundException extends Exception{
    public EquipementNotFoundException(String message, NoSuchElementException e) {
        super(message);
    }
}
