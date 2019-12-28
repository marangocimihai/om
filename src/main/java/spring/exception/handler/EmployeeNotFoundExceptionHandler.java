package spring.exception.handler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import spring.controller.EmployeeController;
import spring.exception.EmployeeNotFoundException;

import java.io.IOException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice(assignableTypes = EmployeeController.class)
public class EmployeeNotFoundExceptionHandler {
    @ExceptionHandler({EmployeeNotFoundException.class})
    public ResponseEntity<Map<String, Object>> employeeNotFound(Exception ex,  WebRequest request) throws IOException {
        Map<String, Object> response = new LinkedHashMap();
        response.put("timestamp", new Date());
        response.put("error", "Employee not found");
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
