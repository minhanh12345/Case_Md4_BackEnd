package codegym.service.impl;

import codegym.model.UserPost;
import codegym.repository.IUserPostRepo;
import codegym.repository.IUserRepo;
import codegym.service.IUserPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserPostService implements IUserPostService {
    @Autowired
    IUserPostRepo iUserPostRepo;
    @Autowired
    IUserRepo iUserRepo;
    @Autowired
    FriendService friendService;
    @Override
    public ArrayList<UserPost> findAll() {
        return (ArrayList<UserPost>) iUserPostRepo.findAll();
    }

    @Override
    public UserPost save(UserPost userPost) {
        return iUserPostRepo.save(userPost);
    }

    @Override
    public void remove(long id) {
iUserPostRepo.delete(findById(id));
    }

    @Override
    public UserPost findById(long id) {
        return iUserPostRepo.findById(id).get();
    }
    public ArrayList<UserPost> findAllByUser(long id){
        return (ArrayList<UserPost>) iUserPostRepo.findAllByPostUser_userAndAndPostUser_isPublicIsTrue(iUserRepo.findById(id).get());
    }
    public ArrayList<ArrayList<UserPost>> findAllPostByFriend(long idUser){
        ArrayList<ArrayList<UserPost>> list=new ArrayList<>();
        for(int i=0;i<friendService.findTargetBySource(idUser).size();i++){
            long id =friendService.findTargetBySource(idUser).get(i).getUser_id();
            list.add(findAllByUser(id));
        }
        return list;
    }

}
