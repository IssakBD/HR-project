package kz.jusan.hrapp.model.form;

import kz.jusan.hrapp.model.User;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "additionalWorkingInfo")
@Data
public class AdditionalWorkingInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "businessType")
    private String businessType;

    @Column(name = "position")
    private String position;

    @Column(name = "name")
    private String name;

    @Column(name = "iin")
    private String iin;

    @Column(name = "address")
    private String address;

    @Column(name = "typeOfWork")
    private String typeOfWork;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

}
