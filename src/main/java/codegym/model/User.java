package codegym.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long user_id;
    private String user_username;
    private String user_password;
    private int user_phone;
    private String user_fullname;
    private Date user_birthday;
    private String user_address;

    public User() {
    }

    public User(long user_id, String user_username, String user_password, int user_phone, String user_fullname, Date user_birthday, String user_address) {
        this.user_id = user_id;
        this.user_username = user_username;
        this.user_password = user_password;
        this.user_phone = user_phone;
        this.user_fullname = user_fullname;
        this.user_birthday = user_birthday;
        this.user_address = user_address;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public String getUser_username() {
        return user_username;
    }

    public void setUser_username(String user_username) {
        this.user_username = user_username;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public int getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(int user_phone) {
        this.user_phone = user_phone;
    }

    public String getUser_fullname() {
        return user_fullname;
    }

    public void setUser_fullname(String user_fullname) {
        this.user_fullname = user_fullname;
    }

    public Date getUser_birthday() {
        return user_birthday;
    }

    public void setUser_birthday(Date user_birthday) {
        this.user_birthday = user_birthday;
    }

    public String getUser_address() {
        return user_address;
    }

    public void setUser_address(String user_address) {
        this.user_address = user_address;
    }
}
