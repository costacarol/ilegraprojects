package com.costacarol.coreengineering.tema5;

public class StateLamp {

    private Lamp lamp;

    public StateLamp(Lamp lamp){
        this.lamp = lamp;
    }

    public void switchState() {
        if (lamp.getState()) {
            lamp.off();
        } else {
            lamp.on();
        }
    }
}

