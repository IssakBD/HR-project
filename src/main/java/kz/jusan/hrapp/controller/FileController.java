package kz.jusan.hrapp.controller;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import kz.jusan.hrapp.dto.DocumentTypeDto;
import kz.jusan.hrapp.message.ResponseMessage;
import kz.jusan.hrapp.model.FileDB;
import kz.jusan.hrapp.model.User;
import kz.jusan.hrapp.model.form.MainInfo;
import kz.jusan.hrapp.service.UserService;
import kz.jusan.hrapp.service.impl.FileStorageServiceImpl;
import kz.jusan.hrapp.service.impl.FormToWordServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
@RequestMapping("/files")
@CrossOrigin("*")
public class FileController {


    private final FileStorageServiceImpl storageService;

    private final FormToWordServiceImpl formToWordService;

    private final UserService userService;

    @Autowired
    public FileController(FileStorageServiceImpl storageService, FormToWordServiceImpl formToWordService, UserService userService) {
        this.storageService = storageService;
        this.formToWordService = formToWordService;
        this.userService = userService;
    }

    @PostMapping("/upload/{userId}")
    public HashMap<String, String> uploadFile(@RequestParam("file") MultipartFile file, @PathVariable("userId") Long userId) {
        HashMap<String, String> answer = new HashMap<>();
        String message = "";
        try {
            FileDB fileDB = storageService.store(file, userId);
            message = (String) fileDB.getId();
            answer.put("fileId", message);
        } catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            answer.put("fileId", message);
            return answer;
        }
        return answer;
    }

    @PostMapping("/upload/document-type")
    public HashMap<String, String> uploadDocumentType(@RequestBody DocumentTypeDto documentTypeDto){
        HashMap<String, String> answer = new HashMap<>();
        try {
            storageService.uploadDocumentType(documentTypeDto);
            answer.put("answer", "ok");
        } catch (Exception e) {
            answer.put("answer", "document Type is not upload");
        }
        return answer;
    }


    @GetMapping("/get/{id}")
    public ResponseEntity<byte[]> getFile(@PathVariable("id") String id) {
        FileDB fileDB = storageService.getFile(id);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileDB.getName() + "\"")
                .body(fileDB.getData());
    }

    @GetMapping("/download/{userId}")
    public HashMap<String, List<FileDB>> getFile(@PathVariable("userId") Long userId) {
        List<FileDB> fileDBs = storageService.getFilesByUserId(userId);
        HashMap<String, List<FileDB>> answer = new HashMap<>();
        answer.put("List of documents for current user: ", fileDBs);
        return answer;
    }

    @PostMapping("/generate/{userId}")
    public HashMap<String, String> generate(@PathVariable("userId") Long userId) {
        HashMap<String, String> result = new HashMap<>();
        List<String> answers = new ArrayList<>();
        User user = userService.findById(userId);
        MainInfo mainInfo = user.getMainInfo();

        answers.add(mainInfo.getIin());
        answers.add(mainInfo.getFIO());
        answers.add(mainInfo.getOldSurname());
        answers.add(mainInfo.getDateOfBirthday());
        answers.add(mainInfo.getNationality());
        answers.add(mainInfo.getCitizenship());
        answers.add(mainInfo.getDocumentSeries());
        answers.add(mainInfo.getDocumentNumber());
        answers.add(mainInfo.getDocumentIssued());


        return result;
    }
}