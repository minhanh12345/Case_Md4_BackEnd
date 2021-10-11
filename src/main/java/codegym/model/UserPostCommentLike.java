package codegym.model;

import javax.persistence.*;

@Entity
public class UserPostCommentLike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long UPCL_id;
    @ManyToOne
    private UserPostComment userPostComment;
    @ManyToOne
    private User user;

    public UserPostCommentLike() {
    }

    public UserPostCommentLike(long UPCL_id, UserPostComment userPostComment, User user) {
        this.UPCL_id = UPCL_id;
        this.userPostComment = userPostComment;
        this.user = user;
    }

    public long getUPCL_id() {
        return UPCL_id;
    }

    public void setUPCL_id(long UPCL_id) {
        this.UPCL_id = UPCL_id;
    }

    public UserPostComment getUserPostComment() {
        return userPostComment;
    }

    public void setUserPostComment(UserPostComment userPostComment) {
        this.userPostComment = userPostComment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
