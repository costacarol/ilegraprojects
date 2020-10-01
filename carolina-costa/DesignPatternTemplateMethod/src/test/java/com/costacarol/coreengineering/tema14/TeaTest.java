package com.costacarol.coreengineering.tema14;

import com.costacarol.coreengineering.tema14.template.Tea;
import com.costacarol.coreengineering.tema14.template.HotDrink;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.mockito.verification.VerificationMode;

import static org.mockito.Mockito.*;

public class TeaTest {

    @Test
    public void heatTheWaterOnTeaClass() {
        Tea tea = new Tea();
        Assert.assertEquals("Aquecendo a água.", tea.heatTheBaseLiquid());
    }

    @Test
    public void putTheWaterInTheCupOnTeaClass() {
        Tea tea = new Tea();
        Assert.assertEquals("Inserindo a água aquecida no recipiente.", tea.putTheWarmBaseLiquidInTheCup());
    }

    @Test
    public void putTheMainIngredientOnTeaClass() {
        Tea tea = new Tea();
        Assert.assertEquals("Inserindo as folhas do chá no recipiente.", tea.putTheMainIngredient());
    }

    @Test
    public void mixAllOnTeaClass() {
        Tea tea = new Tea();
        Assert.assertEquals("Misturando os ingredientes no recipiente.", tea.mixAll());
    }

    @Test
    public void coverTheRecipient() {
        Tea tea = new Tea();
        Assert.assertEquals("Cobrindo o recipiente.", tea.coverTheRecipient());
    }

    @Test
    public void timeToPerformTheInfusion() {
        Tea tea = new Tea();
        Assert.assertEquals("Aguardando 5min para realizar a infusão.", tea.timeToPerformTheInfusion());
    }

    @Test
    public void openTheRecipient() {
        Tea tea = new Tea();
        Assert.assertEquals("Retirando a tampa do recipiente.", tea.openTheRecipient());
    }

    @Test
    public void makeATeaDrink(){
        Tea tea = mock(Tea.class);
        when(tea.makeHotDrink()).thenCallRealMethod();
        tea.makeHotDrink();
        verify(tea, times(1)).heatTheBaseLiquid();
        verify(tea, times(1)).putTheWarmBaseLiquidInTheCup();
        verify(tea, times(1)).putTheMainIngredient();
        verify(tea, times(1)).mixAll();
        verify(tea, times(1)).coverTheRecipient();
        verify(tea, times(1)).timeToPerformTheInfusion();
        verify(tea, times(1)).openTheRecipient();
    }

    @Test
    public void makeATeaDrinkInOrder(){
        Tea tea = mock(Tea.class);
        when(tea.makeHotDrink()).thenCallRealMethod();
        InOrder makeTeaInOrder = Mockito.inOrder(tea);
        tea.makeHotDrink();
        makeTeaInOrder.verify(tea).heatTheBaseLiquid();
        makeTeaInOrder.verify(tea).putTheWarmBaseLiquidInTheCup();
        makeTeaInOrder.verify(tea).putTheMainIngredient();
        makeTeaInOrder.verify(tea).mixAll();
        makeTeaInOrder.verify(tea).coverTheRecipient();
        makeTeaInOrder.verify(tea).timeToPerformTheInfusion();
        makeTeaInOrder.verify(tea).openTheRecipient();
        makeTeaInOrder.verify(tea).getEND();
    }
}