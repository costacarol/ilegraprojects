package com.costacarol.coreengineering.tema14;

import com.costacarol.coreengineering.tema14.template.HotChocolate;
import com.costacarol.coreengineering.tema14.template.HotDrink;
import com.costacarol.coreengineering.tema14.template.Tea;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class HotChocolateTest {

    @Test
    public void heatBaseLiquidOnHotChocolateClass() {
        HotChocolate hotChocolate = new HotChocolate();
        Assert.assertEquals("Aquecendo o leite.", hotChocolate.heatTheBaseLiquid());
    }

    @Test
    public void putTheWarmBaseLiquidInTheCupHotChocolateClass() {
        HotChocolate hotChocolate = new HotChocolate();
        Assert.assertEquals("Inserindo o leite no recipiente.", hotChocolate.putTheWarmBaseLiquidInTheCup());
    }

    @Test
    public void putTheCornFlour() {
        HotChocolate hotChocolate = new HotChocolate();
        Assert.assertEquals("Inserindo o amido de milho para dar consistência.", hotChocolate.putTheCornFlour());
    }

    @Test
    public void putTheCreamOfMilk() {
        HotChocolate hotChocolate = new HotChocolate();
        Assert.assertEquals("Inserindo o creme de leite.", hotChocolate.putTheCreamOfMilk());
    }

    @Test
    public void putTheIngredientHotChocolateClass() {
        HotChocolate hotChocolate = new HotChocolate();
        Assert.assertEquals("Inserindo o chocolate em pó, a canela e o açúcar no recipiente.", hotChocolate.putTheMainIngredient());
    }

    @Test
    public void mixAllOnHotChocolateClass() {
        HotChocolate hotChocolate = new HotChocolate();
        Assert.assertEquals("Misturando os ingredientes no recipiente e finalizando o chocolate quente!", hotChocolate.mixAll());
    }

    @Test
    public void makeAHotChocolateDrink(){
        HotChocolate hotChocolate = mock(HotChocolate.class);
        when(hotChocolate.makeHotDrink()).thenCallRealMethod();
        hotChocolate.makeHotDrink();
        verify(hotChocolate, times(1)).heatTheBaseLiquid();
        verify(hotChocolate, times(1)).putTheWarmBaseLiquidInTheCup();
        verify(hotChocolate, times(1)).putTheCornFlour();
        verify(hotChocolate, times(1)).putTheCreamOfMilk();
        verify(hotChocolate, times(1)).putTheMainIngredient();
        verify(hotChocolate, times(1)).mixAll();
    }

    @Test
    public void makeAHotChocolateInOrder(){
        HotChocolate hotChocolate = mock(HotChocolate.class);
        when(hotChocolate.makeHotDrink()).thenCallRealMethod();
        hotChocolate.makeHotDrink();
        InOrder hotDrinkInOrder = Mockito.inOrder(hotChocolate);
        hotDrinkInOrder.verify(hotChocolate).heatTheBaseLiquid();
        hotDrinkInOrder.verify(hotChocolate).putTheWarmBaseLiquidInTheCup();
        hotDrinkInOrder.verify(hotChocolate).putTheCornFlour();
        hotDrinkInOrder.verify(hotChocolate).putTheCreamOfMilk();
        hotDrinkInOrder.verify(hotChocolate).putTheMainIngredient();
        hotDrinkInOrder.verify(hotChocolate).mixAll();
        hotDrinkInOrder.verify(hotChocolate).getEND();
    }
}