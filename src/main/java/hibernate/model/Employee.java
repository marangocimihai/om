package hibernate.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;

@Entity
@Table(name = "employee")
@NamedQuery(query = "Select e from Employee e where e.id = :id", name = "find employee by id")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "wage", nullable = false)
    private double wage;

    @CreationTimestamp
    @Column(name = "creation_date", nullable = false)
    private java.sql.Timestamp cDate;

    @UpdateTimestamp
    @Column(name = "update_date", nullable = false)
    private java.sql.Timestamp uDate;

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    public Employee() {
    }

    public Employee(String name, String surname, double wage) {
        this.name = name;
        this.surname = surname;
        this.wage = wage;
    }

    public Employee(String name, String surname, double wage, Department department) {
        this.name = name;
        this.surname = surname;
        this.wage = wage;
        this.department = department;
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

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
