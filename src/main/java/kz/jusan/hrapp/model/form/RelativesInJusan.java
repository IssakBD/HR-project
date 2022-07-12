package kz.jusan.hrapp.model.form;

import kz.jusan.hrapp.model.User;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "relativesInJusan")
@Data
public class RelativesInJusan {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "degreeOfRelationship")
    private String degreeOfRelationship;

    @Column(name = "fio")
    private String FIO;

    @Column(name = "departmentAndPosition")
    private String departmentAndPosition;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
}
