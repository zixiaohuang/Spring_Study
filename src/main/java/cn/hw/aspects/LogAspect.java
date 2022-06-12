package cn.hw.aspects;

import jdk.nashorn.internal.runtime.logging.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Array;
import java.util.Arrays;
// 正常使用方式

// 正常执行顺序：前置--> 方法--> 后置 --> 返回
// 异常执行顺序：前置--> 方法--> 后置 --> 异常

// 支持快速插拔，只要把Aspect和Component注释掉，就不会有日志输出
@Aspect // 标记为切面
@Component // 标记Bean组建，才能切入到ioc当中的bean
public class LogAspect {

    // execution可以匹配到方法级别（细粒度） within 只能匹配到类级别（粗粒度）
    // 切点标志服 访问修饰符 返回值（*代表所有类型返回值） 包名（*代表任何包名 ..代表子孙包） *代表所有类类名 *代表任何方法 参数（..代表任何参数）
    // annotation 通过标记来匹配 要注意 RetentionPolicy是SOURCE 还是RUNTIME SOURCE的话在java编译成class时标记会消失匹配不上，运行时是运行java文件
    // this 匹配实现了某个接口
    // args 按参数去匹配
    // 通过 && ｜｜ ！ 来合并切点表达式

    // 可以采用声明切点的方式 让其他通知引用，重用性更强
    @Pointcut("execution(* cn.hw.service.impl.*.*(..))")
    public void pointcut(){

    }


    // 前置通知
    // 匹配包下面的任意方法 并且 方法带了Logger注解
    // 并且 匹配方法上标记@jdk.nashorn.internal.runtime.logging.Logger 的注解， @annotation（logger） 对应参数上面的注解
    // 通知上面的参数不是随便能写的 JoinPoint 所有的通知都可以写，其他参数视情况而定
    @Before("pointcut() && @annotation(logger)")
    public void before(JoinPoint joinPoint, Logger logger) {
        // 获取方法名
        String methodName = joinPoint.getSignature().getName();
        // 获取所有参数
        Object[] args = joinPoint.getArgs();
        System.out.println("前置通知: "+logger.name()+"方法运行，参数是: "+ Arrays.asList(args));
    }

    // 后置通知
    @After("pointcut()")
    public void after() {
        System.out.println("后置通知");
    }

    // 后置异常通知
    @AfterThrowing(value = "pointcut()", throwing = "ex")
    public void afterThrowing(Exception ex) {
        // 打印异常栈
        StringWriter sw = new StringWriter();
        ex.printStackTrace(new PrintWriter(sw, true));

        System.out.println("后置异常通知, 发生异常: "+ ex + "\n" + sw.getBuffer().toString());
    }

    // 后置返回通知
    @AfterReturning(value = "pointcut()", returning = "returnValue")
    public void afterReturning(Object returnValue) { // 返回值不确定，所以只能是Object

        System.out.println("后置返回通知, 返回值: "+returnValue);
    }

    // 环绕通知
    @Around("pointcut()")
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
