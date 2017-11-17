package com.fredericboisguerin.insa;

public class InvalidContactNameException extends Exception {

    public InvalidContactNameException(){
        System.out.println("Le nom n'est pas valide malheureux : c'est impossible");
    }
}
