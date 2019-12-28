package spring.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EmployeeServiceCRUDAspect {
    @Before("execution(* spring.service.EmployeeService.findByWage(..))")
    public void logBeforeEmployeeService_findByWage(JoinPoint jp) {
        System.out.println("EmployeeServiceCRUDAspect.logBeforeEmployeeService_findByWage() : " + jp.getSignature().getName());
    }

    @After("execution(* spring.service.EmployeeService.findAll(..))")
    public void logAfterEmployeeService_findAll(JoinPoint jp) {
        System.out.println("EmployeeServiceCRUDAspect.logAfterEmployeeService_findAll() : " + jp.getSignature().getName());
    }

    @Around("execution(* spring.service.EmployeeService.save(..))")
    public void logAroundEmployeeService_save(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("EmployeeServiceCRUDAspect.logAroundEmployeeService_save() : " + jp.getSignature().getName() + " - begin");
        jp.proceed();
        System.out.println("EmployeeServiceCRUDAspect.logAroundEmployeeService_save() : " + jp.getSignature().getName() + " - end");
    }
}
