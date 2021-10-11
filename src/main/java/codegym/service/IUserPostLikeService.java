package codegym.service;

import codegym.model.UserPostLike;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface IUserPostLikeService  {
    ArrayList<UserPostLike> findAll();
    UserPostLike save(UserPostLike userPostLike);
    void remove(long id);
    UserPostLike findById(long id);
}
