package com.pragma.backend.infrastructure.logging;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class LoggingAspect {
    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Pointcut("execution(* com.pragma.backend.application.handler.RequestHandler.*(..))")
    public void logPointcut() {}

    @Before("logPointcut()")
    public void logBefore() {
        logger.info("Request received");
    }
}