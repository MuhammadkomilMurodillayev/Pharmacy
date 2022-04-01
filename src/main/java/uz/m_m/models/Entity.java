package uz.m_m.models;

import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public  class Entity {
    private String id;

    public Entity() {
        this.id = BaseUtil.generateUniqueID();

    }
}

