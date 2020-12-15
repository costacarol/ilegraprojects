package com.costacarol.coreengineering.tema13.strategy;

import com.costacarol.coreengineering.tema13.model.Client;

public class SmsNotificationStrategy implements NotificationStrategy {

    @Override
    public String sendMessage(Client client) {
        return "Olá " + client.getName() + "! (Mensagem enviada via SMS)";
    }
}
