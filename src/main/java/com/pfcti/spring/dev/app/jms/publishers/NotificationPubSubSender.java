package com.pfcti.spring.dev.app.jms.publishers;

import com.pfcti.spring.dev.app.dto.CuentaDto;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.messaging.Message;

/**
 * advance
 * 28/4/23
 */
@MessagingGateway
public interface NotificationPubSubSender {

    @Gateway(requestChannel = "pubSubNotification")
    Message<String> sendNotification(Message<CuentaDto> message);
}
