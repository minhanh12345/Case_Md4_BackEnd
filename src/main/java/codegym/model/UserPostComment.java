package codegym.model;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
public class UserPostComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long upc_id;
    private String upc_content;
    @ColumnDefault("0")
    private int upc_like;
    private int upc_dislike;
    @ManyToOne
    @JoinColumn(name = "upc_postUser_id")
    private UserPost upc_UserPost;
    @ManyToOne
    @JoinColumn(name = "upc_user_id")
    private User upc_user;

    public UserPostComment() {
    }

    public UserPostComment(long upc_id, String upc_content, int upc_like, int upc_dislike, UserPost upc_UserPost, User upc_user) {
        this.upc_id = upc_id;
        this.upc_content = upc_content;
        this.upc_like = upc_like;
        this.upc_dislike = upc_dislike;
        this.upc_UserPost = upc_UserPost;
        this.upc_user = upc_user;
    }

    public long getUpc_id() {
        return upc_id;
    }

    public void setUpc_id(long upc_id) {
        this.upc_id = upc_id;
    }

    public String getUpc_content() {
        return upc_content;
    }

    public void setUpc_content(String upc_content) {
        this.upc_content = upc_content;
    }

    public int getUpc_like() {
        return upc_like;
    }

    public void setUpc_like(int upc_like) {
        this.upc_like = upc_like;
    }

    public int getUpc_dislike() {
        return upc_dislike;
    }

    public void setUpc_dislike(int upc_dislike) {
        this.upc_dislike = upc_dislike;
    }

    public UserPost getUpc_postUser() {
        return upc_UserPost;
    }

    public void setUpc_postUser(UserPost upc_UserPost) {
        this.upc_UserPost = upc_UserPost;
    }

    public User getUpc_user() {
        return upc_user;
    }

    public void setUpc_user(User upc_user) {
        this.upc_user = upc_user;
    }
}
