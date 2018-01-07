package com.didispace.filter;

import com.netflix.zuul.ZuulFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.stereotype.Component;

/**
 * logger filter
 *
 * @author yuanqing
 * @create 2018-01-02 上午9:01
 **/

@Component
public class LoggerFilter extends ZuulFilter{

    private final Logger logger = LoggerFactory.getLogger(LoggerFilter.class);

    @Autowired
    private Tracer tracer;

    @Override
    public String filterType() {
        return "post";
    }

    @Override
    public int filterOrder() {
        return 900;
    }

    public boolean shouldFilter() {
        return true;
    }

    public Object run() {

        tracer.addTag("operator","forezp");
//        System.out.print(tracer.getCurrentSpan().traceIdString());
        logger.info("tracer print------------"+String.valueOf(tracer.getCurrentSpan().getTraceId()));
        return null;
    }
}
