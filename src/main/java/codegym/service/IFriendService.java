package codegym.service;

import codegym.model.Friend;
import codegym.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

public interface IFriendService  {
    ArrayList<Friend> findAll();
    Friend save(Friend friend);
    void remove(long id);
    Friend findById(long id);
   List<User> findTargetBySource(long id);
}
