package codegym.repository;

import codegym.model.UserPost;
import codegym.model.UserPostComment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface IUserPostCommentRepo extends CrudRepository<UserPostComment,Long> {
    @Query("select u from UserPostComment u where u.upc_UserPost = ?1")
    ArrayList<UserPostComment> findAllByUpc_UserPost(UserPost userPost);



@Query(nativeQuery = true,value = "select * from UserPostComment where upc_postUser_id=?1 order by upc_like desc limit 2")
ArrayList<UserPostComment> findAllByUPCLimit2(UserPost userPost);
}
