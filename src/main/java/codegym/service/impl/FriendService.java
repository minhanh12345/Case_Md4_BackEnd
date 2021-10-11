package codegym.service.impl;

import codegym.model.Friend;
import codegym.model.User;
import codegym.repository.IFriendRepo;
import codegym.repository.IUserRepo;
import codegym.service.IFriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FriendService implements IFriendService {
    @Autowired
    IFriendRepo iFriendRepo;
    @Autowired
    IUserRepo iUserRepo;

    @Override
    public ArrayList<Friend> findAll() {
        return (ArrayList<Friend>) iFriendRepo.findAll();
    }

    @Override
    public Friend save(Friend friend) {
        return iFriendRepo.save(friend);
    }

    @Override
    public void remove(long id) {
        iFriendRepo.delete(findById(id));
    }

    @Override
    public Friend findById(long id) {
        return iFriendRepo.findById(id).get();
    }

    @Override
    public List<User> findTargetBySource(long id) {
        return iFriendRepo.findAllByFriend_userSourceAndAndFriend_isAgreeIsTrue(iUserRepo.findById(id).get());
    }

    public boolean isUnFriend(long idUser, long idTarget) {
        boolean isUnFriend = true;
        ArrayList<User> listFriendByIdUser = (ArrayList<User>) findTargetBySource(idUser);
        for (int i = 0; i < listFriendByIdUser.size(); i++) {
            if (listFriendByIdUser.get(i).getUser_id() == idTarget) {
                isUnFriend = false;
                break;
            }
        }
        return isUnFriend;
    }

    public List<User> findUnFriend(long idUser) {
        ArrayList<User> listUser = (ArrayList<User>) iUserRepo.findAll();
        ArrayList<User> listUnFriend = new ArrayList<>();
        for (int i = 0; i < listUser.size(); i++) {
            if (isUnFriend(idUser, listUser.get(i).getUser_id()) && listUser.get(i).getUser_id()!=idUser) {
                listUnFriend.add(listUser.get(i));
            }
        }
        return listUnFriend;
    }
public List<Friend> findAddFriend(long idUser){
      return iFriendRepo.findAllByFriend_userTargetAndFriend_isAgreeIsFalse(idUser)  ;
}
public ArrayList<Friend> findAllBySourceAndTarget(long idSource ,long idTarget){
        return iFriendRepo.findAllByFriend_userSourceAndFriend_userTarget(idSource,idTarget);
}
}
