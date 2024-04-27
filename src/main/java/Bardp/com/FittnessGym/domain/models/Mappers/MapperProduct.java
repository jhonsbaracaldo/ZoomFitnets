package Bardp.com.FittnessGym.domain.models.Mappers;

import Bardp.com.FittnessGym.domain.models.dto.DtoProduct;
import Bardp.com.FittnessGym.domain.models.products.Products;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperProduct {


    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.createTypeMap(Products.class, DtoProduct.class);
        return modelMapper;
    }
}
