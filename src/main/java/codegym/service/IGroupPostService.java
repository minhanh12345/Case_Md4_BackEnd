package codegym.service;

import codegym.model.GroupPost;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface IGroupPostService  {
    ArrayList<GroupPost> findAll();
    GroupPost save(GroupPost groupPost);
    void remove(long id);
    GroupPost findById(long id);
}
