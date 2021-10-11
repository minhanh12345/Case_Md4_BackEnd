package codegym.model;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class UserPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long postUser_id;
    private String postUser_content;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date postUser_time;
    private String postUser_img;
    @ColumnDefault("0")
    private int postUser_numCmt;
    private boolean postUser_isPublic;
    @ColumnDefault("0")
    private int postUser_like;
    @ColumnDefault("0")
    private int postUser_dislike;

    @ManyToOne
    @JoinColumn(name = "postUser_user_id")
    private User postUser_user;
    public UserPost(){
    }

    public UserPost(long postUser_id, String postUser_content, Date postUser_time, String postUser_img, int postUser_numCmt, boolean postUser_isPublic, int postUser_like, int postUser_dislike, User postUser_user) {
        this.postUser_id = postUser_id;
        this.postUser_content = postUser_content;
        this.postUser_time = postUser_time;
        this.postUser_img = postUser_img;
        this.postUser_numCmt = postUser_numCmt;
        this.postUser_isPublic = postUser_isPublic;
        this.postUser_like = postUser_like;
        this.postUser_dislike = postUser_dislike;
        this.postUser_user = postUser_user;
    }

    public int getPostUser_like() {
        return postUser_like;
    }

    public void setPostUser_like(int postUser_like) {
        this.postUser_like = postUser_like;
    }

    public int getPostUser_dislike() {
        return postUser_dislike;
    }

    public void setPostUser_dislike(int postUser_dislike) {
        this.postUser_dislike = postUser_dislike;
    }

    public User getPostUser_user() {
        return postUser_user;
    }

    public void setPostUser_user(User postUser_user) {
        this.postUser_user = postUser_user;
    }

    public long getPostUser_id() {
        return postUser_id;
    }

    public void setPostUser_id(long postUser_id) {
        this.postUser_id = postUser_id;
    }

    public String getPostUser_content() {
        return postUser_content;
    }

    public void setPostUser_content(String postUser_content) {
        this.postUser_content = postUser_content;
    }

    public Date getPostUser_time() {
        return postUser_time;
    }

    public void setPostUser_time(Date postUser_time) {
        this.postUser_time = postUser_time;
    }

    public String getPostUser_img() {
        return postUser_img;
    }

    public void setPostUser_img(String postUser_img) {
        this.postUser_img = postUser_img;
    }

    public int getPostUser_numCmt() {
        return postUser_numCmt;
    }

    public void setPostUser_numCmt(int postUser_numCmt) {
        this.postUser_numCmt = postUser_numCmt;
    }

    public boolean isPostUser_isPublic() {
        return postUser_isPublic;
    }

    public void setPostUser_isPublic(boolean postUser_status) {
        this.postUser_isPublic = postUser_status;
    }
}
