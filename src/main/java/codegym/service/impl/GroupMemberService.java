package codegym.service.impl;

import codegym.model.GroupMember;
import codegym.repository.IGroupMemberRepo;
import codegym.service.IGroupMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class GroupMemberService implements IGroupMemberService {
@Autowired
    IGroupMemberRepo iGroupMemberRepo;
    @Override
    public ArrayList<GroupMember> findAll() {
        return (ArrayList<GroupMember>) iGroupMemberRepo.findAll();
    }

    @Override
    public GroupMember save(GroupMember groupMember) {
        return iGroupMemberRepo.save(groupMember);
    }

    @Override
    public void remove(long id) {
iGroupMemberRepo.delete(findById(id));
    }

    @Override
    public GroupMember findById(long id) {
        return iGroupMemberRepo.findById(id).get();
    }
}
