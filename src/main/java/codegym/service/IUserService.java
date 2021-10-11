package codegym.service;

import codegym.model.User;
import codegym.repository.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface IUserService  {
    User saveUser(User user);
    User findByIdUser(long id);
    ArrayList<User> findAll();
    void remove(long id);
    ArrayList<User> findAllByUsername(String name);
}
