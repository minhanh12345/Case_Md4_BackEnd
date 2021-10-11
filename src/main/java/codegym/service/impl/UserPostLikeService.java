package codegym.service.impl;

import codegym.model.User;
import codegym.model.UserPostLike;
import codegym.repository.IUserPostLikeRepo;
import codegym.repository.IUserPostRepo;
import codegym.repository.IUserRepo;
import codegym.service.IUserPostLikeService;
import codegym.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserPostLikeService implements IUserPostLikeService {
    @Autowired
    IUserPostLikeRepo iUserPostLikeRepo;
    @Autowired
    IUserPostRepo iUserPostRepo;
@Autowired
IUserRepo iUserRepo;
    @Override
    public ArrayList<UserPostLike> findAll() {
        return (ArrayList<UserPostLike>) iUserPostLikeRepo.findAll();
    }

    @Override
    public UserPostLike save(UserPostLike userPostLike) {
        return iUserPostLikeRepo.save(userPostLike);
    }

    @Override
    public void remove(long id) {
        iUserPostLikeRepo.delete(iUserPostLikeRepo.findById(id).get());
    }

    @Override
    public UserPostLike findById(long id) {
        return iUserPostLikeRepo.findById(id).get();
    }

    public ArrayList<User> findUserLikePost(long id) {
        return iUserPostLikeRepo.findAllByUserPost(iUserPostRepo.findById(id).get());
    }

    public boolean isLikePost(long idUser, long idPost) {
        boolean isLikePost = false;
        ArrayList<User> list = findUserLikePost(idPost);
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getUser_id() == idUser) {
                    isLikePost = true;
                    break;
                }
            }
        }
        return isLikePost;
    }
    public ArrayList<UserPostLike> findListByUserPostandUser(long idUser, long idPost){
       return iUserPostLikeRepo.findAllByUserAndUserPost(iUserRepo.findById(idUser).get(),iUserPostRepo.findById(idPost).get());
    }
    public UserPostLike findByUserandUserPost(long idUser,long idPost){
        UserPostLike userPostLike=findListByUserPostandUser(idUser,idPost).get(0);
        return userPostLike;
    }
}
