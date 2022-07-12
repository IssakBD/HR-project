package kz.jusan.hrapp.dto;

import lombok.Data;

import javax.persistence.Column;

@Data
public class RelativesInJusanDto {
    private String degreeOfRelationship;

    private String FIO;

    private String departmentAndPosition;
}
