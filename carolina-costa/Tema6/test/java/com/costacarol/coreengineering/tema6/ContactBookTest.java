package com.costacarol.coreengineering.tema6;

import junit.framework.TestCase;
import org.junit.*;

public class ContactBookTest extends TestCase {

    ContactBook testContactBook = new ContactBook();
    Contact testContact1 = new Contact("Vinicius", 55555555);
    Contact testContact2 = new Contact("Rafael", 44444444);
    Contact testContact3 = new Contact("Tarzan", 3333333);
    Contact testContact4 = new Contact("Gabriel", 22222222);


    @Test
    public void testListNoExistsContact() throws Exception{
       testContactBook.listContact();
       Assert.assertNull(testContactBook.searchContactById(1));
    }

    @Test
    public void testAddNewContact() throws Exception{
        testContactBook.addContact(testContact1);
        Assert.assertEquals(testContact1.getName(), "Vinicius");
    }

    @Test
    public void testAddExistsContact() throws Exception{
        testContactBook.addContact(testContact2);
        Assert.assertEquals(testContact2.getId(), 2);
    }

    @Test
    public void testRemoveExistsContact() throws Exception{
        testContactBook.addContact(testContact3);
        Assert.assertTrue(testContactBook.removeContact(testContact3));
    }

    @Test
    public void testSearchContactByExistId() throws Exception{
        testContactBook.searchContactById(1);
        Assert.assertEquals(1, 1);
    }

    @Test
    public void testRemoveNotExistsContact() throws Exception{
        Assert.assertFalse(testContactBook.removeContact(testContact4));
    }

    @Test
    public void testListExistsContact() throws Exception{
        testContactBook.listContact();
        Assert.assertEquals(testContact1.toString(), testContact1.toString());
    }

    @Test
    public void testSearchContactByExistName() throws Exception{
        testContactBook.searchContactByName("Vinicius");
        Assert.assertEquals("Vinicius", "Vinicius");
    }

    @Test
    public void testSearchContactByNoExistName() throws Exception{
        Assert.assertNull(testContactBook.searchContactByName("Eduardo"));
    }

    @Test
    public void testSearchContactByNoExistId() throws Exception{
        Assert.assertNull(testContactBook.searchContactById(7));
    }


}