package codegym.service.impl;

import codegym.model.Notifi;
import codegym.repository.INotifiRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class NotifiService {
    @Autowired
    INotifiRepo iNotifiRepo;
    public Notifi save(Notifi notifi){
        return iNotifiRepo.save(notifi);
    }
    public Notifi findById(long id){
        return iNotifiRepo.findById(id).get();
    }
    public void delete(long id){
        iNotifiRepo.delete(iNotifiRepo.findById(id).get());
    }
public ArrayList<Notifi> findNotifiByUser(long idUser){
        return iNotifiRepo.findAllByUserTarget(idUser);
}
}
