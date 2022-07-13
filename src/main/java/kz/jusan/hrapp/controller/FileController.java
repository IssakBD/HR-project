package kz.jusan.hrapp.controller;


import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kz.jusan.hrapp.dto.DocumentTypeDto;
import kz.jusan.hrapp.dto.FileDBDto;
import kz.jusan.hrapp.message.ResponseMessage;
import kz.jusan.hrapp.model.FileDB;
import kz.jusan.hrapp.model.User;
import kz.jusan.hrapp.model.form.MainInfo;
import kz.jusan.hrapp.model.form.UniversityInfo;
import kz.jusan.hrapp.service.UserService;
import kz.jusan.hrapp.service.impl.FileStorageServiceImpl;
import kz.jusan.hrapp.service.impl.FormToWordServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
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
    public List<FileDBDto> getFile(@PathVariable("userId") Long userId) {
        List<FileDBDto> fileDBDtos = storageService.getFilesByUserId(userId);
        return fileDBDtos;
    }

    @PostMapping("/generate/{userId}")
    public HashMap<String, String> generate(@PathVariable("userId") Long userId) {
        HashMap<String, String> result = new HashMap<>();

        HashMap<String, String> replaceMaps = new HashMap<>();
        List<String> answers = new ArrayList<>();
        User user = userService.findById(userId);
        MainInfo mainInfo = user.getMainInfo();
        List<UniversityInfo> universityInfos = user.getUniversityInfos();
        replaceMaps.put("IIN", mainInfo.getIin());
        replaceMaps.put("FIO", mainInfo.getFIO());
        replaceMaps.put("OLDNAME", mainInfo.getOldSurname());
        replaceMaps.put("BIRTHDAY", mainInfo.getDateOfBirthday());
        replaceMaps.put("BIRTHPLACE", mainInfo.getPlaceOfBirth());
        replaceMaps.put("ETHNICITY", mainInfo.getNationality());
        replaceMaps.put("CITIZENSHIP", mainInfo.getCitizenship());
        replaceMaps.put("SERIAL", mainInfo.getDocumentSeries());
        replaceMaps.put("IDNUM", mainInfo.getDocumentNumber());
        replaceMaps.put("ISSUED", mainInfo.getDocumentIssued());
        replaceMaps.put("HOMETEL", mainInfo.getHomePhoneNumber());
        replaceMaps.put("WORKTEL", mainInfo.getWorkPhoneNumber());
        replaceMaps.put("MOBILETEL", mainInfo.getMobilePhoneNumber());
        replaceMaps.put("REFPERSON", mainInfo.getContactPersonFio() + ", " + mainInfo.getContactPersonDegreeOfRelationship() + ", " + mainInfo.getContactPersonPhoneNumber());
        replaceMaps.put("EMAIL", mainInfo.getEmail());
        replaceMaps.put("CONSTCITY", mainInfo.getPermanentRegistrationAddressCity());
        replaceMaps.put("CONSTREGION", mainInfo.getPermanentRegistrationAddressRegion());
        replaceMaps.put("CONSTDISTRICT", mainInfo.getPermanentRegistrationAddressDistrict());
        replaceMaps.put("CONSTSTREET", mainInfo.getPermanentRegistrationAddressStreet());
        replaceMaps.put("CONSTHOMENUM", mainInfo.getPermanentRegistrationAddressHouseNumber());
        replaceMaps.put("CONSTHOMEBLOCK", mainInfo.getPermanentRegistrationAddressCorpus());
        replaceMaps.put("CONSTAPT", mainInfo.getPermanentRegistrationAddressApartment());
        replaceMaps.put("CURRENTCITY", mainInfo.getActualAddressCity());
        replaceMaps.put("CURRENTREGION", mainInfo.getActualAddressRegion());
        replaceMaps.put("CURRENTDISTRICT  ", mainInfo.getActualAddressDistrict());
        replaceMaps.put("CURRENTSTREET", mainInfo.getActualAddressStreet());
        replaceMaps.put("CURRENTHOMENUM ", mainInfo.getActualAddressHouseNumber());
        replaceMaps.put("CURRENTBLOCK", mainInfo.getActualAddressCorpus());
        replaceMaps.put("CURRENTAPT", mainInfo.getActualAddressApartment());

        for (UniversityInfo universityInfo : universityInfos) {
            replaceMaps.put("EDUSTART1", universityInfo.getStartDateOfEducation());
            replaceMaps.put("EDUEND1", universityInfo.getEndDateOfEducation());
            replaceMaps.put("EDUNAME1", universityInfo.getNameOfInstitution());
        }

        replaceMaps.put("PREVSTART1", mainInfo.getStartOfWorkingOne());
        replaceMaps.put("PREVEND1", mainInfo.getEndOfWorkingOne());
        replaceMaps.put("PREVNAME1", mainInfo.getWorkingPlaceInfoOne());
        replaceMaps.put("PREVTYPE1", mainInfo.getWorkTypeOne());
        replaceMaps.put("PREVADDRESS1", mainInfo.getWorkingPlaceAddressOne());
        replaceMaps.put("PREVTEL1", mainInfo.getWorkingPlacePhoneNumberOne());
        replaceMaps.put("PREVPOS1", mainInfo.getPositionOne());
        replaceMaps.put("PREVRUKNAME1", mainInfo.getManagerFullNameOne());
        replaceMaps.put("PREVRUKTEL1", mainInfo.getManagerPhoneNumberOne());
        replaceMaps.put("PREVREASON1", mainInfo.getReasonForDismissalOne());
        replaceMaps.put("PREVSTART2", mainInfo.getStartOfWorkingTwo());
        replaceMaps.put("PREVEND2", mainInfo.getEndOfWorkingTwo());
        replaceMaps.put("PREVNAME2", mainInfo.getWorkingPlaceInfoTwo());
        replaceMaps.put("PREVTYPE2", mainInfo.getWorkTypeTwo());
        replaceMaps.put("PREVADDRESS2", mainInfo.getWorkingPlaceAddressTwo());
        replaceMaps.put("PREVTEL2", mainInfo.getWorkingPlacePhoneNumberTwo());
        replaceMaps.put("PREVPOS2", mainInfo.getPositionTwo());
        replaceMaps.put("PREVRUKNAME2", mainInfo.getManagerFullNameTwo());
        replaceMaps.put("PREVRUKTEL2", mainInfo.getManagerPhoneNumberTwo());
        replaceMaps.put("PREVREASON2", mainInfo.getReasonForDismissalTwo());
        replaceMaps.put("PREVSTART3", mainInfo.getStartOfWorkingThree());
        replaceMaps.put("PREVEND3", mainInfo.getEndOfWorkingThree());
        replaceMaps.put("PREVNAME3", mainInfo.getWorkingPlaceNameThree());
        replaceMaps.put("PREVTYPE3", mainInfo.getWorkTypeThree());
        replaceMaps.put("PREVADDRESS3", mainInfo.getWorkingPlaceAddressThree());
        replaceMaps.put("PREVTEL3", mainInfo.getWorkingPlacePhoneNumberThree());
        replaceMaps.put("PREVPOS3", mainInfo.getPositionThree());
        replaceMaps.put("PREVRUKNAME3", mainInfo.getManagerFullNameThree());
        replaceMaps.put("PREVRUKTEL3", mainInfo.getManagerPhoneNumberThree());
        replaceMaps.put("PREVREASON3", mainInfo.getReasonForDismissalThree());
        replaceMaps.put("PROFREF1", mainInfo.getProfRefFullName1());
        replaceMaps.put("PROFREFNAME1", mainInfo.getProfRefWorkPlace1());
        replaceMaps.put("PROFREFPOS1", mainInfo.getProfRefWorkPosition1());
        replaceMaps.put("PROFREFTEL1", mainInfo.getProfRefTel1());
        replaceMaps.put("PROFREF2", mainInfo.getProfRefFullName2());
        replaceMaps.put("PROFREFNAME2", mainInfo.getProfRefWorkPlace2());
        replaceMaps.put("PROFREFPOS2", mainInfo.getProfRefWorkPosition2());
        replaceMaps.put("PROFREFTEL2", mainInfo.getProfRefTel2());
        replaceMaps.put("PROFREF3", mainInfo.getProfRefFullName3());
        replaceMaps.put("PROFREFNAME3", mainInfo.getProfRefWorkPlace3());
        replaceMaps.put("PROFREFPOS3", mainInfo.getProfRefWorkPosition3());
        replaceMaps.put("PROFREFTEL3", mainInfo.getProfRefTel3());
        replaceMaps.put("MARITALSTATUS", mainInfo.getMaritalStatus());
        replaceMaps.put("SPOUSENAME", mainInfo.getSpouseFIO());
        replaceMaps.put("SPOUSEBIRTH", mainInfo.getSpouseDateOfBirthday());
        replaceMaps.put("SPOUSEJOB", mainInfo.getSpouseWorkingInfo());
        replaceMaps.put("SPOUSEPOS", mainInfo.getSpouseWorkingPosition());
        replaceMaps.put("SPOSEAD", mainInfo.getSpouseAddress());
        replaceMaps.put("SPOUSECZ", mainInfo.getSpouseCitizenship());
        replaceMaps.put("SPOUSECONTACTS", mainInfo.getSpouseContacts());
        replaceMaps.put("CARMODEL", mainInfo.getCarModel());
        replaceMaps.put("CARYEAR", mainInfo.getCarYearOfManufacture());
        replaceMaps.put("CARID", mainInfo.getCarNumber());
        replaceMaps.put("MILITARYTYPE", mainInfo.getMilitaryStatus());
        replaceMaps.put("BENEFITSDETAILS", mainInfo.getBenefitsStatus());
        replaceMaps.put("OVERSTATUS", mainInfo.getOverdueLoanStatus());
        replaceMaps.put("OVERDUEREASON", mainInfo.getOverdueLoanReason());
        replaceMaps.put("CRIMELISTATUS", mainInfo.getCriminalLiabilityStatus());
        replaceMaps.put("CRIMELIREASON", mainInfo.getCriminalLiabilityReason());
        replaceMaps.put("RELSTATUS", mainInfo.getRelativesCriminalCaseStatus());
        replaceMaps.put("RELREASON", mainInfo.getRelativesCriminalCaseReason());
        replaceMaps.put("CRIMECASESTATUS", mainInfo.getCriminalCaseStatus());
        replaceMaps.put("CRIMECASEREASON", mainInfo.getCriminalCaseReason());
        replaceMaps.put("ALIMONYSTATUS", mainInfo.getAlimonyStatus());
        replaceMaps.put("ALIMONYREASON", mainInfo.getAlimonyReason());
        replaceMaps.put("ADMINSTATUS", mainInfo.getAdministrativeLiabilityStatus());
        replaceMaps.put("ADMINREASON", mainInfo.getAdministrativeLiabilityReason());
        replaceMaps.put("ADDITIONALINFO", mainInfo.getAdditionalInformation());
        replaceMaps.put("SIDEJOB", mainInfo.getAdditionalIncome());
        replaceMaps.put("DATE", mainInfo.getDateOfFillingIn());



        XWPFDocument doc = null; //CHANGE PATH FOR THE ACTUAL ONE
        try {
            doc = new XWPFDocument(OPCPackage.open("src/main/resources/templates/forms.docx"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InvalidFormatException e) {
            throw new RuntimeException(e);
        }

        for(Map.Entry<String, String> entry : replaceMaps.entrySet()){
            try {
                formToWordService.updateDocument(entry.getKey(), entry.getValue(), doc);
            } catch (InvalidFormatException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        try {
            doc.write(new FileOutputStream("/home/administrator/Downloads/output.docx"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return result;
    }
}