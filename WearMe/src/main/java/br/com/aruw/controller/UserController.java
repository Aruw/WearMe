package br.com.aruw.controller;

import br.com.aruw.beans.User;
import br.com.aruw.dao.UserDAO;
import br.com.aruw.jwtutils.JwtTokenUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserDAO userDAO;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAll(){
        List<User> users = (List<User>) userDAO.findAll();
        if(users.size() == 0){
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.ok(users);
    }

    @GetMapping("/user/{cod}")
    public ResponseEntity<User> getUser(@PathVariable int cod){
        User user = userDAO.findById(cod).orElse(null);
        if(user == null){
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.ok(user);
    }

    @PostMapping("/newuser")
    public ResponseEntity<User> addUser(@RequestBody User object){
        try{
            userDAO.save(object);
            return ResponseEntity.ok(object);
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(403).build();
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> generateToken(@RequestBody User object){
        User user = userDAO.findByEmailAndPassword(object.getEmail(), object.getPassword());

        if(user == null){
            return ResponseEntity.status(404).build();
        }

        JwtTokenUtil jwtTokenUtil = new JwtTokenUtil();
        String token = jwtTokenUtil.generateToken(object);
        return ResponseEntity.ok(token);
    }

}