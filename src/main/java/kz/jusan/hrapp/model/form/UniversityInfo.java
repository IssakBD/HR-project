package kz.jusan.hrapp.model.form;

import kz.jusan.hrapp.model.User;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "universityInfo")
@Data
public class UniversityInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "startDateOfEducation")
    private String startDateOfEducation;

    @Column(name = "endDateOfEducation")
    private String endDateOfEducation;

    @Column(name = "nameOfInstitution")
    private String nameOfInstitution;

    @Column(name = "speciality")
    private String speciality;

    @Column(name = "formOfStudy")
    private String formOfStudy;

    @Column(name = "qualification")
    private String qualification;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
}
