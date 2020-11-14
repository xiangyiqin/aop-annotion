package com.elephant.demo.aop;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author xyq
 * @描述：
 * @创建时间：2020/11/14 14:20
 */
@Aspect
@Component
public class BrokerAspect {
    /**
     * 定义切入点，切入点为com.example.demo.aop.AopController中的所有函数
     *通过@Pointcut注解声明频繁使用的切点表达式
     */
    @Pointcut("execution(public * com.elephant.demo.aop.AopController.*(..)))")
    public void BrokerAspect(){

    }

    /**
     * @description  在连接点执行之前执行的通知
     */
    @Before("BrokerAspect()")
    public void doBeforeGame(JoinPoint joinPoint){
        Signature signature = joinPoint.getSignature();
        System.out.println(signature.getName());
        System.out.println(signature.getDeclaringTypeName());
        System.out.println(signature.toString());
        System.out.println("经纪人正在处理球星赛前事务！");
    }

    /**
     * @description  在连接点执行之后执行的通知（返回通知和异常通知的异常）
     */
    @After("BrokerAspect()")
    public void doAfterGame(JoinPoint joinPoint){
        Method[] methods = joinPoint.getTarget().getClass().getMethods();
        for(Method method:methods){
            if(method.isAnnotationPresent(Info.class) && method.getName().equals(joinPoint.getSignature().getName())){
                System.out.println("method.getName()"+method.getName());
                Info annotation = method.getAnnotation(Info.class);
                String doWhat = annotation.doWhat();
                String operationType = annotation.operationType();
                System.out.println(doWhat+operationType);
            }
        }
        System.out.println("经纪人为球星表现疯狂鼓掌！");
    }

    /**
     * @description  在连接点执行之后执行的通知（返回通知）
     */
    @AfterReturning("BrokerAspect()")
    public void doAfterReturningGame(){
        System.out.println("返回通知：经纪人为球星表现疯狂鼓掌！");
    }

    /**
     * @description  在连接点执行之后执行的通知（异常通知）
     */
    @AfterThrowing("BrokerAspect()")
    public void doAfterThrowingGame(){
        System.out.println("异常通知：球迷要求退票！");
    }
}
