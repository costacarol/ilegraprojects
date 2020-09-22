package com.costacarol.coreengineering.tema6;

import java.util.Arrays;

public class Contact {

    private String name;
    private int id;
    private long phone;

    public Contact(String name, long phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getPhone() {
        return phone;
    }

    private void setPhone(long phone) {
        this.phone = phone;
    }

    @Override
    public String toString(){
        return "ID: " + getId() + ", nome: " + getName() + ", telefone: " + getPhone() + ".";
    }
}
