package codegym.service;

import codegym.model.UserPostComment;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface IUserPostCommentService  {
    UserPostComment findById(long id);
    ArrayList<UserPostComment> findAll();
    UserPostComment save(UserPostComment userPostComment);
    void remove(long id);
}
