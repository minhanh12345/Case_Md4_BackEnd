package codegym.service.impl;

import codegym.model.GroupPostComment;
import codegym.repository.IGroupPostCommentRepo;
import codegym.service.IGroupPostCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class GroupPostCommentService implements IGroupPostCommentService {
    @Autowired
    IGroupPostCommentRepo iGroupPostCommentRepo;
    @Override
    public ArrayList<GroupPostComment> findAll() {
        return (ArrayList<GroupPostComment>) iGroupPostCommentRepo.findAll();
    }

    @Override
    public GroupPostComment save(GroupPostComment groupPostComment) {
        return iGroupPostCommentRepo.save(groupPostComment);
    }

    @Override
    public void remove(long id) {
iGroupPostCommentRepo.delete(findById(id));
    }

    @Override
    public GroupPostComment findById(long id) {
        return iGroupPostCommentRepo.findById(id).get();
    }
}
