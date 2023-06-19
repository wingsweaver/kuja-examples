package com.example.webmvc.lib.common.customizer;

import com.wingsweaver.kuja.common.boot.context.BusinessContext;
import com.wingsweaver.kuja.common.boot.returnvalue.AbstractOneTimeReturnValueCustomizer;
import com.wingsweaver.kuja.common.boot.returnvalue.ReturnValue;
import org.springframework.stereotype.Component;

@Component
public class TraceReturnValueCustomizer extends AbstractOneTimeReturnValueCustomizer {
    @Override
    protected void customizeInternal(BusinessContext businessContext, ReturnValue returnValue) {
        if (businessContext == null) {
            return;
        }

        String traceId = businessContext.getAttribute("traceId");
        if (traceId != null) {
            returnValue.setTagValue("traceId", traceId);
        }
    }
}
