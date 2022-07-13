package kz.jusan.hrapp.controller;


import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import io.swagger.v3.oas.annotations.tags.Tag;
import kz.jusan.hrapp.message.ResponseFile;
import kz.jusan.hrapp.message.ResponseMessage;
import kz.jusan.hrapp.model.FileDB;
import kz.jusan.hrapp.service.impl.FileStorageServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
@Slf4j
@Tag(name = "Files")
@RestController
@RequestMapping("/files")
@CrossOrigin("*")
public class FileController {

    @Autowired
    private FileStorageServiceImpl storageService;

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
}