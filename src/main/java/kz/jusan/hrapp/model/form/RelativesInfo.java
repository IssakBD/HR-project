package kz.jusan.hrapp.model.form;

import kz.jusan.hrapp.model.User;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "relativesInfo")
@Data
public class RelativesInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "degreeOfRelationship")
    private String degreeOfRelationship;

    @Column(name = "fio")
    private String FIO;

    @Column(name = "dateOfBirthday")
    private String dateOfBirthday;

    @Column(name = "workingPlace")
    private String workingPlace;

    @Column(name = "workingPosition")
    private String workingPosition;

    @Column(name = "address")
    private String address;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
}
