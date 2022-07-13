package kz.jusan.hrapp.service.impl;

import kz.jusan.hrapp.dto.FileDBDto;
import kz.jusan.hrapp.dto.PhotoDto;
import kz.jusan.hrapp.dto.UserDto;
import kz.jusan.hrapp.model.*;
import kz.jusan.hrapp.repository.RoleRepository;
import kz.jusan.hrapp.repository.UserRepository;
import kz.jusan.hrapp.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of {@link UserService} interface.
 * Wrapper for {@link UserRepository} + business logic.
 *
 * @author Eugene Suleimanov
 * @version 1.0
 */

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User register(User user) {
        Role roleUser = roleRepository.findByName("ROLE_USER");
        List<Role> userRoles = new ArrayList<>();
        userRoles.add(roleUser);

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(userRoles);
        user.setStatus(Status.ACTIVE);

        User registeredUser = userRepository.save(user);

        log.info("IN register - user: {} successfully registered", registeredUser);

        return registeredUser;
    }

    @Override
    public List<User> getAll() {
        List<User> result = userRepository.findAll();
        log.info("IN getAll - {} users found", result.size());
        return result;
    }




    @Override
    @Transactional
    public User findById(Long id) {
        User result = userRepository.findById(id).orElse(null);

        if (result == null) {
            log.warn("IN findById - no user found by id: {}", id);
            return null;
        }

        log.info("IN findById - user: {} found by id: {}", result);
        return result;
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
        log.info("IN delete - user with id: {} successfully deleted");
    }

    @Transactional
    public UserDto fromUser(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());

        List<FileDBDto> fileDBDtos = new ArrayList<>();
        for (FileDB fileDB : user.getFileDBs()) {
            FileDBDto fileDBDto = new FileDBDto();
            fileDBDto.setId(fileDB.getId());
            fileDBDto.setName(fileDB.getName());
            fileDBDto.setType(fileDB.getType());
            fileDBDto.setData(fileDB.getData());
            fileDBDtos.add(fileDBDto);
        }

        userDto.setFileDBDtos(fileDBDtos);

        Photo photo = user.getPhoto();
        PhotoDto photoDto = new PhotoDto();
        photoDto.setId(photo.getId());
        photoDto.setType(photo.getType());
        photoDto.setName(photo.getName());
        photoDto.setData(photo.getData());
        userDto.setPhotoDto(photoDto);

        return userDto;
    }
}
