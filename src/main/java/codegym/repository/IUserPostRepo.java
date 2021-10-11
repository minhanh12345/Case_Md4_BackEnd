package codegym.repository;

import codegym.model.User;
import codegym.model.UserPost;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IUserPostRepo extends CrudRepository<UserPost,Long> {
    @Query("select u from UserPost u where u.postUser_user = ?1 and u.postUser_isPublic = true")
    List<UserPost>findAllByPostUser_userAndAndPostUser_isPublicIsTrue(User user);

    @Query("select u from UserPost u where u.postUser_user = ?1")
    List<UserPost>findAllByPostUser_user (User user);
}
