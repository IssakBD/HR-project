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

    @PostMapping("/upload/info/{user_id}")
    public Map<String, String> uploadMainInfo(@PathVariable("user_id") Long user_id, @RequestBody MainInfoDto mainInfoDto) {
        Map<String, String> answer = new HashMap<>();
        try {
            infoService.save(mainInfoDto, user_id);
            answer.put("answer", "Main info is uploaded");
        } catch (Exception e) {
            answer.put("answer", "Main info is not uploaded");
        }

        return answer;
    }
    @GetMapping("/download/info/{user_id}")
    public MainInfoDto downloadMainInfo(@PathVariable("user_id") Long user_id) {
        MainInfoDto mainInfoDto = new MainInfoDto();
        try {
            MainInfo mainInfo = infoService.findById(user_id).get();
            mainInfoDto.setIin(mainInfo.getIin());
            mainInfoDto.setFIO(mainInfo.getFIO());
            mainInfoDto.setDateOfBirthday(mainInfo.getDateOfBirthday());
            mainInfoDto.setPlaceOfBirth(mainInfo.getPlaceOfBirth());
            mainInfoDto.setNationality(mainInfo.getNationality());
            mainInfoDto.setCitizenship(mainInfo.getCitizenship());
//            mainInfoDto.setIdentityCardNumber(mainInfo.getIdentityCardNumber());
//            mainInfoDto.setIdentityCardIssued(mainInfo.getIdentityCardIssued());
//            mainInfoDto.setPassportSeries(mainInfo.getPassportSeries());
//            mainInfoDto.setPassportIssued(mainInfo.getPassportIssued());
        } catch (Exception e) {
        }

        return mainInfoDto;
    }

}
