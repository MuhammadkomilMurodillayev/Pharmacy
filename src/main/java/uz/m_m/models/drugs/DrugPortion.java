package uz.m_m.models.drugs;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DrugPortion {
    private Drug drug;
    private Double price;
    private Integer count;
}
