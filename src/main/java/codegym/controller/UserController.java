package codegym.controller;


import codegym.model.User;
import codegym.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

import static org.springframework.http.HttpStatus.OK;


@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/findAll")
    public ResponseEntity<ArrayList<User>> findAll() {
        return new ResponseEntity<>(userService.findAll(), OK);
    }

    @GetMapping("/findId{id}")
    public ResponseEntity<User> findId(@PathVariable(name = "id") long id) {
        return new ResponseEntity<>(userService.findByIdUser(id), OK);
    }

    @GetMapping("/findUsername{name}")
    public ResponseEntity<ArrayList<User>> findUsername(@PathVariable(name = "name") String name) {
        return new ResponseEntity<>(userService.findAllByUsername(name), OK);
    }

    @PostMapping("/save")
    public ResponseEntity<User> save(@RequestBody User user) {
        return new ResponseEntity<>(userService.saveUser(user), OK);
    }

    @DeleteMapping("/remove{id}")
    public ResponseEntity remove(@PathVariable(name = "id") long id) {
        userService.remove(id);
        return new ResponseEntity(OK);
    }

    @GetMapping("/isDupliUser{username}")
    public ResponseEntity<Boolean> isDupliUser(@PathVariable String username) {
        return new ResponseEntity<>(userService.isDuplicate(username), OK);
    }

    @GetMapping("/findByIdLogin{username},{password}")
    public ResponseEntity<Long> findIdLogin(@PathVariable String username, @PathVariable String password) {
        return new ResponseEntity<>(userService.findIdUserLogin(username, password), OK);
    }
    @GetMapping("/isSuccessLogin{username},{password}")
    public ResponseEntity<Boolean> isSuccessLogin(@PathVariable String username,@PathVariable String password){
        return new ResponseEntity<>(userService.isSuccessLogin(username,password),OK);
    }
}