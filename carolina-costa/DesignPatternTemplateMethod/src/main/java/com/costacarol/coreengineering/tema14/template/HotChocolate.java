package com.costacarol.coreengineering.tema14.template;

public class HotChocolate extends HotDrink {

    @Override
    public String heatTheBaseLiquid() {
        return "Aquecendo o leite.";
    }

    @Override
    public String putTheWarmBaseLiquidInTheCup() {
        return "Inserindo o leite no recipiente.";
    }

    public String putTheCornFlour() {
        return "Inserindo o amido de milho para dar consistência.";
    }

    public String putTheCreamOfMilk() {
        return "Inserindo o creme de leite.";
    }

    @Override
    public String putTheMainIngredient() {
        return "Inserindo o chocolate em pó, a canela e o açúcar no recipiente.";
    }

    @Override
    public String mixAll() {
        return "Misturando os ingredientes no recipiente e finalizando o chocolate quente!";
    }

    @Override
    public String makeHotDrink() {
        heatTheBaseLiquid();
        putTheWarmBaseLiquidInTheCup();
        putTheCornFlour();
        putTheCreamOfMilk();
        putTheMainIngredient();
        mixAll();
        return getEND();
    }
}
