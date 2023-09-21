package com.poscodx.aoptest.aspect;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect
{
    @Before("execution(public com.poscodx.aoptest.vo.ProductVo" +
            " com.poscodx.aoptest.service.ProductService.find(String))")
    public void adviceBefore() {
        System.out.println("----- Before Advice -----");
        // point cut 기술
    }
                        //리턴타입 접근지시자 생략가능
    @After("execution(com.poscodx.aoptest.vo.ProductVo" +
            " com.poscodx.aoptest.service.ProductService.find(String))")
    public void adviceAfter() {
        System.out.println("----- After Advice -----");
    }

                        //리턴타입 접근지시자 생략가능
    @AfterReturning("execution(* )")
    public void adviceAfterReturning() {
        System.out.println("----- AfterReturning Advice -----");
    }

    @AfterThrowing(value = "execution(* *..*.ProductService.*(..))", throwing = "ex")

    public void adviceAfterThrowing(Throwable ex) {
        System.out.println("----- AfterThrowing Advice : "+ ex+ "-----");
    }

    @Around(value = "execution(* *..*.ProductService.*(..))", throwing = "ex")

    public void adviceAfterThrowing(Throwable ex) {
        System.out.println("----- AfterThrowing Advice : "+ ex+ "-----");
    }
}
