package com.costacarol.coreengineering.tema10.dao;

import com.costacarol.coreengineering.tema10.model.Contact;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ContactDAO {

    Connection connection = ConnectionDataBase.createConnection();

    public boolean addContact(Contact contact) throws SQLException{
        String SQLCommand = "insert into contact(fullname, email, phone) values (?,?,?);";
        PreparedStatement preparedStatement = connection.prepareStatement(SQLCommand);
        preparedStatement.setString(1, contact.getFullName());
        preparedStatement.setString(2, contact.getEmail());
        preparedStatement.setString(3, contact.getPhone());
        preparedStatement.execute();
        preparedStatement.close();
        return true;
    }

    public boolean removeContact(int id) throws SQLException {
        String SQLCommand = "delete from contact where idcontact = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(SQLCommand);
        preparedStatement.setInt(1, id);
        preparedStatement.execute();
        preparedStatement.close();
        return true;
    }

    public List<Contact> listAllContactsOrderByName() throws SQLException {
        List<Contact> listAllContactsFirstName = new ArrayList<>();
        String SQLCommand = "select * from contact order by fullname;";
        PreparedStatement preparedStatement = connection.prepareStatement(SQLCommand);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Contact contact = new Contact();
            contact.setId(resultSet.getInt("idcontact"));
            contact.setFullName(resultSet.getString("fullname"));
            contact.setEmail(resultSet.getString("email"));
            contact.setPhone(resultSet.getString("phone"));
            listAllContactsFirstName.add(contact);
        }
        return listAllContactsFirstName;
    }

    public List<Contact> listAllContactsOrderById() throws SQLException{
        List<Contact> listAllContactsById = new ArrayList<>();
        String SQLCommand = "select * from contact order by idcontact;";
        PreparedStatement preparedStatement = connection.prepareStatement(SQLCommand);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Contact contact = new Contact();
            contact.setId(resultSet.getInt("idcontact"));
            contact.setFullName(resultSet.getString("fullname"));
            contact.setEmail(resultSet.getString("email"));
            contact.setPhone(resultSet.getString("phone"));
            listAllContactsById.add(contact);
        }
        return listAllContactsById;
    }

    public List<Contact> searchContactByName(String firstNameOrLastnameOrFullName) throws SQLException {
        List<Contact> contactListByName = new ArrayList<>();
        String SQLCommand = "select * from contact where fullname like ? order by fullname;";
        PreparedStatement preparedStatement = connection.prepareStatement(SQLCommand);
        preparedStatement.setString(1, firstNameOrLastnameOrFullName);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Contact contact = new Contact();
            contact.setId(resultSet.getInt("idcontact"));
            contact.setFullName(resultSet.getString("fullname"));
            contact.setEmail(resultSet.getString("email"));
            contact.setPhone(resultSet.getString("phone"));
            contactListByName.add(contact);
        }
        return contactListByName;
    }

    public Optional<Contact> searchContactById(int id) throws SQLException{
        String SQLCommand = "select * from contact where idcontact = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(SQLCommand);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()){
            Contact contact = new Contact();
            contact.setId(resultSet.getInt("idcontact"));
            contact.setFullName(resultSet.getString("fullname"));
            contact.setEmail(resultSet.getString("email"));
            contact.setPhone(resultSet.getString("phone"));
            return Optional.of(contact);
        }
        return Optional.empty();
    }

    public boolean consultContactExistenceOnDB(String fullname, String email, String phone) throws SQLException{
        String SQLCommand = "select * from contact where fullname = ? and email = ? and phone = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(SQLCommand);
        preparedStatement.setString(1, fullname);
        preparedStatement.setString(2, email);
        preparedStatement.setString(3, phone);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()){
            return true;
        }
        return false;
    }
}

