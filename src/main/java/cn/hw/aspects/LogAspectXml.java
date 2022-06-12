package cn.hw.aspects;

import jdk.nashorn.internal.runtime.logging.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;
// xml方式使用aop

@Component
public class LogAspectXml {
    // 前置通知
    public void before(JoinPoint joinPoint, Logger logger) {
        // 获取方法名
        String methodName = joinPoint.getSignature().getName();
        // 获取所有参数
        Object[] args = joinPoint.getArgs();
        System.out.println("前置通知: "+logger.name()+"方法运行，参数是: "+ Arrays.asList(args));
    }

    // 后置通知
    public void after() {
        System.out.println("后置通知");
    }

    // 后置异常通知
    public void afterThrowing(Exception ex) {
        // 打印异常栈
        StringWriter sw = new StringWriter();
        ex.printStackTrace(new PrintWriter(sw, true));

        System.out.println("后置异常通知, 发生异常: "+ ex + "\n" + sw.getBuffer().toString());
    }

    // 后置返回通知
    public void afterReturning(Object returnValue) { // 返回值不确定，所以只能是Object

        System.out.println("后置返回通知, 返回值: "+returnValue);
    }

    // 环绕通知
    public Object arround(ProceedingJoinPoint joinPoint) {
        // 获取方法名
        String methodName = joinPoint.getSignature().getName();
        // 获取所有参数
        Object[] args = joinPoint.getArgs();

        Object returnValue = "";
        try{
            System.out.println("环绕前置通知："+methodName+"方法执行，参数: " +Arrays.asList(args));
            returnValue=joinPoint.proceed();
            System.out.println("环绕后置通知："+ methodName+"方法执行，参数："+Arrays.asList(args));
        }catch (Throwable throwable) {
            System.out.println("环绕异常通知："+throwable);
            throwable.printStackTrace();
        }finally {
            System.out.println("环绕返回通知："+returnValue);
        }
        return returnValue;
    }
}
