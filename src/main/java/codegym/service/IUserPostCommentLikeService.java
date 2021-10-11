package codegym.service;

import codegym.model.UserPostCommentLike;
import codegym.model.UserPostLike;

import java.util.ArrayList;

public interface IUserPostCommentLikeService {
   ArrayList<UserPostCommentLike> findAll();
    UserPostCommentLike save(UserPostCommentLike userPostCommentLike);
    void remove(long id);
    UserPostCommentLike findById(long id);
}
