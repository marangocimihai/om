import springboot.model.Employee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import springboot.Application;
import springboot.dao.EmployeeRepository;

import javax.persistence.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmployeeIntegrationTest {
    @Autowired
    private EntityManagerFactory ENTITY_MANAGER_FACTORY;
    @Autowired
    @PersistenceContext
    private EntityManager manager;
    private EntityTransaction transaction;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private TestRestTemplate rt;
    @LocalServerPort
    private int port;

    @Before
    public void initializeEntityManager() {
        ENTITY_MANAGER_FACTORY = Persistence
                .createEntityManagerFactory("om");
        manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        transaction = manager.getTransaction();
        transaction.begin();
    }

    @After
    public void closeEntityManager() {
        ENTITY_MANAGER_FACTORY.close();
    }

    @Test
    public void addEmployee() {
        Employee employee = new Employee();
        employee.setName("NameTest");
        employee.setSurname("SurnameTest");
        employee.setWage(67.0);
        ResponseEntity re = this.rt.postForEntity("http://localhost:" + port + "/demo/add", employee, Employee.class);
        assert 200 == re.getStatusCodeValue();
    }
}
