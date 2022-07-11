package kz.jusan.hrapp.controller;

import kz.jusan.hrapp.dto.MainInfoDto;
import kz.jusan.hrapp.model.form.MainInfo;
import kz.jusan.hrapp.service.UserService;
import kz.jusan.hrapp.service.impl.InfoServiceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/form")
@CrossOrigin("*")
public class FormController {

    private final InfoServiceImpl infoService;
    private final UserService userService;

    @Autowired
    public FormController(InfoServiceImpl infoService, UserService userService) {
        this.infoService = infoService;
        this.userService = userService;
    }

    @PostMapping("/upload/maininfo/{user_id}")
    public Map<String, String> uploadMainInfo(@PathVariable("user_id") Long user_id, @RequestBody MainInfoDto mainInfoDto) {
        Map<String, String> answer = new HashMap<>();
        try {
            MainInfo mainInfo = new MainInfo();
            mainInfo.setId(user_id);
            mainInfo.setIin(mainInfoDto.getIin());
            mainInfo.setFIO(mainInfoDto.getFIO());
            mainInfo.setDateOfBirthday(mainInfoDto.getDateOfBirthday());
            mainInfo.setPlaceOfBirth(mainInfoDto.getPlaceOfBirth());
            mainInfo.setNationality(mainInfoDto.getNationality());
            mainInfo.setCitizenship(mainInfoDto.getCitizenship());
            mainInfo.setIdentityCardNumber(mainInfoDto.getIdentityCardNumber());
            mainInfo.setIdentityCardIssued(mainInfoDto.getIdentityCardIssued());
            mainInfo.setPassportSeries(mainInfoDto.getPassportSeries());
            mainInfo.setPassportIssued(mainInfoDto.getPassportIssued());
            mainInfo.setUser(userService.findById(user_id));
            infoService.save(mainInfo);
            answer.put("answer", "Main info is uploaded");
        } catch (Exception e) {
            answer.put("answer", "Main info is not uploaded");
        }

        return answer;
    }
    @GetMapping("/download/maininfo/{user_id}")
    public Map<String, String> downloadMainInfo(@PathVariable("user_id") Long user_id) {
        Map<String, String> answer = new HashMap<>();
        try {
            infoService.findById(user_id);
            answer.put("answer", "Main info is sent");
        } catch (Exception e) {
            answer.put("answer", "Main info didn't send");
        }

        return answer;
    }

}
