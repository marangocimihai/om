package hibernate.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "technology")
    private String technology;

    @Version
    @Column(name = "version")
    private int version;

    @ManyToMany(targetEntity = Employee.class, cascade = {CascadeType.ALL})
    @JoinTable(name = "employee_projects", joinColumns = {@JoinColumn(name = "project_id")}, inverseJoinColumns = {@JoinColumn(name = "employee_id")})
    private Set<Employee> employees;

    public Project() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
