package com.costacarol.coreengineering.tema13.context;

import com.costacarol.coreengineering.tema13.model.Client;
import org.junit.Assert;
import org.junit.Test;

public class NotificationContextTest {

    @Test
    public void testExecuteNotificationStrategy(){
        Client client1 = new Client("Carol", "carol@carol.tech", "5199999999");
        NotificationContext notificationContext = new NotificationContext();
        Assert.assertEquals("Olá Carol! (Mensagem enviada via SMS)", notificationContext.executeNotificationStrategy(client1));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testExecuteNotificationStrategyWithNullName(){
        Client client1 = new Client(null, "carol@carol.tech", "5199999999");
        NotificationContext notificationContext = new NotificationContext();
        notificationContext.executeNotificationStrategy(client1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testExecuteNotificationStrategyWithNullEmail(){
        Client client1 = new Client("Carol", null, "5199999999");
        NotificationContext notificationContext = new NotificationContext();
        notificationContext.executeNotificationStrategy(client1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testExecuteNotificationStrategyWithNullNameAndNullEmail(){
        Client client1 = new Client(null, null, "5199999999");
        NotificationContext notificationContext = new NotificationContext();
        notificationContext.executeNotificationStrategy(client1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testExecuteNotificationStrategyWithAllNullParameters(){
        Client client1 = new Client(null, null, null);
        NotificationContext notificationContext = new NotificationContext();
        notificationContext.executeNotificationStrategy(client1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testExecuteNotificationStrategyWithAllEmptyParameters(){
        Client client1 = new Client("", "", "");
        NotificationContext notificationContext = new NotificationContext();
        notificationContext.executeNotificationStrategy(client1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testExecuteNotificationStrategyWithEmptyName(){
        Client client1 = new Client("", "carol@carol.tech", "5199999999");
        NotificationContext notificationContext = new NotificationContext();
        notificationContext.executeNotificationStrategy(client1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testExecuteNotificationStrategyWithEmptyEmail(){
        Client client1 = new Client("Carol", "", "5199999999");
        NotificationContext notificationContext = new NotificationContext();
        notificationContext.executeNotificationStrategy(client1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testExecuteNotificationStrategyWithInvalidNumber(){
        Client client1 = new Client("Carol", "carol@carol.tech", "519999999");
        NotificationContext notificationContext = new NotificationContext();
        notificationContext.executeNotificationStrategy(client1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testExecuteNotificationStrategyWithInvalidMail(){
        Client client1 = new Client("", "carolcarol.tech", "5199999999");
        NotificationContext notificationContext = new NotificationContext();
        notificationContext.executeNotificationStrategy(client1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testExecuteNotificationStrategyNotContainOnlyNumbers(){
        Client client1 = new Client("Carol", "carol@carol.tech", "51999a9999");
        NotificationContext notificationContext = new NotificationContext();
        notificationContext.executeNotificationStrategy(client1);
    }

    @Test
    public void testExecuteNotificationStrategyWithEmptyPhone(){
        Client client1 = new Client("Carol", "carol@carol.tech", "");
        NotificationContext notificationContext = new NotificationContext();
        Assert.assertEquals("Olá Carol! (Mensagem enviada via e-mail)", notificationContext.executeNotificationStrategy(client1));
    }

    @Test
    public void testExecuteNotificationStrategyWithNullPhone(){
        Client client1 = new Client("Carol", "carol@carol.tech", null);
        NotificationContext notificationContext = new NotificationContext();
        Assert.assertEquals("Olá Carol! (Mensagem enviada via e-mail)", notificationContext.executeNotificationStrategy(client1));
    }
}