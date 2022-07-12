package kz.jusan.hrapp.dto;

import lombok.Data;

import javax.persistence.Column;

@Data
public class UniversityInfoDto {
    private String startDateOfEducation;

    private String endDateOfEducation;

    private String nameOfInstitution;

    private String speciality;

    private String formOfStudy;

    private String qualification;
}
