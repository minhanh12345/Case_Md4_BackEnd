package codegym.service;

import codegym.model.Group;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface IGroupService  {
    ArrayList<Group> findAll();
    Group save(Group group);
    void remove(long id);
    Group findById(long id);
}
