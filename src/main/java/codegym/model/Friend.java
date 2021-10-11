package codegym.model;

import javax.persistence.*;

@Entity
public class Friend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long friend_id;
    @ManyToOne
    @JoinColumn(name = "friend_user_id_source")
    private User friend_userSource;
    @ManyToOne
    @JoinColumn(name = "friend_user_id_target")
    private User friend_userTarget;
    private boolean friend_isAgree;

    public Friend() {
    }

    public Friend(long friend_id, User friend_userSource, User friend_userTarget, boolean friend_isAgree) {
        this.friend_id = friend_id;
        this.friend_userSource = friend_userSource;
        this.friend_userTarget = friend_userTarget;
        this.friend_isAgree = friend_isAgree;
    }

    public long getFriend_id() {
        return friend_id;
    }

    public void setFriend_id(long friend_id) {
        this.friend_id = friend_id;
    }

    public User getFriend_userSource() {
        return friend_userSource;
    }

    public void setFriend_userSource(User friend_userSource) {
        this.friend_userSource = friend_userSource;
    }

    public User getFriend_userTarget() {
        return friend_userTarget;
    }

    public void setFriend_userTarget(User friend_userTarget) {
        this.friend_userTarget = friend_userTarget;
    }

    public boolean isFriend_isAgree() {
        return friend_isAgree;
    }

    public void setFriend_isAgree(boolean friend_isAgree) {
        this.friend_isAgree = friend_isAgree;
    }
}
