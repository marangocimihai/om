package hibernate.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;

@Entity
@Table(name = "employee")
@NamedQuery(query = "Select e from Employee e where e.id = :id", name = "Employee.findById")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
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

//    @ManyToOne
//    @JoinColumn(name = "department_id", nullable = false)
//    private Department department;

    public Employee() {
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

//    public Department getDepartment() {
//        return department;
//    }
//
//    public void setDepartment(Department department) {
//        this.department = department;
//    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", wage=" + wage +
                ", cDate=" + cDate +
                ", uDate=" + uDate +
//                ", department=" + department +
                '}';
    }
}
