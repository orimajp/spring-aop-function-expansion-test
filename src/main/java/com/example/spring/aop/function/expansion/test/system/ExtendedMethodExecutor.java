package com.example.spring.aop.function.expansion.test.system;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;

@Slf4j
@Aspect
@Component
public class ExtendedMethodExecutor {

  @Pointcut("target(com.example.spring.aop.function.expansion.test.system.Delegatable)")
  void extensibleComponent() {}

  @Pointcut("@annotation(com.example.spring.aop.function.expansion.test.system.ExtendedMethod)")
  void extendedMethod() {}

  @Around("extensibleComponent() && !extendedMethod()")
  public Object delegateExecute(ProceedingJoinPoint joinPoint) throws Throwable {
    var sig = (MethodSignature) joinPoint.getSignature();
    var methodName = sig.getName();

    if (methodName.equals("getComponentKey")) {
      return joinPoint.proceed();
    }

    var argsType = sig.getParameterTypes();
    var target = joinPoint.getTarget();
    var delegateInstance = getDelegateInstance(target);
    var delegatedMethod = delegateInstance.getClass().getMethod(methodName, argsType);

    var args = joinPoint.getArgs();
    return delegatedMethod.invoke(delegateInstance, args);
  }

  @Around("extensibleComponent() && extendedMethod()")
  public Object originalExecute(ProceedingJoinPoint joinPoint) throws Throwable {
    return joinPoint.proceed();
  }

  private Object getDelegateInstance(Object target)
      throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
    var getDelegateInstanceMethod = target.getClass().getMethod("getDelegateInstance");
    return getDelegateInstanceMethod.invoke(target);
  }

}
