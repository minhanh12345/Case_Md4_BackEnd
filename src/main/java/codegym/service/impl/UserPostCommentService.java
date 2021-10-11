package codegym.service.impl;

import codegym.model.UserPost;
import codegym.model.UserPostComment;
import codegym.repository.IUserPostCommentRepo;
import codegym.repository.IUserPostRepo;
import codegym.repository.IUserRepo;
import codegym.service.IUserPostCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserPostCommentService implements IUserPostCommentService {
    @Autowired
    IUserPostCommentRepo iUserPostCommentRepo;
    @Autowired
    IUserPostRepo iUserPostRepo;
    @Autowired
    IUserRepo iUserRepo;

    @Override
    public UserPostComment findById(long id) {
        return iUserPostCommentRepo.findById(id).get();
    }

    @Override
    public ArrayList<UserPostComment> findAll() {
        return (ArrayList<UserPostComment>) iUserPostCommentRepo.findAll();
    }

    @Override
    public UserPostComment save(UserPostComment userPostComment) {
        return iUserPostCommentRepo.save(userPostComment);
    }

    @Override
    public void remove(long id) {
        iUserPostCommentRepo.delete(findById(id));
    }

    public ArrayList<UserPostComment> findAllCommentByPost(long id) {
        setNumCmt(id);
        return iUserPostCommentRepo.findAllByUpc_UserPost(iUserPostRepo.findById(id).get());
    }
    public ArrayList<UserPostComment> findCmtLimit2(long id){
        return iUserPostCommentRepo.findAllByUPCLimit2(iUserPostRepo.findById(id).get());
    }
    public void setNumCmt(long idUPost){
        ArrayList<UserPostComment> list=iUserPostCommentRepo.findAllByUpc_UserPost(iUserPostRepo.findById(idUPost).get());
        UserPost userPost=iUserPostRepo.findById(idUPost).get();
        userPost.setPostUser_numCmt(list.size());
        iUserPostRepo.save(userPost);
    }
    public ArrayList<UserPostComment> findCmtByAllPostByUser(long idUser,long idUserMain ){
        ArrayList<UserPostComment> listCmt=new ArrayList<>();
        ArrayList<UserPost> listUPost= (ArrayList<UserPost>) iUserPostRepo.findAllByPostUser_user(iUserRepo.findById(idUser).get());
        for(int i=0;i<listUPost.size();i++){
            for( int j=0;j<iUserPostCommentRepo.findAllByUpc_UserPost(iUserPostRepo.findById(listUPost.get(i).getPostUser_id()).get()).size();j++){
                if(iUserPostCommentRepo.findAllByUpc_UserPost(iUserPostRepo.findById(listUPost.get(i).getPostUser_id()).get()).get(j).getUpc_user().getUser_id()==idUserMain){
                listCmt.add(iUserPostCommentRepo.findAllByUpc_UserPost(iUserPostRepo.findById(listUPost.get(i).getPostUser_id()).get()).get(j));}
            }
        }
        return listCmt;
    }
}
