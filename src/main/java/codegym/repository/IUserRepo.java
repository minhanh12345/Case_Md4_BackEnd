package codegym.repository;

import codegym.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.List;

public interface IUserRepo extends CrudRepository<User,Long> {
@Query("select u from User u where u.user_username like %:name%")
List<User> findAllByUser_usernameContaining(@Param("name") String name);

@Query("select u.user_id from User u where u.user_username = ?1 and u.user_password = ?2")
Long getUserByUser_usernameAndAndUser_password(String username,String password);


}

