package kz.jusan.hrapp.controller;

import kz.jusan.hrapp.message.ResponseMessage;
import kz.jusan.hrapp.model.form.MainInfo;
import kz.jusan.hrapp.service.impl.InfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(value = "/form/maininfo")
public class FormController {

    private final InfoServiceImpl infoService;

    @Autowired
    public FormController(InfoServiceImpl infoService) {
        this.infoService = infoService;
    }

    @PostMapping("/upload/{user_id}")
    public HashMap<String, String> uploadFile(@PathVariable("user_id") Long user_id, @RequestBody MainInfo mainInfo) {
        HashMap<String, String> answer = new HashMap<>();
        try {
            infoService.save(mainInfo);
            answer.put("answer", "Main info is uploaded");
        } catch (Exception e) {
            answer.put("answer", "Main info is not uploaded");
        }
        return answer;
    }

}
