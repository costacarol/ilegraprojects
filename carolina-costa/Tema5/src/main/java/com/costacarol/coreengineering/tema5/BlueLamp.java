package com.costacarol.coreengineering.tema5;

public class BlueLamp implements Lamp {

    public BlueLamp(){
    }

    private boolean state;

    @Override
    public void on(){
        state = true;
        System.out.println("Lâmpada ligada com sucesso.");
    }
    @Override
    public void off() {
        state = false;
        System.out.println("Lâmpada desligada com sucesso.");
    }

    @Override
    public boolean getState() {
        return state;
    }

}
