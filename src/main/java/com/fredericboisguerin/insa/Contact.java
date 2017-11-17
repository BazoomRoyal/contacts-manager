package com.fredericboisguerin.insa;

public class Contact {
    String name;
    String email;
    String phoneNumber;

    public Contact (String nom , String mail, String numero){
        this.name=nom ;
        this.email=mail ;
        this.phoneNumber=numero ;
    }

    public String toString(){
        if(this.email==null){
            return (this.name + ", "+ this.phoneNumber);
        }
        else{
            return (this.name + ", "+ this.email + ", "+ this.phoneNumber);
        }

    }
}
