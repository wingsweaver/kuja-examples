package com.example.messaging.broadcast.jms.jee.test1;

import com.wingsweaver.kuja.common.boot.appinfo.matcher.AppInfoMatcherSpec;
import com.wingsweaver.kuja.common.boot.appinfo.matcher.AppInfoValueEqualsMatcherSpec;
import com.wingsweaver.kuja.common.boot.returnvalue.ReturnValue;
import com.wingsweaver.kuja.common.messaging.broadcast.send.builtin.ConfigLogLevelMessage;
import com.wingsweaver.kuja.common.messaging.broadcast.send.builtin.ShutDownApplicationMessage;
import com.wingsweaver.kuja.common.messaging.core.send.MessageSender;
import com.wingsweaver.kuja.common.utils.model.AbstractPojo;
import com.wingsweaver.kuja.common.utils.support.lang.StringUtil;
import com.wingsweaver.kuja.common.web.controller.AbstractController;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.logging.LogLevel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequestMapping("/api/test")
public class TestController extends AbstractController {
    @Autowired
    private MessageSender messageSender;

    @PostMapping("/config-level")
    public ReturnValue configLogLevel(@RequestBody ConfigLogLevelQuery query) {
        ConfigLogLevelMessage message = new ConfigLogLevelMessage();
        message.setTarget(this.createTargetSpec(query));

        ConfigLogLevelMessage.Config config = new ConfigLogLevelMessage.Config();
        config.setName(query.getName());
        config.setLogLevel(LogLevel.valueOf(query.getLogLevel().toUpperCase()));
        message.setContent(Collections.singletonList(config));

        messageSender.send(message);
        return this.success();
    }

    @PostMapping("/shut-down")
    public ReturnValue shutDown(@RequestBody ShutDownQuery query) {
        ShutDownApplicationMessage message = new ShutDownApplicationMessage();
        message.setTarget(this.createTargetSpec(query));
        messageSender.send(message);
        return this.success();
    }


    protected AppInfoMatcherSpec createTargetSpec(BaseQuery query) {
        if (StringUtil.isEmpty(query.getTargetKey())) {
            return null;
        }

        AppInfoValueEqualsMatcherSpec spec = new AppInfoValueEqualsMatcherSpec();
        spec.setKey(query.getTargetKey());
        spec.setTarget(query.getTargetValue());
        return spec;
    }

    @Getter
    @Setter
    public static class BaseQuery extends AbstractPojo {
        private String targetKey;

        private String targetValue;
    }

    @Getter
    @Setter
    public static class ConfigLogLevelQuery extends BaseQuery {
        private String name;

        private String logLevel;
    }

    @Getter
    @Setter
    public static class ShutDownQuery extends BaseQuery {
    }
}
