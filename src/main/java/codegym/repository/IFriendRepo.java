package codegym.repository;

import codegym.model.Friend;
import codegym.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.List;

public interface IFriendRepo extends CrudRepository<Friend,Long> {

    @Query("select f.friend_userTarget from Friend f where f.friend_userSource = ?1 and f.friend_isAgree = true")
    List<User>findAllByFriend_userSourceAndAndFriend_isAgreeIsTrue(User user);


@Query("select f from Friend f where f.friend_userTarget.user_id = ?1 and f.friend_isAgree = false")
ArrayList<Friend>findAllByFriend_userTargetAndFriend_isAgreeIsFalse(long id);


@Query("select f from Friend f where f.friend_userSource.user_id = ?1 and f.friend_userTarget.user_id = ?2")
ArrayList<Friend>findAllByFriend_userSourceAndFriend_userTarget(long idSource, long idTarget);
}
