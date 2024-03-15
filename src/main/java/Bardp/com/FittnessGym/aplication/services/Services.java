package Bardp.com.FittnessGym.aplication.services;

import Bardp.com.FittnessGym.domain.User;
import Bardp.com.FittnessGym.persistence.IUserRepository;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class Services {
    @Autowired
    private IUserRepository userRepository;



    public List<User> View () {
        List<User> entities = userRepository.findAll();
        return entities;
    }

    public ResponseEntity<Object> Create(User user){
        User newUser = userRepository.save(user);
        return ResponseEntity.ok(newUser);
    }

    public ResponseEntity<Object> Update(User user) {
        Optional<User> optionalUser = userRepository.findById(user.getId());

        // Verifica si el usuario existe en la base de datos
        if (optionalUser.isPresent()) {
            User existingUser = optionalUser.get();
            // Cambia el estado del usuario
            existingUser.setStatus(user.getStatus());
            // Guarda el usuario actualizado en la base de datos
            User updatedUser = userRepository.save(existingUser);
            // Devuelve una respuesta con el usuario actualizado
            return ResponseEntity.ok(updatedUser);
        } else {
            // El usuario no existe en la base de datos
            return ResponseEntity.notFound().build();
        }
    }
}

