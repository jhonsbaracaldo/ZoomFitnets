package Bardp.com.FittnessGym.infraestructure.repository;

import Bardp.com.FittnessGym.domain.models.products.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepositroy extends JpaRepository<Products,Long>
{

}
