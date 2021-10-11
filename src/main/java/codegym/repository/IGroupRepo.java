package codegym.repository;

import codegym.model.Group;
import org.springframework.data.repository.CrudRepository;

public interface IGroupRepo extends CrudRepository<Group,Long> {
}
