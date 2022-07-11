package kz.jusan.hrapp.model.form;


import kz.jusan.hrapp.model.User;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "maininfo")
@Data
public class MainInfo {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "iin")
    private String iin;

    @Column(name = "fio")
    private String FIO;

    @Column(name = "dateOfBirthday")
    private String dateOfBirthday;

    @Column(name = "placeOfBirth")
    private String placeOfBirth;

    @Column(name = "nationality")
    private String nationality;

    @Column(name = "citizenship")
    private String citizenship;

    @Column(name = "passportSeries")
    private String passportSeries;

    @Column(name = "passportIssued")
    private String passportIssued;

    @Column(name = "identityCardNumber")
    private String identityCardNumber;

    @Column(name = "identityCardIssued")
    private String identityCardIssued;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
}
