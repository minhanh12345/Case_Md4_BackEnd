package codegym.model;

import javax.persistence.*;

@Entity
public class GroupPostComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long gpc_id;
    private String gpc_content;
    private int gpc_like;
    private int gpc_dislike;
    @ManyToOne
    @JoinColumn(name = "gpc_gp_id")
    private GroupPost gpc_gp;
    @ManyToOne
    @JoinColumn(name = "gpc_user_id")
    private User gpc_user;

    public GroupPostComment() {
    }

    public GroupPostComment(long gpc_id, String gpc_content, int gpc_like, int gpc_dislike, GroupPost gpc_gp, User gpc_user) {
        this.gpc_id = gpc_id;
        this.gpc_content = gpc_content;
        this.gpc_like = gpc_like;
        this.gpc_dislike = gpc_dislike;
        this.gpc_gp = gpc_gp;
        this.gpc_user = gpc_user;
    }

    public long getGpc_id() {
        return gpc_id;
    }

    public void setGpc_id(long gpc_id) {
        this.gpc_id = gpc_id;
    }

    public String getGpc_content() {
        return gpc_content;
    }

    public void setGpc_content(String gpc_content) {
        this.gpc_content = gpc_content;
    }

    public int getGpc_like() {
        return gpc_like;
    }

    public void setGpc_like(int gpc_like) {
        this.gpc_like = gpc_like;
    }

    public int getGpc_dislike() {
        return gpc_dislike;
    }

    public void setGpc_dislike(int gpc_dislike) {
        this.gpc_dislike = gpc_dislike;
    }

    public GroupPost getGpc_gp() {
        return gpc_gp;
    }

    public void setGpc_gp(GroupPost gpc_gp) {
        this.gpc_gp = gpc_gp;
    }

    public User getGpc_user() {
        return gpc_user;
    }

    public void setGpc_user(User gpc_user) {
        this.gpc_user = gpc_user;
    }
}
