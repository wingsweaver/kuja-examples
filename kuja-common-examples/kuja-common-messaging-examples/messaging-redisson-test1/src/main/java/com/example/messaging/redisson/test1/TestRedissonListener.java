package com.example.messaging.redisson.test1;

import com.example.messaging.lib.common.TestMessage;
import com.wingsweaver.kuja.common.messaging.boot.redisson.RedissonSendServiceProperties;
import com.wingsweaver.kuja.common.utils.logging.slf4j.LogUtil;
import org.redisson.api.RTopic;
import org.redisson.api.RedissonClient;
import org.redisson.api.listener.MessageListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class TestRedissonListener implements InitializingBean, DisposableBean, MessageListener<TestMessage> {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestRedissonListener.class);

    private final RedissonClient redissonClient;

    private final RedissonSendServiceProperties properties;

    private final String topicName;

    private RTopic topic;

    public TestRedissonListener(RedissonClient redissonClient, RedissonSendServiceProperties properties) {
        this.redissonClient = redissonClient;
        this.properties = properties;
        this.topicName = String.valueOf(this.properties.getDefaultDestination());
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        LogUtil.info(LOGGER, "Creating Redisson Topic {} ...", this.topicName);
        this.topic = this.redissonClient.getTopic(this.topicName);

        LogUtil.info(LOGGER, "Adding listener to Redisson Topic {} ...", this.topicName);
        this.topic.addListener(TestMessage.class, this);
    }

    @Override
    public void destroy() throws Exception {
        LogUtil.info(LOGGER, "Removing listener from Redisson Topic {} ...", this.topicName);
        this.topic.removeListener(this);
    }

    @Override
    public void onMessage(CharSequence channel, TestMessage msg) {
        LogUtil.info(LOGGER, "Received message from Redisson Topic: {}", msg);
    }
}
