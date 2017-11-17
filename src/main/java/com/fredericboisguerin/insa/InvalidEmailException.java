package com.fredericboisguerin.insa;

public class InvalidEmailException extends Exception {

    public InvalidEmailException(){
        System.out.println("Eh dis donc ! Ton email c'est du n'importe quoi là !!");
    }
}
