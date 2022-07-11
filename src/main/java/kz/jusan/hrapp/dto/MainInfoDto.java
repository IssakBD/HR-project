package kz.jusan.hrapp.dto;

import lombok.Data;

@Data
public class MainInfoDto {

    private String iin;

    private String FIO;

    private String dateOfBirthday;

    private String placeOfBirth;

    private String nationality;

    private String citizenship;

    private String passportSeries;

    private String passportIssued;

    private String identityCardNumber;

    private String identityCardIssued;
}
