package hibernate.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "S")
public class School extends Building {
    @Column(name = "principal")
    private String principal;

    public School() {
        super();
    }

    public School(String name, String owner, String principal) {
        super(name, owner);
        this.principal = principal;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }
}
