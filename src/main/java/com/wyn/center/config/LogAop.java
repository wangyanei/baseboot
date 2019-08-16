package com.wyn.center.config;

import com.wyn.center.Entity.LogEntity;
import com.wyn.center.dao.LogDao;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by wxk on 2019/6/3.
 */
@Aspect
@Component
public class LogAop {

    @Autowired
    private LogDao logDao;

    @Pointcut("execution(* com.wyn.api.service.*.*(..))")
    public void log(){}

    @Around("log()")
    public Object doLog(ProceedingJoinPoint joinPoint) throws Throwable{
        HttpServletRequest request= GetRequestAndReponse.getRequest();
        HttpSession session=GetRequestAndReponse.getSession();
        String url=request.getRequestURI();
        LogEntity logEntity=new LogEntity();
        logEntity.setUrl(url);
        Object obj=session.getAttribute("user");

        if(obj!=null){
            logEntity.setLoginName("wk");
        }

        String methodName=joinPoint.getSignature().getName();
        logEntity.setUseMethod(methodName);

        Object[] args=joinPoint.getArgs();

        Object output=joinPoint.proceed();

        logDao.insert(logEntity);

        return output;

    }

}
