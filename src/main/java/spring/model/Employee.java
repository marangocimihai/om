package spring.model;

//import org.hibernate.annotations.CreationTimestamp;
//import org.hibernate.annotations.UpdateTimestamp;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;

@Entity
@Table(name = "employee")
@NamedQueries(value = {
        @NamedQuery(name = "Employee.findById", query = "Select e from Employee e where e.id = :id"),
        @NamedQuery(name = "Employee.findByWageLessThan", query = "Select e from Employee e where e.wage < :wage"),
})
@NamedStoredProcedureQuery(name = "Employee.getEmployeeByName", procedureName = "getEmployeeByName", resultClasses = Employee.class, parameters = {
        @StoredProcedureParameter(name = "name", type = String.class, mode = ParameterMode.IN)
})
public class Employee extends Person {
    @Column(name = "wage")
    private Double wage;

    @CreationTimestamp
    @Column(name = "creation_date", updatable = false)
    private java.sql.Timestamp cDate;

    @UpdateTimestamp
    @Column(name = "update_date")
    private java.sql.Timestamp uDate;

//    @ManyToOne
//    @JoinColumn(name = "department_id", nullable = false)
//    private Department department;

    public Employee() {
    }

    public Employee(Double wage) {
        this.wage = wage;
    }

    @PrePersist
    public void checkWage() {
        this.wage = this.wage < 25 ? 30.0 : this.wage;
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
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
                "wage=" + wage +
                ", cDate=" + cDate +
                ", uDate=" + uDate +
                "} " + super.toString();
    }
}
