package com.rongsoft.dts.demo.aspect;

import com.rongsoft.dts.demo.annotation.DyDataSource;
import com.rongsoft.dts.demo.common.Constants;
import com.rongsoft.dts.demo.common.DynamicDataSourceContextHolder;
import com.rongsoft.dts.demo.common.RandomDataSourceRouter;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class DyDataSourceAspect {

    @Autowired
    public RandomDataSourceRouter randomDataSourceRouter;
    @Pointcut("@annotation(com.rongsoft.dts.demo.annotation.DyDataSource)")
    public void pointcut(){
    }

    @Around("pointcut()")
    public Object processData(ProceedingJoinPoint joinPoint) throws Throwable {
        Class clazz = joinPoint.getTarget().getClass();
        Object obj = null ;
        try{
            DyDataSource classDataSource = (DyDataSource) clazz.getAnnotation(DyDataSource.class);
            MethodSignature method = (MethodSignature) joinPoint.getSignature();
            DyDataSource methodDataSource =  method.getMethod().getAnnotation(DyDataSource.class);
            //最终以方法的注解为准
            DyDataSource finalDataSource =  null==methodDataSource?classDataSource:methodDataSource;

            if (null!= finalDataSource){
                String value = finalDataSource.value();
                //路由选择
                String realValue = randomDataSourceRouter.selectRouter(value);
                log.info("路由选择是key:{}",realValue);
                DynamicDataSourceContextHolder.setContextKey(realValue);
            }else {
                DynamicDataSourceContextHolder.setContextKey(Constants.DS_KEY_MASTER);
            }
            obj = joinPoint.proceed();
        }catch (Exception e){
            log.error("失败:",e);
        }finally {
            DynamicDataSourceContextHolder.removeContextKey();
        }
        return obj;
    }
}
