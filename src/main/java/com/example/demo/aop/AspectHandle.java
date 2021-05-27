package com.example.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Aspect
@Component
public class AspectHandle {

    @Before(value = "execution(* com.example.demo.service.AopService.*(..))")
    public void logBeforeRunFunc(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getName() + " >> @Before >> Params >> " + joinPoint.getArgs()[0]);
    }

    @After(value = "execution(* com.example.demo.service.AopService.*(..))")
    public void logAfterRunFunc(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getName() + " >> @After >> Params >> " + joinPoint.getArgs()[0]);
    }

   /* @Around(value = "execution(* com.example.demo.service.AopService.*(..))")
    public void logAroundRunFunc(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getName() + " >> Around With Params >> " + joinPoint.getArgs()[0]);
    }*/

    @AfterThrowing(pointcut = "execution(* com.example.demo.service.AopService.*(..))", throwing = "error")
    public void logAfterThrowEx(JoinPoint joinPoint, Exception error) {
        System.out.println(joinPoint.getSignature().getName() + " >> Throws with ex >> " + error.getMessage());
        throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Forbidden", error);
    }

    @AfterReturning(value = "execution(* com.example.demo.service.AopService.*(..))", returning = "result")
    public void logAfterReturnValue(JoinPoint joinPoint, Object result) {
        System.out.println(joinPoint.getSignature().getName() + " >> @AfterReturn >> " + result );
    }
}
