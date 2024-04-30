package Bardp.com.FittnessGym.aplication.controller;

import Bardp.com.FittnessGym.aplication.services.ServicesProduct;
import Bardp.com.FittnessGym.domain.models.dto.DtoProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "/v1/api/products")
@RestController
public class ControllerProducts {

    private ServicesProduct servicesProduct;
    @Autowired
    public ControllerProducts(ServicesProduct servicesProduct) {
        this.servicesProduct = servicesProduct;
    }
@GetMapping(path = "/vertodos_los_productos")
  public List<DtoProduct>allProducto (){
        return servicesProduct.allProduct();
  }
@PostMapping(path = "/añadir_ productos ")
    public ResponseEntity<DtoProduct> add(@RequestBody DtoProduct dtoProduct) {
        return servicesProduct.saveProduct(dtoProduct);
    }

}
