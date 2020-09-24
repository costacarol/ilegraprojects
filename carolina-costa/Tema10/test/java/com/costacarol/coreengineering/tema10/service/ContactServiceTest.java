package com.costacarol.coreengineering.tema10.service;

import com.costacarol.coreengineering.tema10.dao.ContactDAO;
import com.costacarol.coreengineering.tema10.model.Contact;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.sql.SQLException;


@RunWith(MockitoJUnitRunner.class)
public class ContactServiceTest extends TestCase {

    @Mock
    ContactDAO contactDaoMock = new ContactDAO();

    @Test
    public void testAddContact() throws SQLException, IllegalAccessException {
        Contact contact1 = new Contact("Stella Atrois", "5551465116516", "");
        ContactService contactService = new ContactService(contactDaoMock);
        Mockito.when(contactDaoMock.addContact(contact1)).thenReturn(true);
        Assert.assertTrue(contactService.addContact(contact1));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddExistsContact() throws SQLException, IllegalAccessException {
        Contact contact1 = new Contact("Stella Atrois", "5551465116516", "");
        ContactDAO contactDAO = new ContactDAO();
        ContactService contactService = new ContactService(contactDAO);
        contactService.addContact(contact1);
    }

    @Test
    public void testAddExistsContactWithSameNumberButDifferentName() throws SQLException, IllegalAccessException {
        Contact contact1 = new Contact("Stella Atroá", "5551465116516", "");
        ContactService contactService = new ContactService(contactDaoMock);
        Mockito.when(contactDaoMock.addContact(contact1)).thenReturn(true);
        Assert.assertTrue(contactService.addContact(contact1));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddContactWithNameNull() throws SQLException, IllegalAccessException {
        Contact contact1 = new Contact(null, "5551465116516", "");
        ContactDAO contactDAO = new ContactDAO();
        ContactService contactService = new ContactService(contactDAO);
        contactService.addContact(contact1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddContactWithContactsNull() throws SQLException, IllegalAccessException {
        Contact contact1 = new Contact("Stella Atrois", null, null);
        ContactDAO contactDAO = new ContactDAO();
        ContactService contactService = new ContactService(contactDAO);
        contactService.addContact(contact1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddContactWithPhoneNull() throws SQLException, IllegalAccessException {
        Contact contact1 = new Contact("Stella Atrois", null, "stellinha@atrois.com");
        ContactDAO contactDAO = new ContactDAO();
        ContactService contactService = new ContactService(contactDAO);
        contactService.addContact(contact1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddContactWithEmailNull() throws IllegalAccessException {
        Contact contact1 = new Contact("Stella Atrois", "5551465116516", null);
        ContactDAO contactDAO = new ContactDAO();
        ContactService contactService = new ContactService(contactDAO);
        contactService.addContact(contact1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddContactWithEmailWithoutSymbol() throws IllegalAccessException {
        Contact contact1 = new Contact("Stella Atrois", "5551465116516", "stellinhaatrois.com");
        ContactDAO contactDAO = new ContactDAO();
        ContactService contactService = new ContactService(contactDAO);
        contactService.addContact(contact1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddContactWithInvalidPhoneNumber() throws IllegalAccessException {
        Contact contact1 = new Contact("Stella Atrois", "51982293016", "stellinha@atrois.com");
        ContactDAO contactDAO = new ContactDAO();
        ContactService contactService = new ContactService(contactDAO);
        contactService.addContact(contact1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddContactWithEmptyValues() throws IllegalAccessException {
        Contact contact1 = new Contact("Stella Atrois", "", "");
        ContactDAO contactDAO = new ContactDAO();
        ContactService contactService = new ContactService(contactDAO);
        contactService.addContact(contact1);
    }

    @Test
    public void testAddContactWithPhoneEmptyValue() throws SQLException, IllegalAccessException {
        Contact contact1 = new Contact("Stella Atrois", "", "stellinha@atrois.com");
        ContactService contactService = new ContactService(contactDaoMock);
        Mockito.when(contactDaoMock.addContact(contact1)).thenReturn(true);
        Assert.assertTrue(contactService.addContact(contact1));
    }

    @Test
    public void testAddContactWithEmailEmptyValue() throws SQLException, IllegalAccessException {
        Contact contact1 = new Contact("Stella Atrois", "5551465116516", "");
        ContactService contactService = new ContactService(contactDaoMock);
        Mockito.when(contactDaoMock.addContact(contact1)).thenReturn(true);
        Assert.assertTrue(contactService.addContact(contact1));
    }

    @Test
    public void testRemoveContact() throws SQLException, IllegalAccessException {
        ContactService contactService = new ContactService(contactDaoMock);
        Mockito.when(contactDaoMock.removeContact(1)).thenReturn(true);
        Assert.assertTrue(contactService.removeContact(1));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testRemoveContactWithNegativeId() throws IllegalAccessException {
        ContactDAO contactDAO = new ContactDAO();
        ContactService contactService = new ContactService(contactDAO);
        contactService.removeContact(-20);
    }

    @Test
    public void testRemoveContactWithNotContainId() throws IllegalAccessException {
        ContactDAO contactDAO = new ContactDAO();
        ContactService contactService = new ContactService(contactDAO);
        Assert.assertTrue(contactService.removeContact(5000));
    }

    @Test
    public void testListAllContactsOrderByName() throws IllegalAccessException {
        ContactDAO contactDAO = new ContactDAO();
        ContactService contactService = new ContactService(contactDAO);
        Assert.assertEquals("Colorado Appia", contactService.listAllContactsOrderByName().get(0).getFullName());
    }

    @Test
    public void testListAllContactsByNameWithNoContacts() throws IllegalAccessException {
        ContactService contactService = new ContactService(contactDaoMock);
        Assert.assertTrue(contactService.listAllContactsOrderByName().isEmpty());
    }

    @Test
    public void testListAllContactsOrderById() throws IllegalAccessException {
        ContactDAO contactDAO = new ContactDAO();
        ContactService contactService = new ContactService(contactDAO);
        Assert.assertEquals(1, contactService.listAllContactsOrderById().get(0).getId());
    }

    @Test
    public void testListAllContactsOrderByIdWithNoContacts() throws IllegalAccessException {
        ContactService contactService = new ContactService(contactDaoMock);
        Assert.assertTrue(contactService.listAllContactsOrderById().isEmpty());
    }

    @Test
    public void testSearchContactByName() throws SQLException, IllegalAccessException {
        ContactDAO contactDAO = new ContactDAO();
        ContactService contactService = new ContactService(contactDAO);
        Assert.assertEquals("Vedett Wit", contactService.searchContactByName("%Vedett%").get(0).getFullName());
    }

    @Test
    public void testSearchContactByNameList() throws SQLException, IllegalAccessException {
        ContactDAO contactDAO = new ContactDAO();
        ContactService contactService = new ContactService(contactDAO);
        Assert.assertEquals(3, contactService.searchContactByName("%Stella%").size());
    }

    @Test
    public void testSearchContactByLastName() throws SQLException, IllegalAccessException {
        ContactDAO contactDAO = new ContactDAO();
        ContactService contactService = new ContactService(contactDAO);
        Assert.assertEquals("Colorado Appia", contactService.searchContactByName("%Appia%").get(0).getFullName());
    }

    @Test
    public void testSearchContactByNotContainName() throws SQLException, IllegalAccessException {
        ContactDAO contactDAO = new ContactDAO();
        ContactService contactService = new ContactService(contactDAO);
        Assert.assertTrue(contactService.searchContactByName("%Apia%").isEmpty());
    }

    @Test
    public void testSearchContactById() throws IllegalAccessException {
        ContactDAO contactDAO = new ContactDAO();
        ContactService contactService = new ContactService(contactDAO);
        Assert.assertEquals("Vedett Wit", contactService.searchContactById(2).get().getFullName());
    }

    @Test
    public void testSearchContactByNotContainId() throws IllegalAccessException {
        ContactDAO contactDAO = new ContactDAO();
        ContactService contactService = new ContactService(contactDAO);
        Assert.assertFalse(contactService.searchContactById(5000).isPresent());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testSearchContactByNegativeId() throws IllegalAccessException {
        ContactDAO contactDAO = new ContactDAO();
        ContactService contactService = new ContactService(contactDAO);
        contactService.searchContactById(-1);
    }
}