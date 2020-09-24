package com.neuedu.jstu.myoffice.log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyofficeLogger {


    /**
     * 切入点的定义：包   下所有类的所有方法，返回类型任意，形参数量任意*/
    @Pointcut("execution(* com.neuedu.jstu.myoffice.service.impl.*.insert(..))|| execution(* com.neuedu.jstu.myoffice.service.impl.*.update(..))||execution(* com.neuedu.jstu.myoffice.service.impl.*.deleteBatch(..))")
    private void p1(){

    }

    @Before("p1()")
    public void beforePrintLog(){
        System.out.println("前置通知Logger中的beforePrintLog方法开始记录日志了");
    }

    @AfterReturning("p1()")
    public void afterReturningPrintLog(){
        System.out.println("后置通知Logger中的afterReturningPrintLog方法开始记录日志了");
    }

    @AfterThrowing("p1()")
    public void afterThrowingPrintLog(){
        System.out.println("后置通知Logger中的afterThrowingPrintLog方法开始记录日志了");
    }

    @After("p1()")
    public void afterPrintLog(){
        System.out.println("后置通知Logger中的afterPrintLog方法开始记录日志了");
    }

    @Around("p1()")
    public Object aroundPrintLog(ProceedingJoinPoint pjp){
        Object rtValue = null;
        try{
            Object[] args = pjp.getArgs();//得到方法执行所需的参数
            System.out.println("\nLogger类中的aroundPrintLog方法开始记录日志了。。。前置");
            rtValue = pjp.proceed(args);//明确调用业务层方法
            System.out.println("Logger类中的aroundPrintLog方法开始记录日志了。。。后置");
            return rtValue;
        } catch (Throwable throwable) {
            System.out.println("Logger类中的aroundPrintLog方法开始记录日志了。。。异常");
            throw new RuntimeException(throwable);
        }finally {
            System.out.println("Logger类中的aroundPrintLog方法开始记录日志了。。。最终");
        }

    }

}
