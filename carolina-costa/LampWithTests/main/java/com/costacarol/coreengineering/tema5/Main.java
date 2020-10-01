package com.costacarol.coreengineering.tema5;

public class Main {
    public static void main(String[] args) {
        BlueLamp blueLamp = new BlueLamp();
        WhiteLamp whiteLamp = new WhiteLamp();
        StateLamp stateWhite = new StateLamp(whiteLamp);
        StateLamp stateBlue = new StateLamp(blueLamp);

        stateWhite.switchState();
        stateWhite.switchState();

        stateBlue.switchState();
        stateBlue.switchState();
    }
}

