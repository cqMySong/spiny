package com.gioov.spiny.common.annotation.operationlog;

import com.gioov.spiny.system.entity.OperationLogEntity;
import com.gioov.spiny.system.mapper.OperationLogMapper;
import com.gioov.spiny.user.entity.UserEntity;
import com.gioov.spiny.user.service.UserService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Date;

/**
 * @author godcheese
 * @date 2018-02-22
 */
@Component
@Aspect
public class OperationLogAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(OperationLogAspect.class);

    @Autowired
    private UserService userService;

    @Autowired
    private OperationLogMapper operationLogMapper;

    @Pointcut("@annotation(logOperation)")
    public void logAnnotationPointcut(OperationLog logOperation) {}

    @Before(value = "logAnnotationPointcut(logOperation)", argNames = "joinPoint,logOperation")
    public void before(JoinPoint joinPoint, OperationLog logOperation) {

        Long userId = null;

        UserEntity userEntity = userService.getCurrentUser();
        if (userEntity != null) {
            userId = userEntity.getId();
        }

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        Method method = methodSignature.getMethod();

        OperationLog annotation = method.getAnnotation(OperationLog.class);

        OperationLogEntity operationLogEntity = new OperationLogEntity();
        operationLogEntity.setUserId(userId);
        operationLogEntity.setType(annotation.type().value());
        operationLogEntity.setMethodName(method.getName());
        operationLogEntity.setOperation(annotation.value());
        operationLogEntity.setGmtCreated(new Date());
        operationLogMapper.insertOne(operationLogEntity);

    }

}
