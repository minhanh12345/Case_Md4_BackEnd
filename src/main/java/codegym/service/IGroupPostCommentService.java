package codegym.service;

import codegym.model.GroupPostComment;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface IGroupPostCommentService  {
    ArrayList<GroupPostComment> findAll();
    GroupPostComment save(GroupPostComment groupPostComment);
    void remove(long id);
    GroupPostComment findById(long id);
}
