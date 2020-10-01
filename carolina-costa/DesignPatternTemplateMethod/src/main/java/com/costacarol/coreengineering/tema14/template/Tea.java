package com.costacarol.coreengineering.tema14.template;

public class Tea extends HotDrink {

    @Override
    public String heatTheBaseLiquid() {
        return "Aquecendo a água.";
    }

    @Override
    public String putTheWarmBaseLiquidInTheCup() {
        return "Inserindo a água aquecida no recipiente.";
    }

    @Override
    public String putTheMainIngredient() {
        return "Inserindo as folhas do chá no recipiente.";
    }

    @Override
    public String mixAll() {
        return "Misturando os ingredientes no recipiente.";
    }

    public String coverTheRecipient(){
        return "Cobrindo o recipiente.";
    }

    public String timeToPerformTheInfusion(){
        return "Aguardando 5min para realizar a infusão.";
    }

    public String openTheRecipient(){
        return "Retirando a tampa do recipiente.";
    }

    @Override
    public String makeHotDrink() {
        heatTheBaseLiquid();
        putTheWarmBaseLiquidInTheCup();
        putTheMainIngredient();
        mixAll();
        coverTheRecipient();
        timeToPerformTheInfusion();
        openTheRecipient();
        return getEND();
    }
}
