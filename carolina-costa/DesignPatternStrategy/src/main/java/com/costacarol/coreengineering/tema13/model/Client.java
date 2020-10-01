package com.costacarol.coreengineering.tema13.model;

public class Client {

    private String name, email, phone;

    public Client(String name, String email, String phone){
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    private void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    private void setPhone(String phone) {
        this.phone = phone;
    }
}
