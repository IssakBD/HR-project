package kz.jusan.hrapp.rest;

import kz.jusan.hrapp.dto.AuthenticationRequestDto;
import kz.jusan.hrapp.model.User;
import kz.jusan.hrapp.repository.UserRepository;
import kz.jusan.hrapp.security.jwt.JwtTokenProvider;
import kz.jusan.hrapp.service.UserService;
import kz.jusan.hrapp.service.impl.FormToWordServiceImpl;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * REST controller for authentication requests (login, logout, register, etc.)
 *
 * @author Eugene Suleimanov
 * @version 1.0
 */

@RestController
@RequestMapping(value = "/")
@CrossOrigin("*")
public class AuthenticationRestControllerV1 {

    private final AuthenticationManager authenticationManager;

    private final JwtTokenProvider jwtTokenProvider;

    private final UserService userService;

    private  final UserRepository userRepository;

    private final FormToWordServiceImpl formToWordService;

    @Autowired
    public AuthenticationRestControllerV1(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider, UserService userService, UserRepository userRepository, FormToWordServiceImpl formToWordService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.userService = userService;
        this.userRepository = userRepository;
        this.formToWordService = formToWordService;
    }


    @PostMapping("sign-in")
    public Map<String, String> login(@RequestBody AuthenticationRequestDto requestDto) {
        try {
            String username = requestDto.getUsername();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, requestDto.getPassword()));
            User user = userRepository.findByUsername(username);

            if (user == null) {
                throw new UsernameNotFoundException("User with username: " + username + " not found");
            }

            String token = jwtTokenProvider.createToken(username, user.getRoles());

            Map<String, String> response = new HashMap<>();
            response.put("username", username);
            response.put("token", token);
            response.put("id", user.getId().toString());

            try {
                formToWordService.updateDocument(new ArrayList<>());
            } catch (InvalidFormatException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            return response;

        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username or password");
        }
    }
}
