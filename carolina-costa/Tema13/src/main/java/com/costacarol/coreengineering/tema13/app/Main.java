package com.costacarol.coreengineering.tema13.app;

import com.costacarol.coreengineering.tema13.model.Client;
import com.costacarol.coreengineering.tema13.context.NotificationContext;

public class Main {

    public static void main(String[] args) {
        NotificationContext notificationContext = new NotificationContext();
        Client client1 = new Client("Carol", "carol@carol.tech", "5199999999");
        System.out.println(notificationContext.executeNotificationStrategy(client1));

        Client client2 = new Client("Carol", "carol@carol.tech", "");
        System.out.println(notificationContext.executeNotificationStrategy(client2));
    }
}
