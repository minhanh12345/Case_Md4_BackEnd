package codegym.service.impl;

import codegym.model.Group;
import codegym.repository.IGroupRepo;
import codegym.service.IGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class GroupService implements IGroupService {
    @Autowired
    IGroupRepo iGroupRepo;

    @Override
    public ArrayList<Group> findAll() {
        return (ArrayList<Group>) iGroupRepo.findAll();
    }

    @Override
    public Group save(Group group) {
        return iGroupRepo.save(group);
    }

    @Override
    public void remove(long id) {
iGroupRepo.delete(findById(id));
    }

    @Override
    public Group findById(long id) {
        return iGroupRepo.findById(id).get();
    }
}
