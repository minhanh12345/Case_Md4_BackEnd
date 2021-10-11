package codegym.model;

import javax.persistence.*;

@Entity
@Table(name = "group1")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long group_id;
    private String group_name;
    private int group_numFollow;
    @ManyToOne
    @JoinColumn(name = "group_admin_id")
    private User group_admin;

    public Group() {
    }

    public Group(long group_id, String group_name, int group_numFollow, User group_admin) {
        this.group_id = group_id;
        this.group_name = group_name;
        this.group_numFollow = group_numFollow;
        this.group_admin = group_admin;
    }

    public long getGroup_id() {
        return group_id;
    }

    public void setGroup_id(long group_id) {
        this.group_id = group_id;
    }

    public String getGroup_name() {
        return group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }

    public int getGroup_numFollow() {
        return group_numFollow;
    }

    public void setGroup_numFollow(int group_numFollow) {
        this.group_numFollow = group_numFollow;
    }

    public User getGroup_admin() {
        return group_admin;
    }

    public void setGroup_admin(User group_admin) {
        this.group_admin = group_admin;
    }
}
