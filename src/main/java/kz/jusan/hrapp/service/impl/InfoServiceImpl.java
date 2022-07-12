package kz.jusan.hrapp.service.impl;

import kz.jusan.hrapp.dto.*;
import kz.jusan.hrapp.model.User;
import kz.jusan.hrapp.model.form.*;
import kz.jusan.hrapp.repository.*;
import kz.jusan.hrapp.service.UserService;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class InfoServiceImpl {

    private final MainInfoRepository mainInfoRepository;
    private final AdditionalEducationInfoRepository additionalEducationInfoRepository;
    private final AdditionalWorkingInfoRepository additionalWorkingInfoRepository;
    private final ChildrenInfoRepository childrenInfoRepository;
    private final RelativesInfoRepository relativesInfoRepository;
    private final RelativesInJusanRepository relativesInJusanRepository;
    private final UniversityInfoRepository universityInfoRepository;

    private final FormToWordServiceImpl formToWordService;

    private final UserService userService;

    @Autowired
    public InfoServiceImpl(MainInfoRepository mainInfoRepository, AdditionalEducationInfoRepository additionalEducationInfoRepository, AdditionalWorkingInfoRepository additionalWorkingInfoRepository, ChildrenInfoRepository childrenInfoRepository, RelativesInfoRepository relativesInfoRepository, RelativesInJusanRepository relativesInJusanRepository, UniversityInfoRepository universityInfoRepository, UserRepository userRepository, FormToWordServiceImpl formToWordService, UserService userService) {
        this.mainInfoRepository = mainInfoRepository;
        this.additionalEducationInfoRepository = additionalEducationInfoRepository;
        this.additionalWorkingInfoRepository = additionalWorkingInfoRepository;
        this.childrenInfoRepository = childrenInfoRepository;
        this.relativesInfoRepository = relativesInfoRepository;
        this.relativesInJusanRepository = relativesInJusanRepository;
        this.universityInfoRepository = universityInfoRepository;
        this.formToWordService = formToWordService;
        this.userService = userService;
    }

    public void save(MainInfoDto mainInfoDto, Long userId){
        User user = userService.findById(userId);
        MainInfo mainInfo = new MainInfo();
        mainInfo.setIin(mainInfoDto.getIin());
        mainInfo.setFIO(mainInfoDto.getFIO());
        mainInfo.setOldSurname(mainInfoDto.getOldSurname());
        mainInfo.setDateOfBirthday(mainInfoDto.getDateOfBirthday());
        mainInfo.setPlaceOfBirth(mainInfoDto.getPlaceOfBirth());
        mainInfo.setNationality(mainInfoDto.getNationality());
        mainInfo.setCitizenship(mainInfoDto.getCitizenship());
        mainInfo.setDocumentSeries(mainInfoDto.getDocumentSeries());
        mainInfo.setDocumentNumber(mainInfoDto.getDocumentNumber());
        mainInfo.setDocumentIssued(mainInfoDto.getDocumentIssued());
        mainInfo.setHomePhoneNumber(mainInfoDto.getHomePhoneNumber());
        mainInfo.setWorkPhoneNumber(mainInfoDto.getWorkPhoneNumber());
        mainInfo.setMobilePhoneNumber(mainInfoDto.getMobilePhoneNumber());
        mainInfo.setContactPersonFio(mainInfoDto.getContactPersonFio());
        mainInfo.setContactPersonDegreeOfRelationship(mainInfoDto.getContactPersonDegreeOfRelationship());
        mainInfo.setContactPersonPhoneNumber(mainInfoDto.getContactPersonPhoneNumber());
        mainInfo.setEmail(mainInfoDto.getEmail());
        mainInfo.setPermanentRegistrationAddressCity(mainInfoDto.getPermanentRegistrationAddressCity());
        mainInfo.setPermanentRegistrationAddressDistrict(mainInfoDto.getPermanentRegistrationAddressDistrict());
        mainInfo.setPermanentRegistrationAddressRegion(mainInfoDto.getPermanentRegistrationAddressRegion());
        mainInfo.setPermanentRegistrationAddressStreet(mainInfoDto.getPermanentRegistrationAddressStreet());
        mainInfo.setPermanentRegistrationAddressHouseNumber(mainInfoDto.getPermanentRegistrationAddressHouseNumber());
        mainInfo.setPermanentRegistrationAddressCorpus(mainInfoDto.getPermanentRegistrationAddressCorpus());
        mainInfo.setPermanentRegistrationAddressApartment(mainInfoDto.getPermanentRegistrationAddressApartment());
        mainInfo.setActualAddressCity(mainInfoDto.getActualAddressCity());
        mainInfo.setActualAddressDistrict(mainInfoDto.getActualAddressDistrict());
        mainInfo.setActualAddressRegion(mainInfoDto.getActualAddressRegion());
        mainInfo.setActualAddressStreet(mainInfoDto.getActualAddressStreet());
        mainInfo.setActualAddressHouseNumber(mainInfoDto.getActualAddressHouseNumber());
        mainInfo.setActualAddressCorpus(mainInfoDto.getActualAddressCorpus());
        mainInfo.setActualAddressApartment(mainInfoDto.getActualAddressApartment());
        mainInfo.setStartOfWorkingOne(mainInfoDto.getStartOfWorkingOne());
        mainInfo.setEndOfWorkingOne(mainInfoDto.getEndOfWorkingOne());
        mainInfo.setWorkingPlaceInfoOne(mainInfoDto.getWorkingPlaceInfoOne());
        mainInfo.setWorkTypeOne(mainInfoDto.getWorkTypeOne());
        mainInfo.setWorkingPlaceAddressOne(mainInfoDto.getWorkingPlaceAddressOne());
        mainInfo.setWorkingPlacePhoneNumberOne(mainInfoDto.getWorkingPlacePhoneNumberOne());
        mainInfo.setPositionOne(mainInfoDto.getPositionOne());
        mainInfo.setManagerFullNameOne(mainInfoDto.getManagerFullNameOne());
        mainInfo.setManagerPhoneNumberOne(mainInfoDto.getManagerPhoneNumberOne());
        mainInfo.setReasonForDismissalOne(mainInfoDto.getReasonForDismissalOne());
        mainInfo.setStartOfWorkingTwo(mainInfoDto.getStartOfWorkingTwo());
        mainInfo.setEndOfWorkingTwo(mainInfoDto.getEndOfWorkingTwo());
        mainInfo.setWorkingPlaceInfoTwo(mainInfoDto.getWorkingPlaceInfoTwo());
        mainInfo.setWorkTypeTwo(mainInfoDto.getWorkTypeTwo());
        mainInfo.setWorkingPlaceAddressTwo(mainInfoDto.getWorkingPlaceAddressTwo());
        mainInfo.setWorkingPlacePhoneNumberTwo(mainInfoDto.getWorkingPlacePhoneNumberTwo());
        mainInfo.setPositionTwo(mainInfoDto.getPositionTwo());
        mainInfo.setManagerFullNameTwo(mainInfoDto.getManagerFullNameTwo());
        mainInfo.setManagerPhoneNumberTwo(mainInfoDto.getManagerPhoneNumberTwo());
        mainInfo.setReasonForDismissalTwo(mainInfoDto.getReasonForDismissalTwo());
        mainInfo.setStartOfWorkingThree(mainInfoDto.getStartOfWorkingThree());
        mainInfo.setEndOfWorkingThree(mainInfoDto.getEndOfWorkingThree());
        mainInfo.setWorkingPlaceNameThree(mainInfoDto.getWorkingPlaceNameThree());
        mainInfo.setWorkTypeThree(mainInfoDto.getWorkTypeThree());
        mainInfo.setWorkingPlaceAddressThree(mainInfoDto.getWorkingPlaceAddressThree());
        mainInfo.setWorkingPlacePhoneNumberThree(mainInfoDto.getWorkingPlacePhoneNumberThree());
        mainInfo.setPositionThree(mainInfoDto.getPositionThree());
        mainInfo.setManagerFullNameThree(mainInfoDto.getManagerFullNameThree());
        mainInfo.setManagerPhoneNumberThree(mainInfoDto.getManagerPhoneNumberThree());
        mainInfo.setReasonForDismissalThree(mainInfoDto.getReasonForDismissalThree());
        mainInfo.setProfRefFullName1(mainInfoDto.getProfRefFullName1());
        mainInfo.setProfRefWorkPlace1(mainInfoDto.getProfRefWorkPlace1());
        mainInfo.setProfRefWorkPosition1(mainInfoDto.getProfRefWorkPosition1());
        mainInfo.setProfRefTel1(mainInfoDto.getProfRefTel1());
        mainInfo.setProfRefFullName2(mainInfoDto.getProfRefFullName2());
        mainInfo.setProfRefWorkPlace2(mainInfoDto.getProfRefWorkPlace2());
        mainInfo.setProfRefWorkPosition2(mainInfoDto.getProfRefWorkPosition2());
        mainInfo.setProfRefTel2(mainInfoDto.getProfRefTel2());
        mainInfo.setProfRefFullName3(mainInfoDto.getProfRefFullName3());
        mainInfo.setProfRefWorkPlace3(mainInfoDto.getProfRefWorkPlace3());
        mainInfo.setProfRefWorkPosition3(mainInfoDto.getProfRefWorkPosition3());
        mainInfo.setProfRefTel3(mainInfoDto.getProfRefTel3());
        mainInfo.setMaritalStatus(mainInfoDto.getMaritalStatus());
        mainInfo.setSpouseFIO(mainInfoDto.getSpouseFIO());
        mainInfo.setSpouseWorkingInfo(mainInfoDto.getSpouseWorkingInfo());
        mainInfo.setSpouseWorkingPosition(mainInfoDto.getSpouseWorkingPosition());
        mainInfo.setSpouseAddress(mainInfoDto.getSpouseAddress());
        mainInfo.setSpouseCitizenship(mainInfoDto.getSpouseCitizenship());
        mainInfo.setSpouseContacts(mainInfoDto.getSpouseContacts());
        mainInfo.setCarModel(mainInfoDto.getCarModel());
        mainInfo.setCarYearOfManufacture(mainInfoDto.getCarYearOfManufacture());
        mainInfo.setCarNumber(mainInfoDto.getCarNumber());
        mainInfo.setMilitaryStatus(mainInfoDto.getMilitaryStatus());
        mainInfo.setBenefitsStatus(mainInfoDto.getBenefitsStatus());
        mainInfo.setOverdueLoanStatus(mainInfoDto.getOverdueLoanStatus());
        mainInfo.setOverdueLoanReason(mainInfoDto.getOverdueLoanReason());
        mainInfo.setCriminalLiabilityStatus(mainInfoDto.getCriminalLiabilityStatus());
        mainInfo.setCriminalLiabilityReason(mainInfoDto.getCriminalLiabilityReason());
        mainInfo.setRelativesCriminalCaseStatus(mainInfoDto.getRelativesCriminalCaseStatus());
        mainInfo.setRelativesCriminalCaseReason(mainInfoDto.getRelativesCriminalCaseReason());
        mainInfo.setCriminalCaseStatus(mainInfoDto.getCriminalCaseStatus());
        mainInfo.setCriminalCaseReason(mainInfoDto.getCriminalCaseReason());
        mainInfo.setAlimonyStatus(mainInfoDto.getAlimonyStatus());
        mainInfo.setAlimonyReason(mainInfoDto.getAlimonyReason());
        mainInfo.setAdministrativeLiabilityStatus(mainInfoDto.getAdministrativeLiabilityStatus());
        mainInfo.setAdministrativeLiabilityReason(mainInfoDto.getAdministrativeLiabilityReason());
        mainInfo.setAdditionalInformation(mainInfoDto.getAdditionalInformation());
        mainInfo.setAdditionalIncome(mainInfoDto.getAdditionalIncome());
        mainInfo.setDateOfFillingIn(mainInfoDto.getDateOfFillingIn());
        mainInfo.setUser(user);
        mainInfoRepository.save(mainInfo);

        List<UniversityInfoDto> universityInfoDtos = mainInfoDto.getUniversityInfoDtos();
        for (UniversityInfoDto info : universityInfoDtos) {
            UniversityInfo universityInfo = new UniversityInfo();
            universityInfo.setStartDateOfEducation(info.getStartDateOfEducation());
            universityInfo.setEndDateOfEducation(info.getEndDateOfEducation());
            universityInfo.setNameOfInstitution(info.getNameOfInstitution());
            universityInfo.setSpeciality(info.getSpeciality());
            universityInfo.setFormOfStudy(info.getFormOfStudy());
            universityInfo.setQualification(info.getQualification());
            universityInfo.setUser(user);
            universityInfoRepository.save(universityInfo);
        }

        List<AdditionalEducationInfoDto> additionalEducationInfoDtoList = mainInfoDto.getAdditionalEducationInfoDtos();
        for (AdditionalEducationInfoDto info : additionalEducationInfoDtoList) {
            AdditionalEducationInfo additionalEducationInfo = new AdditionalEducationInfo();
            additionalEducationInfo.setYearOfGraduation(info.getYearOfGraduation());
            additionalEducationInfo.setDurationOfTraining(info.getDurationOfTraining());
            additionalEducationInfo.setNameOfCourse(info.getNameOfCourse());
            additionalEducationInfo.setSpeciality(info.getSpeciality());
            additionalEducationInfo.setAcademicDegreeOrCertificates(info.getAcademicDegreeOrCertificates());
            additionalEducationInfo.setUser(user);
            additionalEducationInfoRepository.save(additionalEducationInfo);
        }

        List<ChildrenInfoDto> childrenInfoDtos = mainInfoDto.getChildrenInfoDtos();
        for (ChildrenInfoDto info : childrenInfoDtos) {
            ChildrenInfo childrenInfo = new ChildrenInfo();
            childrenInfo.setFIO(info.getFIO());
            childrenInfo.setDateOfBirthday(info.getDateOfBirthday());
            childrenInfo.setPhoneNumber(info.getPhoneNumber());
            childrenInfo.setWorkPlace(info.getWorkPlace());
            childrenInfo.setUser(user);
            childrenInfoRepository.save(childrenInfo);
        }

        List<RelativesInfoDto> relativesInfoDtos = mainInfoDto.getRelativesInfoDtos();
        for (RelativesInfoDto info : relativesInfoDtos) {
            RelativesInfo relativesInfo = new RelativesInfo();
            relativesInfo.setDegreeOfRelationship(info.getDegreeOfRelationship());
            relativesInfo.setFIO(info.getFIO());
            relativesInfo.setDateOfBirthday(info.getDateOfBirthday());
            relativesInfo.setWorkingPlace(info.getWorkingPlace());
            relativesInfo.setWorkingPosition(info.getWorkingPosition());
            relativesInfo.setAddress(info.getAddress());
            relativesInfo.setPhoneNumber(info.getPhoneNumber());
            relativesInfo.setUser(user);
            relativesInfoRepository.save(relativesInfo);
        }

        List<AdditionalWorkingInfoDto> additionalWorkingInfoDtos = mainInfoDto.getAdditionalWorkingInfoDtos();
        for (AdditionalWorkingInfoDto info : additionalWorkingInfoDtos) {
            AdditionalWorkingInfo additionalWorkingInfo = new AdditionalWorkingInfo();
            additionalWorkingInfo.setName(info.getName());
            additionalWorkingInfo.setInn(info.getInn());
            additionalWorkingInfo.setAddress(info.getAddress());
            additionalWorkingInfo.setTypeOfWork(info.getTypeOfWork());
            additionalWorkingInfo.setPhoneNumber(info.getPhoneNumber());
            additionalWorkingInfo.setUser(user);
            additionalWorkingInfoRepository.save(additionalWorkingInfo);
        }


        List<RelativesInJusanDto> relativesInJusanDtos = mainInfoDto.getRelativesInJusanDtos();
        for (RelativesInJusanDto info : relativesInJusanDtos) {
            RelativesInJusan relativesInJusan = new RelativesInJusan();
            relativesInJusan.setDegreeOfRelationship(info.getDegreeOfRelationship());
            relativesInJusan.setFIO(info.getFIO());
            relativesInJusan.setDepartmentAndPosition(info.getDepartmentAndPosition());
            relativesInJusan.setUser(user);
            relativesInJusanRepository.save(relativesInJusan);
        }

//        try {
//            formToWordService.updateDocument(new ArrayList<>());
//        } catch (InvalidFormatException | IOException e) {
//            throw new RuntimeException(e);
//        }

    }
    public Optional<MainInfo> findById(Long user_id) {
        return mainInfoRepository.findById(user_id);
    }
}
