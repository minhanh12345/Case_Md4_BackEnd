package codegym.service;

import codegym.model.GroupMember;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface IGroupMemberService  {
    ArrayList<GroupMember> findAll();
    GroupMember save(GroupMember groupMember);
    void remove(long id);
    GroupMember findById(long id);
}
