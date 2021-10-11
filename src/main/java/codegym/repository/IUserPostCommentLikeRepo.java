package codegym.repository;

import codegym.model.User;
import codegym.model.UserPostComment;
import codegym.model.UserPostCommentLike;
import codegym.model.UserPostLike;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface IUserPostCommentLikeRepo extends CrudRepository<UserPostCommentLike,Long> {
    @Query("select u.user from UserPostCommentLike u where u.userPostComment = ?1")
    ArrayList<User> findAllByUserPostComment(UserPostComment userPostComment);

    @Query("select u from UserPostCommentLike u where u.user = ?1 and u.userPostComment = ?2")
    ArrayList<UserPostCommentLike> findAllByUserAndUserPostComment(User user, UserPostComment userPostComment);
}
