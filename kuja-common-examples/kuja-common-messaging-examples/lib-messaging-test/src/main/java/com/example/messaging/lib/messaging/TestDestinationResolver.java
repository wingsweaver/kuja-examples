package com.example.messaging.lib.messaging;

import com.example.messaging.lib.common.TestMessage;
import com.wingsweaver.kuja.common.messaging.core.send.MessageSendContext;
import com.wingsweaver.kuja.common.messaging.core.send.common.DestinationResolver;
import com.wingsweaver.kuja.common.utils.logging.slf4j.LogUtil;
import com.wingsweaver.kuja.common.utils.model.tuple.Tuple2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestDestinationResolver implements DestinationResolver {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestDestinationResolver.class);

    @Override
    public Tuple2<Boolean, Object> resolveDestination(MessageSendContext context) {
        Object originalMessage = context.getOriginalMessage();
        if (!(originalMessage instanceof TestMessage)) {
            return UNHANDLED;
        }

        TestMessage testMessage = (TestMessage) originalMessage;
        Object destination = testMessage.getTagValue("destination");
        LogUtil.info(LOGGER, "Resolved destination: {}", destination);
        return Tuple2.of(true, destination);
    }
}
