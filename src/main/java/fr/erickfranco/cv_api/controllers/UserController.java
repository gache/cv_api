package fr.erickfranco.cv_api.controllers;

import fr.erickfranco.cv_api.models.User;
import fr.erickfranco.cv_api.services.serviceinter.UserServiceInter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController {

    private  final UserServiceInter userServiceInter;

    public UserController(UserServiceInter userServiceInter) {
        this.userServiceInter = userServiceInter;
    }

    @PostMapping("/login")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userServiceInter.saveUser(user));
    }
}
