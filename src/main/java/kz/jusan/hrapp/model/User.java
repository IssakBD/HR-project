package kz.jusan.hrapp.model;

import kz.jusan.hrapp.model.form.*;
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
    private List<Role> roles;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Photo photo;

    @OneToOne(mappedBy = "user")
    private MainInfo mainInfo;

    @OneToMany(mappedBy = "user")
    private List<UniversityInfo> universityInfos;

    @OneToMany(mappedBy = "user")
    private List<AdditionalEducationInfo> additionalEducationInfos;

    @OneToMany(mappedBy = "user")
    private List<ChildrenInfo> childrenInfos;

    @OneToMany(mappedBy = "user")
    private List<RelativesInfo> RelativesInfos;

    @OneToMany(mappedBy = "user")
    private List<AdditionalWorkingInfo> additionalWorkingInfos;

    @OneToMany(mappedBy = "user")
    private List<RelativesInJusan> RelativesInJusan;

    @OneToMany(mappedBy = "user")
    private List<FileDB> fileDBS;


    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
