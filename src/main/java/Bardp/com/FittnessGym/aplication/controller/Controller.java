package Bardp.com.FittnessGym.aplication.controller;

import Bardp.com.FittnessGym.aplication.services.Services;
import Bardp.com.FittnessGym.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "/v1/api/user")
@RestController
public class Controller {
    @Autowired
    private Services services;

    @GetMapping
    public List<User> view(User user){
     return  services.View();
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody User user){
        return services.Create(user);
    }

    @PutMapping
    public ResponseEntity<Object> update(@RequestBody User user){
        return services.Update(user);
    }




}
