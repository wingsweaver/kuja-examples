package com.wingsweaver.examples.eurekaclient1;

import com.wingsweaver.kuja.common.utils.constants.BufferSizes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController {
    @Value("${service.instance-id}")
    private String instanceId;

    @Autowired
    private ServerProperties serverProperties;

    @Autowired
    private EurekaClient2Service eurekaClient2Service;

    @Autowired
    private Registration registration;

    @RequestMapping("/test")
    public Map<String, Object> test() {
        Map<String, Object> registrationMap = new HashMap<>(BufferSizes.SMALL);
        registrationMap.put("serviceId", this.registration.getServiceId());
        registrationMap.put("host", this.registration.getHost());
        registrationMap.put("port", this.registration.getPort());
        registrationMap.put("metadata", this.registration.getMetadata());

        Map<String, Object> map = new HashMap<>(BufferSizes.SMALL);
        map.put("instance-id", this.instanceId);
        map.put("port", this.serverProperties.getPort());
        map.put("registration", registrationMap);

        return map;
    }

    @RequestMapping("/test2")
    public Map<String, Object> test2() {
        return this.eurekaClient2Service.test();
    }
}
