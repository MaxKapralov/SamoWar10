package project.model.data;

import com.sun.javafx.beans.IDProperty;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_user", nullable = false)
    private Long id;

    @Column(nullable = false)
    private String login;

    @Column(nullable = false)
    private String password;

    public User(){}

    public User(String login, CharSequence password)
    {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        this.login = login;
        this.password = encoder.encode(password);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {

        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }


}
