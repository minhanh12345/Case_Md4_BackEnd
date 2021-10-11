package codegym.service.impl;

import codegym.model.User;
import codegym.model.UserPostComment;
import codegym.model.UserPostCommentLike;
import codegym.model.UserPostLike;
import codegym.repository.IUserPostCommentLikeRepo;
import codegym.repository.IUserPostCommentRepo;
import codegym.repository.IUserRepo;
import codegym.service.IUserPostCommentLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserPostCommentLikeService implements IUserPostCommentLikeService {
    @Autowired
    IUserPostCommentLikeRepo iUserPostCommentLikeRepo;
    @Autowired
    IUserPostCommentRepo iUserPostCommentRepo;
@Autowired
    IUserRepo iUserRepo;
    @Override
    public ArrayList<UserPostCommentLike> findAll() {
        return (ArrayList<UserPostCommentLike>) iUserPostCommentLikeRepo.findAll();
    }

    @Override
    public UserPostCommentLike save(UserPostCommentLike userPostCommentLike) {
        return iUserPostCommentLikeRepo.save(userPostCommentLike);
    }

    @Override
    public void remove(long id) {
        iUserPostCommentLikeRepo.delete(findById(id));
    }

    @Override
    public UserPostCommentLike findById(long id) {
        return iUserPostCommentLikeRepo.findById(id).get();

    }

    public ArrayList<User> findUserLikeComment(long id) {
        return iUserPostCommentLikeRepo.findAllByUserPostComment(iUserPostCommentRepo.findById(id).get());
    }
    public boolean isLikeComment(long idUser,long idCmt){
        boolean isLikeCmt=false;
        ArrayList<User> list=findUserLikeComment(idCmt);
        if(list!=null){
            for (int i=0;i<list.size();i++){
                if(list.get(i).getUser_id()==idUser){
                    isLikeCmt=true;
                    break;
                }
            }
        }
        return isLikeCmt;
    }
    public ArrayList<UserPostCommentLike> findListByUPCAndUser(long idUser,long idUPC){
        return iUserPostCommentLikeRepo.findAllByUserAndUserPostComment(iUserRepo.findById(idUser).get(),iUserPostCommentRepo.findById(idUPC).get());
    }
    public UserPostCommentLike findByUserAndUPC(long idUser,long idPost){
        UserPostCommentLike userPostCommentLike=findListByUPCAndUser(idUser,idPost).get(0);
        return userPostCommentLike;
    }
}
