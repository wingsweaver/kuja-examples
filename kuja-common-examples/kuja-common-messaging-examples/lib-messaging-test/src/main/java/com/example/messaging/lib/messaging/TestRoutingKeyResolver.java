package com.example.messaging.lib.messaging;

import com.example.messaging.lib.common.TestMessage;
import com.wingsweaver.kuja.common.messaging.core.send.MessageSendContext;
import com.wingsweaver.kuja.common.messaging.core.send.rabbit.RoutingKeyResolver;
import com.wingsweaver.kuja.common.utils.logging.slf4j.LogUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestRoutingKeyResolver implements RoutingKeyResolver {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestRoutingKeyResolver.class);

    @Override
    public String resolveRoutingKey(MessageSendContext context) {
        Object originalMessage = context.getOriginalMessage();
        if (!(originalMessage instanceof TestMessage)) {
            return null;
        }

        TestMessage testMessage = (TestMessage) originalMessage;
        String routingKey = testMessage.getTagValue("routingKey");
        LogUtil.info(LOGGER, "Resolved routing key: {}", routingKey);
        return routingKey;
    }
}
