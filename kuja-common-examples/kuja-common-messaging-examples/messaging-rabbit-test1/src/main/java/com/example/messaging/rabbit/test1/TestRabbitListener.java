package com.example.messaging.rabbit.test1;

import com.example.messaging.lib.common.TestMessage;
import com.wingsweaver.kuja.common.utils.logging.slf4j.LogUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class TestRabbitListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestRabbitListener.class);

    @RabbitListener(queues = "test-topic-1")
    public void onMessage(@Payload TestMessage testMessage, Message rabbitMessage) {
        this.showRabbitMessage(rabbitMessage);
        LogUtil.info(LOGGER, "Received message: {}", testMessage);
    }

    private void showRabbitMessage(Message rabbitMessage) {
        MessageProperties properties = rabbitMessage.getMessageProperties();
        LogUtil.info(LOGGER, "Rabbit Message ID: {}", properties.getMessageId());
        LogUtil.info(LOGGER, "Rabbit Message App ID: {}", properties.getAppId());
        LogUtil.info(LOGGER, "Rabbit Message Cluster ID: {}", properties.getClusterId());
        LogUtil.info(LOGGER, "Rabbit Message Content Encoding: {}", properties.getContentEncoding());
        LogUtil.info(LOGGER, "Rabbit Message Content Length: {}", properties.getContentLength());
        LogUtil.info(LOGGER, "Rabbit Message Content Type: {}", properties.getContentType());
        LogUtil.info(LOGGER, "Rabbit Message Correlation ID: {}", properties.getCorrelationId());
        LogUtil.info(LOGGER, "Rabbit Message Delivery Mode: {}", properties.getDeliveryMode());
        LogUtil.info(LOGGER, "Rabbit Message Expiration: {}", properties.getExpiration());
        LogUtil.info(LOGGER, "Rabbit Message Priority: {}", properties.getPriority());
        LogUtil.info(LOGGER, "Rabbit Message Received Exchange: {}", properties.getReceivedExchange());
        LogUtil.info(LOGGER, "Rabbit Message Received Routing Key: {}", properties.getReceivedRoutingKey());
        LogUtil.info(LOGGER, "Rabbit Message Reply To: {}", properties.getReplyTo());
        LogUtil.info(LOGGER, "Rabbit Message Timestamp: {}", properties.getTimestamp());
        LogUtil.info(LOGGER, "Rabbit Message Type: {}", properties.getType());
        LogUtil.info(LOGGER, "Rabbit Message User ID: {}", properties.getUserId());

        LogUtil.info(LOGGER, "Rabbit Message Headers:");
        properties.getHeaders().forEach((key, value) -> {
            LogUtil.info(LOGGER, "\t{} = {}", key, value);
        });
    }
}
