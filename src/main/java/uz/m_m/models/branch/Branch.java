package uz.m_m.models.branch;

import lombok.Getter;
import lombok.Setter;
import uz.m_m.enums.auth.Status;
import uz.m_m.models.Entity;

@Getter
@Setter
public class Branch extends Entity {

    private String name;
    private Status status = Status.ACTIVE;
    private String location;
    private Integer latitude;
    private Integer longitude;
    private String organizationId;

}
