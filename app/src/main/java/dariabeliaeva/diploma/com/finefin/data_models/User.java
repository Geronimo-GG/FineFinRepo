package dariabeliaeva.diploma.com.finefin.data_models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class User extends RealmObject{

    @PrimaryKey
    private String user_email;
    private String user_name;
    private String user_password;

    public User(String user_email, String user_name, String user_password) {
        this.user_email = user_email;
        this.user_name = user_name;
        this.user_password = user_password;
    }

    public User() {
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }
}
