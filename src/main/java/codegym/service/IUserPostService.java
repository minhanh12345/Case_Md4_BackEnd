package codegym.service;

import codegym.model.UserPost;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface IUserPostService {
    ArrayList<UserPost> findAll();
    UserPost save (UserPost userPost);
    void remove(long id);
    UserPost findById(long id);
}
