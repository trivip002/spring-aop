package com.example.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectHandle {

    @Before(value = "execution(* com.example.demo.service.UserService.*(..))")
    public void logBeforeRunFunc(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getName() + " >> Before With Params >> " + joinPoint.getArgs()[0]);
    }

    @After(value = "execution(* com.example.demo.service.UserService.*(..))")
    public void logAfterRunFunc(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getName() + " >> After With Params >> " + joinPoint.getArgs()[0]);
    }

   /* @Around(value = "execution(* com.example.demo.service.UserService.*(..))")
    public void logAroundRunFunc(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getName() + " >> Around With Params >> " + joinPoint.getArgs()[0]);
    }*/

    @AfterThrowing(pointcut = "execution(* com.example.demo.service.UserService.*(..))", throwing = "error")
    public void logAfterThrowEx(JoinPoint joinPoint, Exception error) {
        System.out.println(joinPoint.getSignature().getName() + " >> Throws with ex >> " + error.getMessage());
    }

    @AfterReturning(value = "execution(* com.example.demo.service.UserService.*(..))", returning = "result")
    public void logAfterReturnValue(JoinPoint joinPoint, Object result) {
        System.out.println(joinPoint.getSignature().getName() + " >> After Return >> " + result );
    }
}
