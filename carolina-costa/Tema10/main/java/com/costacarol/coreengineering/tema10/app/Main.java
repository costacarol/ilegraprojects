package com.costacarol.coreengineering.tema10.app;

import com.costacarol.coreengineering.tema10.dao.ContactDAO;
import com.costacarol.coreengineering.tema10.model.Contact;
import com.costacarol.coreengineering.tema10.service.ContactService;

public class Main {
    public static void main(String[] args) {

        ContactDAO contactDAO = new ContactDAO();
        ContactService contactService = new ContactService(contactDAO);
        try {
            Contact contact1 = new Contact("Stella Atrois", "5551465116516", "");
            contactService.addContact(contact1);
        }catch (IllegalAccessException e){
            System.out.println(e.getMessage());
        }

        try{
            Contact contact2 = new Contact("Vedett Wit", "5551465116516", "vedetx@ceva.com");
            contactService.addContact(contact2);
        }catch (IllegalAccessException e){
            System.out.println(e.getMessage());
        }

        try{
            Contact contact3 = new Contact("Patagônia Weiss", "5551889931446", "pata@cevuxa.com.br");
            contactService.addContact(contact3);
        }catch (IllegalAccessException e){
            System.out.println(e.getMessage());
        }

        try{
            Contact contact4 = new Contact("Colorado Appia", "5551354646516", "" );
            contactService.addContact(contact4);
        }catch (IllegalAccessException e){
            System.out.println(e.getMessage());
        }

        try{
            Contact contact5 = new Contact("Etrella Galicia", "", "estrella@bellaciao.com");
            contactService.addContact(contact5);
        }catch (IllegalAccessException e){
            System.out.println(e.getMessage());
        }

        try {
            Contact contact6 = new Contact("Heine Ken", "", "verdinha@cecevs.com");
            contactService.addContact(contact6);
        }catch (IllegalAccessException e){
            System.out.println(e.getMessage());
        }

        try{
            Contact contact7 = new Contact("Saint Bier", "", "saint@cecevs.com");
            contactService.addContact(contact7);
        }catch (IllegalAccessException e){
            System.out.println(e.getMessage());
        }

        try {
            Contact contact8 = new Contact("Stella Atrois", "5551465116645", "");
            contactService.addContact(contact8);
        }catch (IllegalAccessException e){
            System.out.println(e.getMessage());
        }

        try{
        contactService.listAllContactsOrderByName();
        }catch (IllegalAccessException e){
            System.out.println(e.getMessage());
        }

        try{
        contactService.listAllContactsOrderById();
        }catch (IllegalAccessException e){
            System.out.println(e.getMessage());
        }
    }
}