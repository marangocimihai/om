package spring.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import spring.dto.EmployeeDto;
import spring.exception.EmployeeNotFoundException;
import spring.model.Employee;
import spring.repository.EmployeeRepository;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {
    private EmployeeRepository employeeRepository;
    private ModelMapper modelMapper;

    @Autowired
    protected void setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Autowired
    protected void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/add", consumes = "application/json", produces = "application/json")
    public void create(@RequestBody EmployeeDto employeeDto) throws ParseException {
        this.employeeRepository.save(convertToEntity(employeeDto));
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(path = "/update", consumes = "application/json", produces = "application/json")
    public Employee update(@RequestBody EmployeeDto employeeDto) throws EmployeeNotFoundException, ParseException {
        Employee employee = convertToEntity(employeeDto);
        this.employeeRepository.findById(employee.getId()).orElseThrow(EmployeeNotFoundException::new);
        return this.employeeRepository.save(employee);
    }

    @DeleteMapping(path = "/delete/id", consumes = "application/json", produces = "application/json")
    public void delete(@RequestBody EmployeeDto employeeDto) throws EmployeeNotFoundException, ParseException {
        Employee employee = convertToEntity(employeeDto);
        this.employeeRepository.findById(employee.getId()).orElseThrow(EmployeeNotFoundException::new);
        this.employeeRepository.deleteById(employee.getId());
    }

    @PostMapping(path = "/find/wage", consumes = "application/json", produces = "application/json")
    public Iterable<Employee> getByWage(@RequestBody Employee employee) {
        return this.employeeRepository.findByWage(employee.getWage());
    }

    @GetMapping(path = "/find/all", produces = "application/json")
    public Iterable<EmployeeDto> getAll() {
        Iterable<Employee> it = this.employeeRepository.findAll();
        List<Employee> employees = new ArrayList<>();
        it.forEach(employees::add);
        return employees.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    private EmployeeDto convertToDto(Employee employee) {
        return this.modelMapper.map(employee, EmployeeDto.class);
    }

    private Employee convertToEntity(EmployeeDto employeeDto) throws ParseException {
        return this.modelMapper.map(employeeDto, Employee.class);
    }
}