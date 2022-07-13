package kz.jusan.hrapp.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import kz.jusan.hrapp.model.FileDB;
import kz.jusan.hrapp.model.Photo;
import kz.jusan.hrapp.model.User;
import lombok.Data;
import org.springframework.security.core.parameters.P;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * DTO class for user requests by ROLE_USER
 *
 * @author Eugene Suleimanov
 * @version 1.0
 */

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto {
    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;

    private List<FileDBDto> fileDBDtos;

    private PhotoDto photoDto;

    public User toUser(){
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);

        return user;
    }

}
