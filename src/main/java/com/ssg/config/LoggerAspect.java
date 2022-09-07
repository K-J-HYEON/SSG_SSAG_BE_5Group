package com.ssg.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class LoggerAspect {

    @Around("execution(* com.ssg.ssg_be.*..*Controller.*(..)) or execution(* com.ssg.ssg_be.*..*Impl.*(..)) or execution(* com.ssg.ssg_be.*..*Repository.*(..))")
    public Object logPrint(ProceedingJoinPoint joinPoint) throws Throwable {
        String type = "";
        String name = joinPoint.getSignature().getDeclaringTypeName();
        if (name.indexOf("Controller") > -1) {
            type = "Controller  \t:  ";
        }
        else if (name.indexOf("Service") > -1) {
            type = "ServiceImpl  \t:  ";
        }
        else if (name.indexOf("Repository") > -1) {
            type = "Repository  \t\t:  ";
        }
        log.warn(type + name + "." + joinPoint.getSignature().getName() + "()");
        return joinPoint.proceed();
    }
}
