package com.example.messaging.lib.messaging;

import com.example.messaging.lib.common.TestMessage;
import com.wingsweaver.kuja.common.messaging.core.send.MessageSendContext;
import com.wingsweaver.kuja.common.messaging.core.send.common.PayloadResolver;
import com.wingsweaver.kuja.common.utils.logging.slf4j.LogUtil;
import com.wingsweaver.kuja.common.utils.model.tags.convert.TagConversionService;
import com.wingsweaver.kuja.common.utils.model.tuple.Tuple2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

public class TestPayloadResolver implements PayloadResolver {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestPayloadResolver.class);

    @Override
    public Tuple2<Boolean, Object> resolvePayload(MessageSendContext context) {
        Object originalMessage = context.getOriginalMessage();
        if (!(originalMessage instanceof TestMessage)) {
            return UNHANDLED;
        }

        TestMessage testMessage = (TestMessage) originalMessage;
        Object tagValue = testMessage.getTagValue("customPayload", false);
        boolean customPayload = TagConversionService.toValue(tagValue, Boolean.class);
        if (customPayload) {
            String uuid = UUID.randomUUID().toString();
            LogUtil.info(LOGGER, "Update payload, add uuid {}", uuid);
            testMessage.setTagValue("uuid", uuid);
        }

        return Tuple2.of(true, testMessage);
    }
}
