package uz.m_m.models;

import lombok.Getter;
import lombok.Setter;
import uz.m_m.enums.auth.Status;

@Getter
@Setter
public abstract class BaseModel {
    private String id;
    private Status status = Status.ACTIVE;

    public BaseModel() {
        this.id = BaseUtil.generateUniqueID();
    }
}
