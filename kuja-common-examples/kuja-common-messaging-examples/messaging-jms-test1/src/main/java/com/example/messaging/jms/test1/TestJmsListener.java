package com.example.messaging.jms.test1;

import com.example.messaging.lib.common.TestMessage;
import com.wingsweaver.kuja.common.utils.logging.slf4j.LogUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.Message;
import java.util.Collections;
import java.util.List;

@Component
public class TestJmsListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestJmsListener.class);

    @JmsListener(destination = "test-topic-1")
    public void onMessage(TestMessage testMessage, Message jmsMessage) {
        this.showJmsMessage(jmsMessage);
        LogUtil.info(LOGGER, "Received message: {}", testMessage);
    }

    @SuppressWarnings("unchecked")
    void showJmsMessage(Message jmsMessage) {
        try {
            LogUtil.info(LOGGER, "JMS Message ID: {}", jmsMessage.getJMSMessageID());
            LogUtil.info(LOGGER, "JMS Message Type: {}", jmsMessage.getJMSType());
            LogUtil.info(LOGGER, "JMS Message Correlation ID: {}", jmsMessage.getJMSCorrelationID());
            LogUtil.info(LOGGER, "JMS Message Delivery Mode: {}", jmsMessage.getJMSDeliveryMode());
            LogUtil.info(LOGGER, "JMS Message Expiration: {}", jmsMessage.getJMSExpiration());
            LogUtil.info(LOGGER, "JMS Message Priority: {}", jmsMessage.getJMSPriority());
            LogUtil.info(LOGGER, "JMS Message Redelivered: {}", jmsMessage.getJMSRedelivered());
            LogUtil.info(LOGGER, "JMS Message Timestamp: {}", jmsMessage.getJMSTimestamp());
            LogUtil.info(LOGGER, "JMS Message Destination: {}", jmsMessage.getJMSDestination());
            LogUtil.info(LOGGER, "JMS Message Reply To: {}", jmsMessage.getJMSReplyTo());

            LogUtil.info(LOGGER, "JMS Message Properties:");
            List<?> propertyNames = Collections.list(jmsMessage.getPropertyNames());
            propertyNames.forEach(propertyName -> {
                try {
                    LogUtil.info(LOGGER, "\t{} = {}", propertyName, jmsMessage.getObjectProperty((String) propertyName));
                } catch (Exception ex) {
                    // 忽略此错误
                }
            });
        } catch (Exception ex) {
            // 忽略此错误
        }
    }
}
