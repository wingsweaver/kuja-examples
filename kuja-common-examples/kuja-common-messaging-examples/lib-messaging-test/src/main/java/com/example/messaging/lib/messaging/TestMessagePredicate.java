package com.example.messaging.lib.messaging;

import com.example.messaging.lib.common.TestMessage;
import com.wingsweaver.kuja.common.messaging.core.send.common.MessagePredicate;
import com.wingsweaver.kuja.common.utils.logging.slf4j.LogUtil;
import com.wingsweaver.kuja.common.utils.model.tags.convert.TagConversionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestMessagePredicate implements MessagePredicate {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestMessagePredicate.class);

    @Override
    public boolean supportMessage(Object message) {
        if (!(message instanceof TestMessage)) {
            return false;
        }

        TestMessage testMessage = (TestMessage) message;
        Object enabled = testMessage.getTagValue("enabled", true);
        LogUtil.info(LOGGER, "Message enabled: {}", enabled);
        return TagConversionService.toValue(enabled, Boolean.class);
    }
}
