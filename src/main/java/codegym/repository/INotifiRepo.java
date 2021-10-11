package codegym.repository;

import codegym.model.Notifi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface INotifiRepo extends CrudRepository<Notifi, Long> {

@Query(nativeQuery = true,value = "select * from Notifi where userTarget_user_id =?1 order by notifi_id desc limit 3")
ArrayList<Notifi> findAllByUserTarget(long idUser);

}