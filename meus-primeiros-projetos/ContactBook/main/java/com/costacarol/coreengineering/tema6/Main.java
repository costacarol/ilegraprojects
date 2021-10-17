package com.costacarol.coreengineering.tema6;

public class Main {
    public static void main(String[] args) {
        ContactBook contactBook = new ContactBook();
        Contact contact[] = new Contact[10];

        // Vamos tentar adicionar 4 contatos:

        contact[0] = new Contact("Vinicius", 55555555);
        contactBook.addContact(contact[0]);
        contact[1] = new Contact("Rafael", 44444444);
        contactBook.addContact(contact[1]);
        contact[2] = new Contact("Tarzan", 3333333);
        contactBook.addContact(contact[2]);
        contact[3] = new Contact("Vinicius", 55555555);

        // Este contato já existe ( contato[0] ), e não irá ser adicionado

        contactBook.addContact(contact[3]);
        System.out.println("------------------------------------");

        //Vamos remover o contato Vinicius:
       System.out.println(contactBook.removeContact(contact[0]));

        // Buscar o contato Tarzan
        System.out.println(contactBook.searchContactByName("Tarzan"));

        // Buscar o contato Vinicius pelo seu id:
        System.out.println(contactBook.searchContactById(2));

        // Agora, vamos listar os contatos:

        for (Contact list: contactBook.listContact()) {
        System.out.println(list);
        }
    }
}

