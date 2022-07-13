package kz.jusan.hrapp.controller;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file, @PathVariable("userId") Long userId, @RequestParam("documentType") String documentType) {
        String message = "";
        try {
            storageService.store(file, userId, documentType);

            message = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

//    @GetMapping
//    public ResponseEntity<List<FileDB>> getListFiles() {
//        List<FileDB> files = storageService.getAllFiles();
//        log.debug(files.toString() + " - files");
//        files.stream()
//                .map(dbFile -> {
//                    String fileDownloadUri = ServletUriComponentsBuilder
//                            .fromCurrentContextPath()
//                            .path("/files/")
//                            .path(dbFile.getId())
//                            .toUriString();
//
//                    return new ResponseFile(
//                            dbFile.getName(),
//                            fileDownloadUri,
//                            dbFile.getType(),
//                            dbFile.getData().length);
//                }).collect(Collectors.toList());
//
//        return ResponseEntity.status(HttpStatus.OK).body(files);
//    }


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