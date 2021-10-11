package codegym.repository;

import codegym.model.GroupMember;
import org.springframework.data.repository.CrudRepository;

public interface IGroupMemberRepo extends CrudRepository<GroupMember,Long> {
}
