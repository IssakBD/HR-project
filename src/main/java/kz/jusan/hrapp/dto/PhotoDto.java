package kz.jusan.hrapp.dto;

import lombok.Data;

import javax.persistence.Lob;

@Data
public class PhotoDto {
    private Long id;

    private String name;

    private String type;

    @Lob
    private byte[] data;
}
