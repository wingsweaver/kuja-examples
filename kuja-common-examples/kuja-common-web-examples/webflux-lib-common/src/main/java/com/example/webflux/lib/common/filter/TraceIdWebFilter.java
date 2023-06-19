package com.example.webflux.lib.common.filter;

import com.wingsweaver.kuja.common.boot.context.BusinessContext;
import com.wingsweaver.kuja.common.utils.logging.slf4j.LogUtil;
import com.wingsweaver.kuja.common.utils.support.lang.StringUtil;
import com.wingsweaver.kuja.common.webflux.util.ServerWebExchangeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

import java.util.UUID;

public class TraceIdWebFilter implements WebFilter {
    private static final Logger LOGGER = LoggerFactory.getLogger(TraceIdWebFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        this.updateTrace(exchange);
        return chain.filter(exchange);
    }

    private void updateTrace(ServerWebExchange exchange) {
        String traceId = this.resolveTraceId(exchange);
        BusinessContext businessContext = ServerWebExchangeUtil.getBusinessContext(exchange);
        if (businessContext != null) {
            LogUtil.trace(LOGGER, "set trace id: {}", traceId);
            businessContext.setAttributeIfAbsent("traceId", traceId);
        }
    }

    private String resolveTraceId(ServerWebExchange exchange) {
        // 从参数中获取
        ServerHttpRequest request = exchange.getRequest();
        String traceId = request.getHeaders().getFirst("X-TRACE-ID");
        if (StringUtil.isEmpty(traceId)) {
            traceId = request.getQueryParams().getFirst("traceId");
        }

        // 返回
        return StringUtil.isEmpty(traceId) ? "webflux-" + UUID.randomUUID() : traceId;
    }
}
