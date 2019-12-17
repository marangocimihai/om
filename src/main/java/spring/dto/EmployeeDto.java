package spring.dto;

import java.sql.Timestamp;

public class EmployeeDto {
    private Integer id;
    private String name;
    private String surname;
    private Double wage;
    private java.sql.Timestamp cDate;
    private java.sql.Timestamp uDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Double getWage() {
        return wage;
    }

    public void setWage(Double wage) {
        this.wage = wage;
    }

    public Timestamp getcDate() {
        return cDate;
    }

    public void setcDate(Timestamp cDate) {
        this.cDate = cDate;
    }

    public Timestamp getuDate() {
        return uDate;
    }

    public void setuDate(Timestamp uDate) {
        this.uDate = uDate;
    }
}
