package Bardp.com.FittnessGym.domain.models.dto;

import Bardp.com.FittnessGym.domain.category.Available;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DtoProduct {

    private Long id;
    private String name;
    private String description;

    private String marca;

    private Integer stock;

    private Double price;

    private String brand;
    private Double weight;

    private Available available;
}
