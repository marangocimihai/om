package spring.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import spring.config.OwnerConfigProperties;
import spring.dto.EmployeeDto;
import spring.exception.EmployeeNotFoundException;
import spring.model.Employee;
import spring.service.EmployeeService;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {
    private EmployeeService employeeService;
    private ModelMapper modelMapper;
    private OwnerConfigProperties ocp;

    @Autowired
    public void setOcp(OwnerConfigProperties ocp) {
        this.ocp = ocp;
    }

    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/add", consumes = "application/json", produces = "application/json")
    public Employee create(@RequestBody EmployeeDto employeeDto) throws ParseException {
        return this.employeeService.save(convertToEntity(employeeDto));
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(path = "/update", consumes = "application/json", produces = "application/json")
    public Employee update(@RequestBody EmployeeDto employeeDto) throws EmployeeNotFoundException, ParseException {
        Employee employee = convertToEntity(employeeDto);
        this.employeeService.findById(employee.getId()).orElseThrow(EmployeeNotFoundException::new);
        return this.employeeService.save(employee);
    }

    @DeleteMapping(path = "/delete/id", consumes = "application/json", produces = "application/json")
    public void delete(@RequestBody EmployeeDto employeeDto) throws EmployeeNotFoundException, ParseException {
        Employee employee = convertToEntity(employeeDto);
        this.employeeService.findById(employee.getId()).orElseThrow(EmployeeNotFoundException::new);
        this.employeeService.deleteById(employee.getId());
    }

    @PostMapping(path = "/find/wage", consumes = "application/json", produces = "application/json")
    public Iterable<Employee> getByWage(@RequestBody EmployeeDto employeeDto) throws ParseException {
        return this.employeeService.findByWage(convertToEntity(employeeDto).getWage());
    }

    @GetMapping(path = "/find/all", produces = "application/json")
    public Iterable<EmployeeDto> getAll() {
        Iterable<Employee> it = this.employeeService.findAll();
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