package codegym.model;

import org.springframework.data.repository.cdi.Eager;

import javax.persistence.*;
import java.util.Date;

@Entity
public class GroupPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long gp_id;
    private String gp_content;
    private Date gp_time;
    private String gp_img;
    private int gp_like;
    private int gp_dislike;
    @ManyToOne
    @JoinColumn(name = "gp_user_id")
    private User gp_user;
    @ManyToOne
    @JoinColumn(name = "gp_group_id")
    private Group gp_group;

    public GroupPost() {
    }

    public GroupPost(long gp_id, String gp_content, Date gp_time, String gp_img, int gp_like, int gp_dislike, User gp_user, Group gp_group) {
        this.gp_id = gp_id;
        this.gp_content = gp_content;
        this.gp_time = gp_time;
        this.gp_img = gp_img;
        this.gp_like = gp_like;
        this.gp_dislike = gp_dislike;
        this.gp_user = gp_user;
        this.gp_group = gp_group;
    }

    public long getGp_id() {
        return gp_id;
    }

    public void setGp_id(long gp_id) {
        this.gp_id = gp_id;
    }

    public String getGp_content() {
        return gp_content;
    }

    public void setGp_content(String gp_content) {
        this.gp_content = gp_content;
    }

    public Date getGp_time() {
        return gp_time;
    }

    public void setGp_time(Date gp_time) {
        this.gp_time = gp_time;
    }

    public String getGp_img() {
        return gp_img;
    }

    public void setGp_img(String gp_img) {
        this.gp_img = gp_img;
    }

    public int getGp_like() {
        return gp_like;
    }

    public void setGp_like(int gp_like) {
        this.gp_like = gp_like;
    }

    public int getGp_dislike() {
        return gp_dislike;
    }

    public void setGp_dislike(int gp_dislike) {
        this.gp_dislike = gp_dislike;
    }

    public User getGp_user() {
        return gp_user;
    }

    public void setGp_user(User gp_user) {
        this.gp_user = gp_user;
    }

    public Group getGp_group() {
        return gp_group;
    }

    public void setGp_group(Group gp_group) {
        this.gp_group = gp_group;
    }
}
