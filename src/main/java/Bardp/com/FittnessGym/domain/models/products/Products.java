package Bardp.com.FittnessGym.domain.models.products;

import Bardp.com.FittnessGym.domain.category.Available;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table( schema =  "\"products\"",name = "product")

public class Products {

    private String name;
    private String description;

    private String marca;

    private Integer stock;

    private Double price;

    private String brand;
    private Double weight;

    private Available available;

}
