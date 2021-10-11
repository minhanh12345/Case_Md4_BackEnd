package codegym.model;

import javax.persistence.*;

@Entity
public class UserPostLike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long upl_id;
    @ManyToOne
    private UserPost userPost;
    @ManyToOne
    private User user;

    public UserPostLike() {
    }

    public UserPostLike(long upl_id, UserPost userPost, User user) {
        this.upl_id = upl_id;
        this.userPost = userPost;
        this.user = user;
    }

    public long getUpl_id() {
        return upl_id;
    }

    public void setUpl_id(long upl_id) {
        this.upl_id = upl_id;
    }

    public UserPost getUserPost() {
        return userPost;
    }

    public void setUserPost(UserPost userPost) {
        this.userPost = userPost;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
