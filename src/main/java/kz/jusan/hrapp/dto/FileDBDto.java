package kz.jusan.hrapp.dto;

import lombok.Data;

import javax.persistence.Lob;

@Data
public class FileDBDto {
    private String id;

    private String name;

    private String type;

    @Lob
    private byte[] data;
}
