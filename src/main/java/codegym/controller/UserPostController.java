package codegym.controller;

import codegym.model.UserPost;
import codegym.service.impl.UserPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static org.springframework.http.HttpStatus.OK;

@RestController
@CrossOrigin("*")
@RequestMapping("/UserPost")
public class UserPostController {
    @Autowired
    UserPostService userPostService;
    @Autowired
    ServletContext context;

    @PostMapping("/save")
    public ResponseEntity<UserPost> save(@RequestBody UserPost userPost) {

        return new ResponseEntity<>(userPostService.save(userPost), OK);
    }

    @GetMapping("/findAll")
    public ResponseEntity<ArrayList<UserPost>> findAll() {
        return new ResponseEntity<>(userPostService.findAll(), OK);
    }

    @GetMapping("/findById{id}")
    public ResponseEntity<UserPost> findById(@PathVariable(name = "id") long id) {
        return new ResponseEntity<>(userPostService.findById(id), OK);

    }

    @DeleteMapping("/remove{id}")
    public ResponseEntity remove(@PathVariable(name = "id") long id) {
        userPostService.remove(id);
        return new ResponseEntity(OK);
    }

    @GetMapping("/findAllPostByFriend{idUser}")
    public ResponseEntity<ArrayList<ArrayList<UserPost>>> findAllPostByFriend(@PathVariable long idUser) {
        return new ResponseEntity<>(userPostService.findAllPostByFriend(idUser), OK);
    }

    @GetMapping("/findAllByUser{id}")
    public ResponseEntity<ArrayList<UserPost>> findAllByUser(@PathVariable long id) {
        return new ResponseEntity<>(userPostService.findAllByUser(id), OK);
    }



}
