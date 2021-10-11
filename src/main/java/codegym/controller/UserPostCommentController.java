package codegym.controller;

import codegym.model.UserPostComment;
import codegym.service.impl.UserPostCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/UPC")
@CrossOrigin("*")
public class UserPostCommentController {
    @Autowired
    UserPostCommentService userPostCommentService;

    @PostMapping("/save")
    public ResponseEntity<UserPostComment> save(@RequestBody UserPostComment userPostComment) {
        return new ResponseEntity<>(userPostCommentService.save(userPostComment), HttpStatus.OK);
    }

    @GetMapping("/findById{id}")
    public ResponseEntity<UserPostComment> findById(@PathVariable long id) {
        return new ResponseEntity<>(userPostCommentService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("/remove{id}")
    public ResponseEntity remove(@PathVariable long id) {
        userPostCommentService.remove(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/findAllByPost{id}")
    public ResponseEntity<ArrayList<UserPostComment>> findAllByPost(@PathVariable long id) {
        return new ResponseEntity<>(userPostCommentService.findAllCommentByPost(id), HttpStatus.OK);
    }
@GetMapping("/findCmtLimit{id}")
    public ResponseEntity<ArrayList<UserPostComment>> findCmtLimit2(@PathVariable long id){
        return new ResponseEntity<>(userPostCommentService.findCmtLimit2(id),HttpStatus.OK);}

@GetMapping("/findCmtByUser{idUser},{idUserMain}")
        public ResponseEntity<ArrayList<UserPostComment>> findAllCmtByAllPostByUser(@PathVariable long idUser,@PathVariable long idUserMain){
    return new ResponseEntity(userPostCommentService.findCmtByAllPostByUser(idUser,idUserMain),HttpStatus.OK);
    }

}
