package spring.repository;

import org.springframework.data.repository.CrudRepository;
import spring.model.Employee;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
    public List<Employee> findByWage(Double wage);
}