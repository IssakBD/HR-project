package kz.jusan.hrapp.dto;

import lombok.Data;

import javax.persistence.Column;

@Data
public class RelativesInfoDto {
    private String degreeOfRelationship;

    private String FIO;

    private String dateOfBirthday;

    private String workingPlace;

    private String workingPosition;

    private String address;

    private String phoneNumber;
}
