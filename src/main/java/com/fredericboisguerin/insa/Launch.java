package com.fredericboisguerin.insa;

import java.util.Scanner;

public class Launch {

    private final ContactsManager contactsManager;

    private boolean Run ;


    public Launch(ContactsManager contactsManager) {

        this.contactsManager = contactsManager;
        this.Run = false ;
    }

    public static int getChoice(Scanner in) {
        return in.nextInt();
    }

    public void main(String[] args) throws InvalidEmailException, InvalidContactNameException {
        ContactsManager repertoire = new ContactsManager() ;
        Launch launch = new Launch(repertoire) ;
        while(!Run){
            launch.afficherMenu();

        }

    }

    public void afficherMenu() throws InvalidEmailException, InvalidContactNameException {
        System.out.println();
        System.out.println("MENU");
        System.out.println();
        System.out.println("0 - Quitter");
        System.out.println("1 - Ajouter un contact");
        System.out.println("2 - Chercher un contact");
        System.out.println("3 - Afficher tous les contacts");


        System.out.println();


        Scanner scanner = new Scanner(System.in);
        Integer o = Integer.valueOf(scanner.nextLine());

        switch(o){
            case 0 : {
                Run = true ;
                break ;
            }

            case 1 : {
                this.askInfoForNewContact(scanner);
                break ;
            }

            case 2 : {
                System.out.println("Veuillez entrer le nom (ou un bout du nom) de la personne recherchee");
                String s = scanner.nextLine();
                contactsManager.searchContactByName(s);
                break ;

            }

            case 3 : {
                System.out.println("Voici la liste des contacts");
                contactsManager.printAllContacts();
                break ;
            }
        }

    }


    public void askInfoForNewContact(Scanner scanner) throws InvalidEmailException, InvalidContactNameException {
        System.out.println("Veuillez entrer les informations du contact comme ceci : NOM EMAIL TELEPHONE");
        String s = scanner.nextLine();
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();

        contactsManager.addContact(s, s1, s2);
    }

    public void cherchContact() {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        contactsManager.searchContactByName(s);
    }


}
