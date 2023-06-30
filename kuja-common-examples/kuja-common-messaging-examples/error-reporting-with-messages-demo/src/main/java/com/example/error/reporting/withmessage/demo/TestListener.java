package com.example.error.reporting.withmessage.demo;

import com.wingsweaver.kuja.common.messaging.errorreporting.common.ErrorRecordPayload;
import com.wingsweaver.kuja.common.utils.logging.slf4j.LogUtil;
import com.wingsweaver.kuja.common.utils.model.AbstractComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class TestListener extends AbstractComponent {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestListener.class);

    @JmsListener(destination = "${kuja.messaging.error-reporting.default-destination}")
    public void onMessage(Message<ErrorRecordPayload> message) {
        try {
            ErrorRecordPayload payload = message.getPayload();
            LogUtil.info(LOGGER, "Received error record: {}", payload);
        } catch (Exception ex) {
            LogUtil.error(LOGGER, ex, "Error while processing message");
        }
    }
}
