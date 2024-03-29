package com.thoughtmechanix.spmiazuulserver.filters;

import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Slf4j
@Component
public class TrackingFilter extends ZuulFilter {

	private static final int FILTER_ORDER = 1;
	private static final boolean SHOULD_FILTER = true;

	private final FilterUtils filterUtils;

	@Override
	public String filterType() {
		return FilterUtils.PRE_FILTER_TYPE;
	}

	@Override
	public int filterOrder() {
		return FILTER_ORDER;
	}

	public boolean shouldFilter() {
		return SHOULD_FILTER;
	}

	private boolean isCorrelationIdPresent() {
		return (filterUtils.getCorrelationId() != null);
	}

	private String generateCorrelationId() {
		return java.util.UUID.randomUUID().toString();
	}

	public Object run() {
		if(isCorrelationIdPresent()) {
			log.info("tmx-correlation-id found in tracking filter: {}. ", filterUtils.getCorrelationId());
		} else {
			filterUtils.setCorrelationId(generateCorrelationId());
			log.info("tmx-correlation-id generated in tracking filter: {}.", filterUtils.getCorrelationId());
		}

		RequestContext ctx = RequestContext.getCurrentContext();
		log.info("Processing incoming request for {}.", ctx.getRequest().getRequestURI());
		return null;
	}
}