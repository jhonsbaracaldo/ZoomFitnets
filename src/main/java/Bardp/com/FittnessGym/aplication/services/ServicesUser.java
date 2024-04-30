package Bardp.com.FittnessGym.aplication.services;

import Bardp.com.FittnessGym.domain.models.users.User;
import Bardp.com.FittnessGym.infraestructure.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicesUser {

    private final IUserRepository userRepository;

    @Autowired
    public ServicesUser(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> View() {
        List<User> entities = userRepository.findAll();
        return entities;
    }

    public ResponseEntity<Object> Create(User user) {
        User newUser = userRepository.save(user);
        return ResponseEntity.ok(newUser);


    }

    public ResponseEntity<Object> update(User user) {
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

    public ResponseEntity<Object>delete(Long id){
        boolean existing =this.userRepository.existsById(id);

        if(!existing){
            return ResponseEntity.notFound().build();
        }
        else
        {
            return  ResponseEntity.status(HttpStatus.ACCEPTED).build();
        }
    }
}

