package com.example.messaging.lib.controller;

import com.example.messaging.lib.common.TestMessage;
import com.wingsweaver.kuja.common.boot.context.BusinessContext;
import com.wingsweaver.kuja.common.boot.returnvalue.ReturnValue;
import com.wingsweaver.kuja.common.messaging.core.send.MessageSendCallback;
import com.wingsweaver.kuja.common.messaging.core.send.MessageSendContext;
import com.wingsweaver.kuja.common.messaging.core.send.MessageSender;
import com.wingsweaver.kuja.common.utils.logging.slf4j.LogUtil;
import com.wingsweaver.kuja.common.web.context.WebContextAccessor;
import com.wingsweaver.kuja.common.web.controller.AbstractController;
import com.wingsweaver.kuja.common.web.wrapper.WebRequestWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.UUID;

@RestController
@RequestMapping("/api/test")
public class TestController extends AbstractController implements MessageSendCallback {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private MessageSender messageSender;

    @RequestMapping()
    public ReturnValue test(BusinessContext businessContext) {
        TestMessage testMessage = this.createTestMessage(businessContext);
        LogUtil.info(LOGGER, "Create message: {}", testMessage);
        this.messageSender.send(testMessage, this);
        return this.success(testMessage);
    }

    private TestMessage createTestMessage(BusinessContext businessContext) {
        TestMessage testMessage = new TestMessage();
        testMessage.setId(UUID.randomUUID().toString());
        testMessage.setTimestamp(System.currentTimeMillis());

        WebContextAccessor contextAccessor = new WebContextAccessor(businessContext);
        WebRequestWrapper requestWrapper = contextAccessor.getRequestWrapper();
        Collection<String> parameterNames = requestWrapper.getParameterNames();
        if (!CollectionUtils.isEmpty(parameterNames)) {
            for (String parameterName : parameterNames) {
                testMessage.setTagValue(parameterName, requestWrapper.getParameter(parameterName));
            }
        }

        return testMessage;
    }

    @Override
    public void onStart(MessageSendContext context) {
        LogUtil.info(LOGGER, "Start sending message, id = {}, message = {}, creationTimeUtc = {}",
                context.getContextId(), context.getOriginalMessage(), context.getCreationTimeUtc());
    }

    @Override
    public void onSuccess(MessageSendContext context) {
        LogUtil.info(LOGGER, "Completed sending message, id = {}, message = {}, creationTimeUtc = {}",
                context.getContextId(), context.getOriginalMessage(), context.getCreationTimeUtc());
    }

    @Override
    public void onFail(MessageSendContext context, Throwable error) {
        LogUtil.info(LOGGER, error, "Failed sending message, id = {}, message = {}, creationTimeUtc = {}",
                context.getContextId(), context.getOriginalMessage(), context.getCreationTimeUtc());

    }
}
