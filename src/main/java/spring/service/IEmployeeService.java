package spring.service;

import spring.exception.EmployeeNotFoundException;
import spring.model.Employee;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService {
    Iterable<Employee> findAll();

    Optional<Employee> findById(int id);

    Employee save(Employee employee);

    Employee update(Employee employee) throws EmployeeNotFoundException;

    void deleteById(int id) throws EmployeeNotFoundException;

    List<Employee> findByWage(Double wage);

    Long count();
}
