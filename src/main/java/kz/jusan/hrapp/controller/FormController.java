package kz.jusan.hrapp.controller;

import kz.jusan.hrapp.dto.MainInfoDto;
import kz.jusan.hrapp.model.form.MainInfo;
import kz.jusan.hrapp.service.impl.InfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(value = "/form")
@CrossOrigin("*")
public class FormController {

    private final InfoServiceImpl infoService;

    @Autowired
    public FormController(InfoServiceImpl infoService) {
        this.infoService = infoService;
    }

    @PostMapping("/upload/maininfo/{user_id}")
    public HashMap<String, String> uploadFile(@PathVariable("user_id") Long user_id, @RequestBody MainInfoDto mainInfoDto) {
        System.out.println("HI CONTROLLER!");
        HashMap<String, String> answer = new HashMap<>();
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
            infoService.save(mainInfo);
            answer.put("answer", "Main info is uploaded");
        } catch (Exception e) {
            answer.put("answer", "Main info is not uploaded");
        }

        return answer;
    }

}
