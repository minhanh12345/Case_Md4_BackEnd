package codegym.service.impl;

import codegym.model.GroupPost;
import codegym.repository.IGroupPostRepo;
import codegym.service.IGroupPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class GroupPostService implements IGroupPostService {
    @Autowired
    IGroupPostRepo iGroupPostRepo;
    @Override
    public ArrayList<GroupPost> findAll() {
        return (ArrayList<GroupPost>) iGroupPostRepo.findAll();
    }

    @Override
    public GroupPost save(GroupPost groupPost) {
        return iGroupPostRepo.save(groupPost);
    }

    @Override
    public void remove(long id) {
iGroupPostRepo.delete(findById(id));
    }

    @Override
    public GroupPost findById(long id) {
        return iGroupPostRepo.findById(id).get();
    }
}
