package codegym.model;

import javax.persistence.*;

@Entity
public class GroupMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long gm_id;
    @ManyToOne
    @JoinColumn(name = "gm_user_id")
    private User gm_user;
    @ManyToOne
    @JoinColumn(name = "gm_group_id")
    private Group gm_group;

    public GroupMember() {
    }

    public GroupMember(long gm_id, User gm_user, Group gm_group) {
        this.gm_id = gm_id;
        this.gm_user = gm_user;
        this.gm_group = gm_group;
    }

    public long getGm_id() {
        return gm_id;
    }

    public void setGm_id(long gm_id) {
        this.gm_id = gm_id;
    }

    public User getGm_user() {
        return gm_user;
    }

    public void setGm_user(User gm_user) {
        this.gm_user = gm_user;
    }

    public Group getGm_group() {
        return gm_group;
    }

    public void setGm_group(Group gm_group) {
        this.gm_group = gm_group;
    }
}
