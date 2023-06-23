package com.example.messaging.lib.messaging;

import com.example.messaging.lib.common.TestMessage;
import com.wingsweaver.kuja.common.messaging.core.send.MessageSendContext;
import com.wingsweaver.kuja.common.messaging.core.send.messaging.PostProcessorResolver;
import com.wingsweaver.kuja.common.utils.logging.slf4j.LogUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.core.MessagePostProcessor;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class TestPostProcessorResolver implements PostProcessorResolver {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestPostProcessorResolver.class);

    @Override
    public void resolvePostProcessors(MessageSendContext context, List<MessagePostProcessor> postProcessors) {
        postProcessors.add(message -> {
            Object payload = message.getPayload();
            if (payload instanceof TestMessage) {
                TestMessage testMessage = (TestMessage) payload;
                String tag = new Date().toString() + UUID.randomUUID();
                LogUtil.info(LOGGER, "Add post-processed tag: {}", tag);
                testMessage.setTagValue("post-processed", tag);
            }
            return message;
        });
    }
}
