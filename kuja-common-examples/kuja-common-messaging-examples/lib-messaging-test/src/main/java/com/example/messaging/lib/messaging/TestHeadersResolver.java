package com.example.messaging.lib.messaging;

import com.example.messaging.lib.common.TestMessage;
import com.wingsweaver.kuja.common.messaging.core.send.MessageSendContext;
import com.wingsweaver.kuja.common.messaging.core.send.messaging.HeadersResolver;
import com.wingsweaver.kuja.common.utils.logging.slf4j.LogUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class TestHeadersResolver implements HeadersResolver {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestHeadersResolver.class);

    public static final String PREFIX_HEADER = "header.";

    public static final int LEN_PREFIX_HEADER = PREFIX_HEADER.length();

    @Override
    public void resolveHeaders(MessageSendContext context, Map<String, Object> headers) {
        Object originalMessage = context.getOriginalMessage();
        if (!(originalMessage instanceof TestMessage)) {
            return;
        }

        TestMessage testMessage = (TestMessage) originalMessage;
        Map<String, Object> tags = testMessage.getTags();
        if (tags != null) {
            tags.forEach((key, value) -> {
                if (key.startsWith(PREFIX_HEADER)) {
                    String realKey = key.substring(LEN_PREFIX_HEADER);
                    LogUtil.info(LOGGER, "Add header: {} = {}", realKey, value);
                    headers.put(realKey, value);
                }
            });
        }
    }
}
