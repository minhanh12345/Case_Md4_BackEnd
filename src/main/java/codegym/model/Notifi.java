package codegym.model;

import javax.persistence.*;

@Entity
public class Notifi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long notifi_id;
    @ManyToOne
    private User userTarget;
    private String title;

    public Notifi() {
    }

    public Notifi(long notifi_id, User userTarget, String title) {
        this.notifi_id = notifi_id;
        this.userTarget = userTarget;
        this.title = title;
    }

    public long getNotifi_id() {
        return notifi_id;
    }

    public void setNotifi_id(long notifi_id) {
        this.notifi_id = notifi_id;
    }

    public User getUserTarget() {
        return userTarget;
    }

    public void setUserTarget(User userTarget) {
        this.userTarget = userTarget;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}