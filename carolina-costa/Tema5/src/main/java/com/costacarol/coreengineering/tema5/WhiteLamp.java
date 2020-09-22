package com.costacarol.coreengineering.tema5;

public class WhiteLamp implements Lamp {

    public WhiteLamp(){
    }

    private boolean state;


    @Override
    public void on() {
        state = true;
        System.out.println("Lâmpada ligada com sucesso.");
    }

    @Override
    public void off(){
        state = false;
        System.out.println("Lâmpada desligada com sucesso.");
    }

    @Override
    public boolean getState() {
        return state;
    }

}
