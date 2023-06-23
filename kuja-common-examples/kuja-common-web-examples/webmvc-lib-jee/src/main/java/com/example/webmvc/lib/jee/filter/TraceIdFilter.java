package com.example.webmvc.lib.jee.filter;

import com.wingsweaver.kuja.common.boot.context.BusinessContext;
import com.wingsweaver.kuja.common.boot.context.BusinessContextHolder;
import com.wingsweaver.kuja.common.utils.logging.slf4j.LogUtil;
import com.wingsweaver.kuja.common.utils.support.DefaultOrdered;
import com.wingsweaver.kuja.common.utils.support.lang.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@Component
public class TraceIdFilter extends OncePerRequestFilter implements DefaultOrdered {
    private static final Logger LOGGER = LoggerFactory.getLogger(TraceIdFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        BusinessContext businessContext = BusinessContextHolder.getCurrent();
        if (businessContext == null) {
            LogUtil.error(LOGGER, "businessContext should NOT be null");
        }

        // 设置相关字段
        String traceId = this.resolveTraceId(request);
        businessContext.setAttributeIfAbsent("traceId", traceId);
        LogUtil.info(LOGGER, "traceId: {}", traceId);

        // 调用后续处理
        filterChain.doFilter(request, response);
    }

    private String resolveTraceId(HttpServletRequest request) {
        String traceId = request.getHeader("X-TRACE-ID");
        if (StringUtil.isEmpty(traceId)) {
            traceId = request.getParameter("traceId");
        }
        return StringUtil.isEmpty(traceId) ? "webmvc-jee-" + UUID.randomUUID() : traceId;
    }
}
