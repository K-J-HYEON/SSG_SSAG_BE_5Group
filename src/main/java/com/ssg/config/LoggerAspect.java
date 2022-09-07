package com.ssg.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class LoggerAspect {

    @Pointcut("execution(* com.ssg.ssg_be.login.presentation.*Controller.*(..)) " +
            "|| execution(* com.ssg.ssg_be.signup.presentation.*Controller.*(..)) " +
            "|| execution(* com.ssg.ssg_be.cart.presentation.*Controller.*(..)) " +
            "|| execution(* com.ssg.ssg_be.product.presentation.*Controller.*(..)) " +
            "|| execution(* com.ssg.ssg_be.order.presentation.*Controller.*(..)) " +
            "|| execution(* com.ssg.ssg_be.login.application.*Impl.*(..)) " +
            "|| execution(* com.ssg.ssg_be.signup.application.*Impl.*(..)) " +
            "|| execution(* com.ssg.ssg_be.cart.application.*Impl.*(..)) " +
            "|| execution(* com.ssg.ssg_be.product.application.*Impl.*(..)) " +
            "|| execution(* com.ssg.ssg_be.order.application.*Impl.*(..)) " +
            "|| execution(* com.ssg.ssg_be.*.infrastructure.*Repository.*(..))")
    private void publicTarget() { }

    @Around("publicTarget()")
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
        log.info(type + name + "." + joinPoint.getSignature().getName() + "()");
        return joinPoint.proceed();
    }
}
