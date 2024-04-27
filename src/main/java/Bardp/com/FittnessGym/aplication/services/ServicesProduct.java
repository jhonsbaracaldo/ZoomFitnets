package Bardp.com.FittnessGym.aplication.services;

import Bardp.com.FittnessGym.domain.category.Status;
import Bardp.com.FittnessGym.domain.models.Mappers.MapperProduct;
import Bardp.com.FittnessGym.domain.models.dto.DtoProduct;
import Bardp.com.FittnessGym.domain.models.products.Products;
import Bardp.com.FittnessGym.infraestructure.repository.IProductRepositroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicesProduct {
    @Autowired
 private IProductRepositroy iProductRepositroy;
 @Autowired
 private MapperProduct mapperProduct;

 public List<DtoProduct>allProduct(){
    List<Products> products =iProductRepositroy.findAll();
    return products.stream().map(products1 -> mapperProduct.modelMapper().map(products,DtoProduct.class)).toList();
 }


     public Optional<DtoProduct> getProductById(Long id) {
        Optional<Products> products = iProductRepositroy.findById(id);
        return products.map(products1 -> mapperProduct.modelMapper().map(products1, DtoProduct.class));
    }

    public ResponseEntity<DtoProduct> saveProduct(DtoProduct dtoProduct){
        Optional<Products> existingProduct = iProductRepositroy.findById(dtoProduct.getId());
     if(existingProduct.isPresent()){
       return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
     else {
         Products products = mapperProduct.modelMapper().map(dtoProduct, Products.class);
        Products saveProducts = iProductRepositroy.save(products);
         DtoProduct saveDtoProducts = mapperProduct.modelMapper().map(saveProducts, DtoProduct.class);
         return  new ResponseEntity<>(HttpStatus.CREATED);
      }
    }

    public ResponseEntity<DtoProduct> updateProduct(DtoProduct dtoProduct){
        Optional<Products> existingProduct = iProductRepositroy.findById(dtoProduct.getId());
        if(existingProduct.isPresent()){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            Products products = mapperProduct.modelMapper().map(dtoProduct, Products.class);
            Products saveProducts = iProductRepositroy.save(products);
            DtoProduct saveDtoProducts = mapperProduct.modelMapper().map(saveProducts, DtoProduct.class);
            return  new ResponseEntity<>(HttpStatus.CREATED);
        }
    }

    public ResponseEntity<Object>delete (Long id){
      iProductRepositroy.deleteById(id);
     return  new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
