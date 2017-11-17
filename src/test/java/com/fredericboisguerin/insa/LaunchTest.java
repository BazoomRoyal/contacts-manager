package com.fredericboisguerin.insa;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class LaunchTest {

    public static final String LINE_SEPARATOR = System.lineSeparator();

    @Test
    public void should_call_launch_ask_info_for_new_contact() throws Exception{
       ContactsManager contactsManager = mock(ContactsManager.class) ;
        String name = "some name";
        String email = "some email";
        String phoneNumber = "some phoneNumber";
        Launch launch = new Launch(contactsManager);

       String typedStuff = "1"+ LINE_SEPARATOR + name + LINE_SEPARATOR + email + LINE_SEPARATOR + phoneNumber + LINE_SEPARATOR;
       System.setIn(new ByteArrayInputStream(typedStuff.getBytes()));
       launch.afficherMenu();



       verify(contactsManager).addContact(name, email, phoneNumber);
    }

    @Test
    public void should_add_contact_when_user_types_name_and_email_and_phone_number() throws Exception {
        ContactsManager contactsManager = mock(ContactsManager.class);
        String name = "some name";
        String email = "some email";
        String phoneNumber = "some phoneNumber";
        Launch launch = new Launch(contactsManager);

        String typedStuff = name + LINE_SEPARATOR + email + LINE_SEPARATOR + phoneNumber + LINE_SEPARATOR;
        System.setIn(new ByteArrayInputStream(typedStuff.getBytes()));
        launch.askInfoForNewContact(new Scanner(System.in));


        verify(contactsManager).addContact(name, email, phoneNumber);
    }

    @Test
    public void should_print_all_contact() throws Exception {
        ContactsManager contactsManager = mock(ContactsManager.class) ;
        Launch launch = new Launch(contactsManager);

        String typedStuff = "3"+ LINE_SEPARATOR;
        System.setIn(new ByteArrayInputStream(typedStuff.getBytes()));
        launch.afficherMenu();

       verify(contactsManager).printAllContacts();
    }

    @Test
    public void should_cherch_in_contact_with_name() throws Exception{
       ContactsManager contactsManager = mock(ContactsManager.class);
       String name = "some name" ;
       Launch launch = new Launch(contactsManager);

       String typedStuff = name + LINE_SEPARATOR ;
       System.setIn(new ByteArrayInputStream(typedStuff.getBytes()));
       launch.cherchContact();
                                                                            
       verify(contactsManager).searchContactByName(name);
    }
}