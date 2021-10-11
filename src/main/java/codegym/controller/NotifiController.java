package codegym.controller;

import codegym.model.Notifi;
import codegym.service.impl.NotifiService;
import com.mysql.cj.x.protobuf.Mysqlx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/Notifi")
@CrossOrigin("*")
public class NotifiController {
    @Autowired
    NotifiService notifiService;

    @GetMapping("/findNotifiByUser{idUser}")
    public ResponseEntity<ArrayList<Notifi>> findNotifiByUser(@PathVariable long idUser){
        return new ResponseEntity<>(notifiService.findNotifiByUser(idUser), HttpStatus.OK);
    }
    @PostMapping("/save")
    public ResponseEntity<Notifi> save(@RequestBody Notifi notifi){
        return new ResponseEntity<>(notifiService.save(notifi),HttpStatus.OK);

    }
   @GetMapping("/findById{idNoti}")
    public ResponseEntity<Notifi> findById(@PathVariable long idNoti){
        return new ResponseEntity<>(notifiService.findById(idNoti),HttpStatus.OK);
   }
}
