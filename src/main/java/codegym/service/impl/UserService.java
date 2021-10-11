package codegym.service.impl;

import codegym.model.User;
import codegym.repository.IUserRepo;
import codegym.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService implements IUserService {
    @Autowired
    IUserRepo iUserRepo;

    @Override
    public User saveUser(User user) {
        return iUserRepo.save(user);
    }

    @Override
    public User findByIdUser(long id) {
        return iUserRepo.findById(id).get();
    }

    @Override
    public ArrayList<User> findAll() {
        return (ArrayList<User>) iUserRepo.findAll();
    }

    @Override
    public void remove(long id) {
        iUserRepo.delete(findByIdUser(id));
    }

    @Override
    public ArrayList<User> findAllByUsername(String name) {
        return (ArrayList<User>) iUserRepo.findAllByUser_usernameContaining(name);
    }

    public Long findIdUserLogin(String username, String password) {
        return iUserRepo.getUserByUser_usernameAndAndUser_password(username, password);

    }

    public boolean isDuplicate(String username) {
        boolean isDuplicate = false;
        ArrayList<User> listAllUser = (ArrayList<User>) iUserRepo.findAll();
        for (int i = 0; i < listAllUser.size(); i++) {
            if (listAllUser.get(i).getUser_username().equals(username)) {
                isDuplicate = true;
                break;
            }
        }
        return isDuplicate;
    }
    public boolean isSuccessLogin(String username,String password){
        Boolean isSuccess=false;
        Long idUser=iUserRepo.getUserByUser_usernameAndAndUser_password(username,password);
        if(idUser!=null){
            isSuccess=true;
        }
        return isSuccess;
    }
}
