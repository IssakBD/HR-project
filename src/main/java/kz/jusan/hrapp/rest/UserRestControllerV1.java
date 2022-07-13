package kz.jusan.hrapp.rest;

import kz.jusan.hrapp.dto.UserDto;
import kz.jusan.hrapp.dto.UserRegistrationDto;
import kz.jusan.hrapp.model.User;
import kz.jusan.hrapp.service.UserService;
import kz.jusan.hrapp.service.impl.EmailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * REST controller user connected requestst.
 *
 * @author Eugene Suleimanov
 * @version 1.0
 */

@RestController
@RequestMapping(value = "/users")
@CrossOrigin("*")
public class UserRestControllerV1 {
    private final UserService userService;

    private final EmailServiceImpl emailService;

    @Autowired
    public UserRestControllerV1(UserService userService, EmailServiceImpl emailService) {
        this.userService = userService;
        this.emailService = emailService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable(name = "id") Long id){
        User user = userService.findById(id);

        if(user == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        UserDto result = userService.fromUser(user);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/sign-up")
    public HashMap<String, String> uploadFile(@RequestBody UserRegistrationDto userRegistrationDto) {
        HashMap<String, String> answer = new HashMap<>();
        try {
            User user = new User();
            user.setUsername(userRegistrationDto.getEmail());
            String password = String.valueOf(Math.floor(Math.random()*(1000-100+1)+100));

            if(!userService.isUsernameExist(userRegistrationDto.getEmail())) {
                user.setPassword(password);
                userService.register(user);


                answer.put("answer", "User is saved");
                answer.put("password", password);

                String subject = new String("Добро пожаловать в Жусан Банк!");
                String text = new String(" Вы автоматически зарегистрированы в систему приема документов." +
                        "\n Ваш логин: " + userRegistrationDto.getEmail()
                        + "\n Ваш пароль: " + password);

                emailService.sendSimpleMessage(userRegistrationDto.getEmail(), subject, text);
            } else {
                answer.put("answer", "User is exist");
            }
        } catch (Exception e) {
            answer.put("answer", "User is not saved");
            e.printStackTrace();
        }
        return answer;
    }
    @GetMapping("/all")
    public HashMap<String, List<UserDto>> getAllUsers() {
        HashMap<String, List<UserDto>> answer = new HashMap<>();
        try {
                answer.put("users", userService.getAllUsers());
            } catch (Exception e) {
            e.printStackTrace();
        }
        return answer;
    }


}
