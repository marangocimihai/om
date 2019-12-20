package spring.exception.handler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import spring.controller.EmployeeController;
import spring.exception.EmployeeNotFoundException;

@ControllerAdvice(assignableTypes = EmployeeController.class)
public class EmployeeNotFoundExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler({EmployeeNotFoundException.class})
    protected ResponseEntity<Object> employeeNotFound(Exception e, WebRequest request) {
        return handleExceptionInternal(e, "Employee not found", new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }
}
