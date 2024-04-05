package Bardp.com.FittnessGym.infraestructure.repository;

import Bardp.com.FittnessGym.domain.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository  extends JpaRepository <User, Long> {

}
