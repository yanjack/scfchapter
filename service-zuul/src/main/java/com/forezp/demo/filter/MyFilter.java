package com.forezp.demo.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class MyFilter extends ZuulFilter {

    private static Logger log = LoggerFactory.getLogger(MyFilter.class);

    @Override
    public String filterType() {
        log.info("---------------1----------------");
        return "pre";
    }

    @Override
    public int filterOrder() {
        log.info("---------------2----------------");
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        log.info("---------------3----------------");
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext cxt = RequestContext.getCurrentContext();
        HttpServletRequest request = cxt.getRequest();
        log.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
        log.info("---------------4----------------");
        return null;
    }

}
