package kz.jusan.hrapp.dto;

import lombok.Data;

import javax.persistence.Column;

@Data
public class ChildrenInfoDto {
    private String FIO;

    private String dateOfBirthday;

    private String phoneNumber;

    private String workPlace;
}
