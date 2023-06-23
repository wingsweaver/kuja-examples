package com.example.messaging.redis.test1;

import com.example.messaging.lib.common.TestMessage;
import com.wingsweaver.kuja.common.utils.logging.slf4j.LogUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.stream.Record;
import org.springframework.data.redis.stream.StreamListener;
import org.springframework.stereotype.Service;

@Service
public class TestRedisListener implements StreamListener<String, Record<String, TestMessage>> {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestRedisListener.class);

    @Override
    public void onMessage(Record<String, TestMessage> message) {
        LogUtil.info(LOGGER, "Record id: {}", message.getId());
        Object payload = message.getValue();
        LogUtil.info(LOGGER, "Record body: {}", payload);
    }
}
