package spring.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EmployeeServiceCRUDAspect {
    private static final Logger LOG = LoggerFactory.getLogger(EmployeeServiceCRUDAspect.class);

    @Before("execution(* spring.service.EmployeeService.findByWage(..))")
    public void logBeforeEmployeeService_findByWage(JoinPoint jp) {
        LOG.info("EmployeeServiceCRUDAspect.logBeforeEmployeeService_findByWage() : {}", jp.getSignature().getName());
    }

    @After("execution(* spring.service.EmployeeService.findAll(..))")
    public void logAfterEmployeeService_findAll(JoinPoint jp) {
        LOG.info("EmployeeServiceCRUDAspect.logAfterEmployeeService_findAll() : {}", jp.getSignature().getName());
    }

    @Around("execution(* spring.service.EmployeeService.save(..))")
    public void logAroundEmployeeService_save(ProceedingJoinPoint jp) throws Throwable {
        LOG.info("EmployeeServiceCRUDAspect.logAroundEmployeeService_save() : {} - begin", jp.getSignature().getName());
        jp.proceed();
        LOG.info("EmployeeServiceCRUDAspect.logAroundEmployeeService_save() : {} - end", jp.getSignature().getName());
    }
}
