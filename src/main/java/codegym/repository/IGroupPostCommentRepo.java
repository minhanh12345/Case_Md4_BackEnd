package codegym.repository;

import codegym.model.GroupPostComment;
import org.springframework.data.repository.CrudRepository;

public interface IGroupPostCommentRepo extends CrudRepository<GroupPostComment,Long> {
}
