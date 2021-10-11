package codegym.controller;

import codegym.model.Friend;
import codegym.model.User;
import codegym.service.impl.FriendService;
import codegym.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/friend")
@CrossOrigin("*")
public class FriendController {
    @Autowired
    FriendService friendService;
    @GetMapping("/findById{id}")
    public ResponseEntity<Friend> findById(@PathVariable long id){
        return new ResponseEntity<>(friendService.findById(id), HttpStatus.OK);
    }
    @PostMapping ("/save")
    public ResponseEntity<Friend> save(@RequestBody Friend friend){
        return new ResponseEntity<>(friendService.save(friend),HttpStatus.OK);
    }
    @DeleteMapping("/remove{id}")
    public ResponseEntity remove(@PathVariable long id){
        friendService.remove(id);
        return new ResponseEntity(HttpStatus.OK);
    }
    @GetMapping("/findFriend{id}")
    public ResponseEntity<List<User>> findFriend(@PathVariable long id){
        return new ResponseEntity<>(friendService.findTargetBySource(id),HttpStatus.OK);
    }
@GetMapping("/findUnFriend{idUser}")
    public ResponseEntity<ArrayList<User>> findUnFriend(@PathVariable long idUser){
        return new ResponseEntity(friendService.findUnFriend(idUser),HttpStatus.OK);
}
@GetMapping("/findAddFriend{idUser}")
    public ResponseEntity<ArrayList<Friend>> findAddFriend(@PathVariable long idUser){
        return new ResponseEntity(friendService.findAddFriend(idUser),HttpStatus.OK);
}
@GetMapping("/findSourceAndTarget{idSource},{idTarget}")
    public ResponseEntity<ArrayList<Friend>> findSourceAndTarget(@PathVariable long idSource,@PathVariable long idTarget){
        return new ResponseEntity<>(friendService.findAllBySourceAndTarget(idSource,idTarget),HttpStatus.OK);
}
}
