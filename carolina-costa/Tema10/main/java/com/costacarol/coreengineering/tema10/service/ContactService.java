package com.costacarol.coreengineering.tema10.service;

import com.costacarol.coreengineering.tema10.dao.ContactDAO;
import com.costacarol.coreengineering.tema10.model.Contact;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ContactService {

    ContactDAO contactDao;

    public ContactService(ContactDAO contactDao) {
        this.contactDao = contactDao;
    }

    public boolean addContact(Contact contact) throws IllegalAccessException {
        if (contact == null) {
            throw new IllegalArgumentException("Parâmetro inválido: insira um contato.");
        } else if (contact.getFullName() == null || contact.getFullName().isEmpty()) {
            throw new IllegalArgumentException("Parâmetro inválido: insira o nome e o sobrenome do contato.");
        } else if ((contact.getPhone() == null || contact.getEmail() == null) || (contact.getPhone().isEmpty() && contact.getEmail().isEmpty())) {
            throw new IllegalArgumentException("Parâmetro inválido: insira ao menos um telefone ou um e-mail para este contato.");
        } else if (!contact.getEmail().isEmpty() && !contact.getEmail().contains("@")) {
            throw new IllegalArgumentException("Parâmetro inválido: insira um e-mail válido.");
        } else if (!contact.getPhone().isEmpty() && contact.getPhone().length() < 13) {
            throw new IllegalArgumentException("Parâmetro inválido: insira um telefone válido (DDI+DDD+Phone).");
        }
        try {
            if (contactDao.consultContactExistenceOnDB(contact.getFullName(), contact.getEmail(), contact.getPhone())) {
                throw new IllegalArgumentException("Parâmetro inválido: o contato informado já consta na agenda.");
            }
            contactDao.addContact(contact);
            return true;
        } catch (SQLException e) {
            throw new IllegalAccessException("Erro interno: não foi possível adicionar o contato.");
        }
    }

    public boolean removeContact(int id) throws IllegalAccessException {
        if (id <= 0) {
            throw new IllegalArgumentException("Parâmetro inválido: id informado deve ser um número positivo.");
        }
        try {
            contactDao.removeContact(id);
            return true;
        } catch (SQLException e) {
            throw new IllegalAccessException("Erro interno: não foi possível remover o contato.");
        }
    }

    public List<Contact> listAllContactsOrderByName() throws IllegalAccessException {
        try {
            List<Contact> listAllContactsOrderByName = contactDao.listAllContactsOrderByName();
            return listAllContactsOrderByName;
        } catch (SQLException e) {
            throw new IllegalAccessException("Erro interno: não foi possível listar o(s) contato(s).");
        }
    }

    public List<Contact> listAllContactsOrderById() throws IllegalAccessException {
        try {
            List<Contact> listAllContactsOrderById = contactDao.listAllContactsOrderById();
            return listAllContactsOrderById;
        } catch (SQLException e) {
            throw new IllegalAccessException("Erro interno: não foi possível listar o(s) contato(s).");
        }
    }

    public List<Contact> searchContactByName(String firstNameOrLastNameOrFullName) throws IllegalAccessException {
        if (firstNameOrLastNameOrFullName == null) {
            throw new IllegalArgumentException("Parâmetro inválido: insira um nome ou sobrenome para realizar a busca.");
        }
        try {
            List<Contact> listOfSearchContactByName = contactDao.searchContactByName(firstNameOrLastNameOrFullName);
            return listOfSearchContactByName;
        } catch (SQLException e) {
            throw new IllegalAccessException("Erro interno: não foi possível listar o(s) contato(s).");
        }
    }

    public Optional<Contact> searchContactById(int id) throws IllegalAccessException {
        if (id <= 0) {
            throw new IllegalArgumentException("Parâmetro inválido: id informado deve ser um número positivo.");
        } else try {
            Optional<Contact> listOfSearchContactById = contactDao.searchContactById(id);
            return listOfSearchContactById;
        } catch (SQLException e) {
            throw new IllegalAccessException("Erro interno: não foi possível listar o contato.");
        }
    }
}
