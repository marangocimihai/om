package hibernate.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "F")
public class Factory extends Building {
    @Column(name = "manager")
    private String manager;

    public Factory() {
        super();
    }

    public Factory(String name, String owner, String manager) {
        super(name, owner);
        this.manager = manager;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }
}
