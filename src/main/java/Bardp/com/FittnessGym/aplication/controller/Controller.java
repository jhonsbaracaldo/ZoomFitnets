package Bardp.com.FittnessGym.aplication.controller;

import Bardp.com.FittnessGym.aplication.services.ServicesUser;
import Bardp.com.FittnessGym.domain.models.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RequestMapping(path = "/v1/api/user")
@RestController
public class Controller {
    @Autowired
    private ServicesUser servicesUser;

    @GetMapping(path = "Lista")
    public List<User> view(User user){
     return  servicesUser.View();
    }

    @PostMapping(path = "/registrar")
    public ResponseEntity<Object> create(@RequestBody User user){
        return servicesUser.Create(user);
    }

    @PutMapping
    public ResponseEntity<Object> update(@RequestBody User user){
        return servicesUser.update(user);
    }




}
