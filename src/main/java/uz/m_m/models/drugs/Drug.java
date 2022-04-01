package uz.m_m.models.drugs;

import uz.m_m.enums.helpers.Ingredient;
import uz.m_m.enums.helpers.Type;
import lombok.Getter;
import lombok.Setter;
import uz.m_m.models.Entity;

@Getter
@Setter
public class Drug extends Entity {
    private String name;
    private String organizationId;
    private String branchId;
    private String description;
    private Ingredient ingredient;
    private String barCode;
    private Type type;
}
