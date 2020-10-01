package com.costacarol.coreengineering.tema13.context;

import com.costacarol.coreengineering.tema13.model.Client;
import com.costacarol.coreengineering.tema13.strategy.EmailNotificationStrategy;
import com.costacarol.coreengineering.tema13.strategy.NotificationStrategy;
import com.costacarol.coreengineering.tema13.strategy.SmsNotificationStrategy;

public class NotificationContext {

    public boolean isNameInvalid(Client client){
        return client.getName() == null || client.getName().isEmpty();
    }

    public boolean isEmailInvalid(Client client){
        return client.getEmail() == null || client.getEmail().isEmpty() || !client.getEmail().contains("@");
    }

    public boolean isPhoneInvalid(Client client){
        return client.getPhone() == null || client.getPhone().isEmpty();
    }

    public String executeNotificationStrategy(Client client) {
        if (isNameInvalid(client)) {
            throw new IllegalArgumentException("Campo obrigatório: insira um nome válido.");
        } else if (isEmailInvalid(client)) {
            throw new IllegalArgumentException("Campo obrigatório: insira um e-mail válido.");
        }else if ((!isPhoneInvalid(client) && !client.getPhone().matches("\\d+")) || (!isPhoneInvalid(client) && client.getPhone().length() < 10 )) {
            throw new IllegalArgumentException("Telefone inválido: o número de telefone móvel deve conter somente números (DDD+número).");
        } else if (client.getPhone() != null && !client.getPhone().isEmpty()) {
            NotificationStrategy notificationStrategy = new SmsNotificationStrategy();
            return notificationStrategy.sendMessage(client);
        } else {
            NotificationStrategy notificationStrategy = new EmailNotificationStrategy();
            return notificationStrategy.sendMessage(client);
        }
    }
}


