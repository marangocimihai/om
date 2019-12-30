package spring.actuator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;
import spring.service.EmployeeService;

import java.util.HashMap;
import java.util.Map;

@Component
public class EmployeeInfoContributor implements InfoContributor {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeInfoContributor(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public void contribute(Info.Builder builder) {
        Map<String, Integer> employeeInfo = new HashMap<>();
        employeeInfo.put("count", employeeService.count().intValue());
        builder.withDetail("employee", employeeInfo);
    }
}
