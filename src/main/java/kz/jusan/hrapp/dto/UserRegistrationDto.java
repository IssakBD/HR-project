package kz.jusan.hrapp.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
public class UserRegistrationDto {
    private String email;
}
