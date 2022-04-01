package uz.m_m.models.organization;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import uz.m_m.enums.auth.Status;
import uz.m_m.models.Entity;

@Getter
@Setter
@EqualsAndHashCode(of = {"code"}, callSuper = false)
public class Organization extends Entity {
    private String name;
    private String code;
    private boolean owner;
    private Status status = Status.ACTIVE;

    public Organization() {
        super();
    }

    public Organization(String name, boolean owner) {
        this();
        this.name = name;
        this.owner = owner;
    }
}
