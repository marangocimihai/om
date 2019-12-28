package spring.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDto {
    private Integer id;
    private String name;
    private String surname;
    private Double wage;
    private java.sql.Timestamp cDate;
    private java.sql.Timestamp uDate;
}
