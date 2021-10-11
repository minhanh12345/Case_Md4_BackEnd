package codegym.controller;

import codegym.model.UserPost;
import codegym.model.UserPostComment;
import codegym.model.UserPostCommentLike;
import codegym.service.impl.UserPostCommentLikeService;
import codegym.service.impl.UserPostCommentService;
import com.mysql.cj.x.protobuf.Mysqlx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/UPCL")
@CrossOrigin("*")
public class UserPostCommentLikeController {
    @Autowired
    UserPostCommentLikeService userPostCommentLikeService;
    @Autowired
    UserPostCommentService userPostCommentService;

    @GetMapping("/findAll")
    public ResponseEntity<ArrayList<UserPostCommentLike>> findAll() {
        return new ResponseEntity<>(userPostCommentLikeService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/findById{id}")
    public ResponseEntity<UserPostCommentLike> findById(@PathVariable long id) {
        return new ResponseEntity<>(userPostCommentLikeService.findById(id), HttpStatus.OK);

    }

    @PostMapping("/save")
    public ResponseEntity<UserPostCommentLike> save(@RequestBody UserPostCommentLike userPostCommentLike) {
        return new ResponseEntity<>(userPostCommentLikeService.save(userPostCommentLike), HttpStatus.OK);
    }

    @DeleteMapping("/remove{id}")
    public ResponseEntity delete(@PathVariable long id) {
        userPostCommentLikeService.remove(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/isLikeCmt{idUser},{idCmt}")
    public ResponseEntity<Boolean> isLikeCmt(@PathVariable long idUser, @PathVariable long idCmt) {
        return new ResponseEntity<>(userPostCommentLikeService.isLikeComment(idUser, idCmt), HttpStatus.OK);
    }

    @PostMapping("/increaseLikeCmt{idCmt}")
    public ResponseEntity increaseLikePost(@PathVariable long idCmt) {
        UserPostComment userPostComment = userPostCommentService.findById(idCmt);
        userPostComment.setUpc_like(userPostComment.getUpc_like() + 1);
        userPostCommentService.save(userPostComment);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/decreaseLikeCmt{idCmt}")
    public ResponseEntity decreaseLikePost(@PathVariable long idCmt) {
        UserPostComment userPostComment = userPostCommentService.findById(idCmt);
        userPostComment.setUpc_like(userPostComment.getUpc_like() - 1);
        userPostCommentService.save(userPostComment);
        return new ResponseEntity(HttpStatus.OK);
    }
    @DeleteMapping("deleteUPCL{idUser},{idUPC}")
    public ResponseEntity removeUPCL (@PathVariable long idUser,@PathVariable long idUPC){
        long id=userPostCommentLikeService.findByUserAndUPC(idUser,idUPC).getUPCL_id();
        userPostCommentLikeService.remove(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
