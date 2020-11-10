package classes;

import org.hibernate.search.annotations.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user" )
@Indexed
public class User {

    @Id
    int id;
    @Field(index= Index.YES, analyze= Analyze.YES, store= Store.NO)
    String login;
    String password;
    int role;

    public User(int id, String login, String password, int role) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public User() {
        id = 0;
        login = "default";
        password = "default";
        role = 0;
    }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public int getRole() {
        return role;
    }
}
