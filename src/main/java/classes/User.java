package classes;

import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;
import org.hibernate.annotations.NamedQuery;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@NamedQuery(name = "Select all users",query = "from User")
@NamedQuery(name = "Find user by login",query = "from User where login = : login")
@Table(name = "user" )
@Indexed
public class User {

    @Id
    int id;

    @Size(min = 3,max = 10,message = "not capable size")
    @Field(index= Index.YES, analyze= Analyze.YES, store= Store.NO)
    String login;

    @Pattern(regexp = "[a-zA-Z]",message = "password can contain only letters")
    @NotNull
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
