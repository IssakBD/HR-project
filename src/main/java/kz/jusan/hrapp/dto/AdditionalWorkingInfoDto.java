package kz.jusan.hrapp.dto;

import lombok.Data;

@Data
public class AdditionalWorkingInfoDto {
    private String position;

    private String name;

    private String iin;

    private String address;

    private String typeOfWork;

    private String phoneNumber;
}
