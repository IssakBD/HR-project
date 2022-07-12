package kz.jusan.hrapp.model.form;

import kz.jusan.hrapp.model.User;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "additionalEducationInfo")
@Data
public class AdditionalEducationInfo {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "yearOfGraduation")
    private String yearOfGraduation;

    @Column(name = "durationOfTraining")
    private String durationOfTraining;

    @Column(name = "nameOfCourse")
    private String nameOfCourse;

    @Column(name = "speciality")
    private String speciality;

    @Column(name = "academicDegreeOrCertificates")
    private String academicDegreeOrCertificates;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
}
