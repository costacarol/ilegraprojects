package com.costacarol.coreengineering.tema13.strategy;

import com.costacarol.coreengineering.tema13.model.Client;

public interface NotificationStrategy {

    String sendMessage(Client client);

}
