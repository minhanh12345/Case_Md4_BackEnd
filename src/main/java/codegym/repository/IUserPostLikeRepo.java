package codegym.repository;

import codegym.model.User;
import codegym.model.UserPost;
import codegym.model.UserPostLike;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface IUserPostLikeRepo extends CrudRepository<UserPostLike,Long> {
    @Query("select u.user from UserPostLike u where u.userPost = ?1")
    ArrayList<User> findAllByUserPost(UserPost userPost);


@Query("select u from UserPostLike u where u.user = ?1 and u.userPost = ?2")
ArrayList<UserPostLike> findAllByUserAndUserPost(User user,UserPost userPost);
}
