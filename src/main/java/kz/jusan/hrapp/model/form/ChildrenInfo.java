package kz.jusan.hrapp.model.form;

import kz.jusan.hrapp.model.User;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "childrenInfo")
@Data
public class ChildrenInfo {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "fio")
    private String FIO;

    @Column(name = "dateOfBirthday")
    private String dateOfBirthday;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name = "workPlace")
    private String workPlace;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
}
