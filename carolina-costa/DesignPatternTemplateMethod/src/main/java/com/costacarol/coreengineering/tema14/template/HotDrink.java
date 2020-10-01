package com.costacarol.coreengineering.tema14.template;

public abstract class HotDrink {

    public abstract String heatTheBaseLiquid();

    public abstract String putTheWarmBaseLiquidInTheCup();

    public abstract String putTheMainIngredient();

    public abstract String mixAll();

    public abstract String makeHotDrink();

    private final String END = "Bebida finalizada e pronta para consumo!";

    public String getEND() {
        return END;
    }


}
