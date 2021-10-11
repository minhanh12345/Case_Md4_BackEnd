package codegym.repository;

import codegym.model.GroupPost;
import org.springframework.data.repository.CrudRepository;

public interface IGroupPostRepo extends CrudRepository<GroupPost,Long> {
}
