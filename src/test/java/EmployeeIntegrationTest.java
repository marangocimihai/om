import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import spring.Application;
import spring.model.Employee;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
public class EmployeeIntegrationTest {
    @Autowired
    private TestRestTemplate rt;
    @LocalServerPort
    private int port;

    @Test
    public void addEmployee() {
        Employee employee = new Employee();
        employee.setName("NameTest");
        employee.setSurname("SurnameTest");
        employee.setWage(67.0);
        ResponseEntity re = this.rt.postForEntity("http://localhost:" + port + "/employee/add", employee, Employee.class);
        assert HttpStatus.CREATED == re.getStatusCode();
    }
}
