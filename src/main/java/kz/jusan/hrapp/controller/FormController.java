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
@RequestMapping( "/form")
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
            answer.put("sizeOfUniversityList", String.valueOf(mainInfoDto.getUniversityInfoDtos().size()));
        } catch (Exception e) {
            answer.put("answer", "Main info is not uploaded " + e.getMessage());
        }

        return answer;
    }
    @GetMapping("/download/info/{user_id}")
    public MainInfoDto downloadMainInfo(@PathVariable("user_id") Long user_id) {
        MainInfoDto mainInfoDto = new MainInfoDto();
        try {
             mainInfoDto = infoService.downloadMainInfo(user_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mainInfoDto;
    }

}
