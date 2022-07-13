package kz.jusan.hrapp.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import kz.jusan.hrapp.dto.DocumentTypeDto;
import kz.jusan.hrapp.dto.FileDBDto;
import kz.jusan.hrapp.model.FileDB;
import kz.jusan.hrapp.repository.FileDBRepository;
import kz.jusan.hrapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileStorageServiceImpl {

    @Autowired
    private FileDBRepository fileDBRepository;

    @Autowired
    private UserRepository userRepository;

    public FileStorageServiceImpl(FileDBRepository fileDBRepository) {
        this.fileDBRepository = fileDBRepository;
    }

    @Transactional
    public FileDB store(MultipartFile file, Long userId) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        FileDB fileDB = fileDBRepository.findByData(file.getBytes()).orElse(new FileDB());
        fileDB.setName(fileName);
        fileDB.setType(file.getContentType());
        fileDB.setData(file.getBytes());
        fileDB.setUser(userRepository.findById(userId).get());

        return fileDBRepository.save(fileDB);
    }

    public FileDB getFile(String id) {
        return fileDBRepository.findById(id).get();
    }

    @Transactional
    public List<FileDBDto> getFilesByUserId(Long userId){
        List<FileDB> fileDBS = fileDBRepository.findByUserId(userId);
        List<FileDBDto> fileDBDtos = new ArrayList<>();
        for (FileDB fileDB : fileDBS) {
            FileDBDto fileDBDto = new FileDBDto();
            fileDBDto.setId(fileDB.getId());
            fileDBDto.setData(fileDB.getData());
            fileDBDto.setType(fileDB.getType());
            fileDBDto.setName(fileDB.getName());
            fileDBDtos.add(fileDBDto);
        }
        return fileDBDtos;
    }

    public List<FileDB> getAllFiles() {
        return fileDBRepository.findAll();
    }

    public void uploadDocumentType(DocumentTypeDto documentTypeDto){
        FileDB fileDB = fileDBRepository.findById(documentTypeDto.getDocumentId()).orElse(null);
        fileDB.setDocumentType(documentTypeDto.getDocumentType());
        fileDBRepository.save(fileDB);
    }

}