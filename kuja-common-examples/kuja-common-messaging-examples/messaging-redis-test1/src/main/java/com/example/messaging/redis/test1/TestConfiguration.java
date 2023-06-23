package com.example.messaging.redis.test1;

import com.example.messaging.lib.common.TestMessage;
import com.wingsweaver.kuja.common.boot.model.AbstractConfiguration;
import com.wingsweaver.kuja.common.messaging.boot.redis.RedisSendServiceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.stream.ReadOffset;
import org.springframework.data.redis.connection.stream.StreamOffset;
import org.springframework.data.redis.stream.StreamMessageListenerContainer;
import org.springframework.data.redis.stream.Subscription;

import java.time.Duration;

@Configuration
public class TestConfiguration extends AbstractConfiguration {
    @SuppressWarnings({"unchecked", "rawtypes"})
    @Bean
    public Subscription testSubscription(
            RedisConnectionFactory redisConnectionFactory,
            RedisSendServiceProperties properties,
            TestRedisListener testRedisListener) {
        StreamMessageListenerContainer.StreamMessageListenerContainerOptions options =
                StreamMessageListenerContainer.StreamMessageListenerContainerOptions
                        .builder()
                        .pollTimeout(Duration.ofSeconds(5))
                        .targetType(TestMessage.class)
                        .build();
        StreamMessageListenerContainer listenerContainer = StreamMessageListenerContainer.create(redisConnectionFactory, options);
        String streamKey = String.valueOf(properties.getDefaultDestination());
        Subscription subscription = listenerContainer
                .receive(StreamOffset.create(streamKey, ReadOffset.lastConsumed()), testRedisListener);
        listenerContainer.start();
        return subscription;
    }
}
