package com.costacarol.coreengineering.tema10.model;

public class Contact {

    private String fullName, email, phone;
    private int id;

    public Contact(){

    }

    public Contact(String fullName, String phone, String email) {
        this.fullName = fullName;
        this.phone = phone;
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public String toString(){
        return "ID: " + getId() + ", nome: " + getFullName() + " , telefone: " + getPhone() + ", email: " + getEmail() + ".";
    }
}