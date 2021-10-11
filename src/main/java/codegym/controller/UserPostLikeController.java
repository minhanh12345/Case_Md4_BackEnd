package codegym.controller;

import codegym.model.UserPost;
import codegym.model.UserPostLike;
import codegym.service.impl.UserPostLikeService;
import codegym.service.impl.UserPostService;
import com.mysql.cj.x.protobuf.Mysqlx;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/UPL")
@CrossOrigin("*")
public class UserPostLikeController {
    @Autowired
    UserPostLikeService userPostLikeService;


@Autowired
UserPostService userPostService;
    @PostMapping("/save")
    public ResponseEntity<UserPostLike> save(@RequestBody UserPostLike userPostLike) {
        return new ResponseEntity<>(userPostLikeService.save(userPostLike), HttpStatus.OK);

    }

    @GetMapping("/findAll")
    public ResponseEntity<ArrayList<UserPostLike>> findAll() {
        return new ResponseEntity<>(userPostLikeService.findAll(), HttpStatus.OK);

    }

    @GetMapping("findById{id}")
    public ResponseEntity<UserPostLike> findById(@PathVariable long id) {
        return new ResponseEntity<>(userPostLikeService.findById(id), HttpStatus.OK);

    }

    @DeleteMapping("/remove{id}")
    public ResponseEntity remove(@PathVariable long id) {
        userPostLikeService.remove(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/isLikePost{idUser},{idPost}")
    public ResponseEntity<Boolean> isLikePost(@PathVariable long idUser, @PathVariable long idPost) {
        return new ResponseEntity(userPostLikeService.isLikePost(idUser, idPost), HttpStatus.OK);
    }

    @GetMapping("/findUserLikePost{idPost}")
    public ResponseEntity findUserLikePost(@PathVariable long idPost) {
        return new ResponseEntity(userPostLikeService.findUserLikePost(idPost), HttpStatus.OK);
    }
    @PostMapping("/increaseLikePost{idPost}")
    public ResponseEntity increaseLikePost(@PathVariable long idPost){
    UserPost userPost= userPostService.findById(idPost);
    userPost.setPostUser_like(userPost.getPostUser_like()+1);
    userPostService.save(userPost);
        return new ResponseEntity(HttpStatus.OK);
}
    @PostMapping("/decreaseLikePost{idPost}")
    public ResponseEntity decreaseLikePost(@PathVariable long idPost){
        UserPost userPost= userPostService.findById(idPost);
        userPost.setPostUser_like(userPost.getPostUser_like()-1);
        userPostService.save(userPost);
        return new ResponseEntity(HttpStatus.OK);
    }
@GetMapping("/asd{idUser},{idPost}")
public ResponseEntity<UserPostLike> asds(@PathVariable long idUser,@PathVariable long idPost){
    System.out.println(idPost);
        return new ResponseEntity(userPostLikeService.findByUserandUserPost(idUser,idPost),HttpStatus.OK);
}
    @DeleteMapping("/deleteUPL{idUser},{idPost}")
    public ResponseEntity removeUPL(@PathVariable long idUser,@PathVariable long idPost){
        long id=userPostLikeService.findByUserandUserPost(idUser,idPost).getUpl_id();
        userPostLikeService.remove(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
