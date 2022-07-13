package kz.jusan.hrapp.rest;

import kz.jusan.hrapp.dto.UserDto;
import kz.jusan.hrapp.dto.UserRegistrationDto;
import kz.jusan.hrapp.model.User;
import kz.jusan.hrapp.model.form.MainInfo;
import kz.jusan.hrapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    public UserRestControllerV1(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable(name = "id") Long id){
        User user = userService.findById(id);

        if(user == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        UserDto result = UserDto.fromUser(user);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

//    @GetMapping()
//    public List<User> getUserById(){
//        List<User> users = userService.getAll();
//
//        for (User user : users) {
//
//        }
//
//        UserDto result = UserDto.fromUser(user);
//
//        return new ResponseEntity<>(result, HttpStatus.OK);
//    }

    @PostMapping("/sign-up")
    public HashMap<String, String> uploadFile(@RequestBody UserRegistrationDto userRegistrationDto) {
        HashMap<String, String> answer = new HashMap<>();
        try {
            User user = new User();
            user.setUsername(userRegistrationDto.getEmail());
            String password = String.valueOf(Math.floor(Math.random()*(1000-100+1)+100));
            user.setPassword(password);
            userService.register(user);
            answer.put("answer", "User is saved");
            answer.put("password", password);
        } catch (Exception e) {
            answer.put("answer", "User is not saved");
            e.printStackTrace();
        }
        return answer;
    }
}
