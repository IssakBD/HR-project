package kz.jusan.hrapp.model;

import kz.jusan.hrapp.model.form.MainInfo;
import lombok.Data;

import javax.persistence.*;
import java.util.List;


/**
 * Simple domain object that represents application user.
 *
 * @author Eugene Suleimanov
 * @version 1.0
 */

@Entity
@Table(name = "users")
@Data
public class User extends BaseEntity {

    @Column(name = "username")
    private String username;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
    private List<Role> roles;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Photo photo;

    @OneToOne(mappedBy = "user")
    private MainInfo mainInfo;

}
