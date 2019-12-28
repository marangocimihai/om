package spring.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EmployeeCRUDAspect {
    @Before("execution(* spring.repository.EmployeeRepository.findByWage(..))")
    public void logBeforeEmployeeRepository_findByWage(JoinPoint jp) {
        System.out.println("EmployeeCRUDAspect.logBeforeEmployeeRepository_findByWage() : " + jp.getSignature().getName());
    }

    @After("execution(* spring.repository.EmployeeRepository.findAll(..))")
    public void logAfterEmployeeRepository_findAll(JoinPoint jp) {
        System.out.println("EmployeeCRUDAspect.logAfterEmployeeRepository_findAll() : " + jp.getSignature().getName());
    }

    @Around("execution(* spring.repository.EmployeeRepository.save(..))")
    public void logAroundEmployeeRepository_save(JoinPoint jp) {
        System.out.println("EmployeeCRUDAspect.logAroundEmployeeRepository_save() : " + jp.getSignature().getName());
    }
}
