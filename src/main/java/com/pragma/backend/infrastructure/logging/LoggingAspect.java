package com.pragma.backend.infrastructure.logging;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Aspecto transversal que registra entrada, salida, duración y errores
 * de cada endpoint REST, sin acoplar ese logging a la lógica de negocio.
 */
@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Pointcut("execution(* com.pragma.backend.infrastructure.entrypoint.rest..*Controller.*(..))")
    public void restEndpoints() {
    }

    @Around("restEndpoints()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        String signature = joinPoint.getSignature().toShortString();
        long start = System.currentTimeMillis();

        logger.info("-> {} args={}", signature, joinPoint.getArgs());
        try {
            Object result = joinPoint.proceed();
            long durationMs = System.currentTimeMillis() - start;
            logger.info("<- {} completado en {} ms", signature, durationMs);
            return result;
        } catch (Exception ex) {
            long durationMs = System.currentTimeMillis() - start;
            logger.error("<- {} falló en {} ms: {}", signature, durationMs, ex.getMessage());
            throw ex;
        }
    }
}
