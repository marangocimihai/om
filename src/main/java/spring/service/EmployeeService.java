package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.exception.EmployeeNotFoundException;
import spring.model.Employee;
import spring.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Iterable<Employee> findAll() {
        return this.employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> findById(int id) {
        return this.employeeRepository.findById(id);
    }

    @Override
    public Employee save(Employee employee) {
        return this.employeeRepository.save(employee);
    }

    @Override
    public Employee update(Employee employee) throws EmployeeNotFoundException {
        this.employeeRepository.findById(employee.getId()).orElseThrow(EmployeeNotFoundException::new);
        return this.employeeRepository.save(employee);
    }

    @Override
    public void deleteById(int id) throws EmployeeNotFoundException {
        this.employeeRepository.findById(id).orElseThrow(EmployeeNotFoundException::new);
        this.employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> findByWage(Double wage) {
        return this.employeeRepository.findByWage(wage);
    }

    @Override
    public Long count() {
        return employeeRepository.count();
    }
}
