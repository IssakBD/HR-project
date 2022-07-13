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



    private final UserService userService;

    @Autowired
    public InfoServiceImpl(MainInfoRepository mainInfoRepository, AdditionalEducationInfoRepository additionalEducationInfoRepository, AdditionalWorkingInfoRepository additionalWorkingInfoRepository, ChildrenInfoRepository childrenInfoRepository, RelativesInfoRepository relativesInfoRepository, RelativesInJusanRepository relativesInJusanRepository, UniversityInfoRepository universityInfoRepository, UserRepository userRepository, UserService userService) {
        this.mainInfoRepository = mainInfoRepository;
        this.additionalEducationInfoRepository = additionalEducationInfoRepository;
        this.additionalWorkingInfoRepository = additionalWorkingInfoRepository;
        this.childrenInfoRepository = childrenInfoRepository;
        this.relativesInfoRepository = relativesInfoRepository;
        this.relativesInJusanRepository = relativesInJusanRepository;
        this.universityInfoRepository = universityInfoRepository;
        this.userService = userService;
    }

    public void save(MainInfoDto mainInfoDto, Long userId){
        User user = userService.findById(userId);
        MainInfo mainInfo = mainInfoRepository.findByUserId(userId).orElse(new MainInfo());
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
        mainInfo.setSpouseDateOfBirthday(mainInfoDto.getSpouseDateOfBirthday());
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
    public Optional<MainInfo> findByUserId(Long user_id) {
        return mainInfoRepository.findByUserId(user_id);
    }

    public MainInfoDto downloadMainInfo(Long userId){
         System.out.println("In service InfoServiceImpl");

         MainInfo mainInfo = mainInfoRepository.findByUserId(userId).orElse(null);

         MainInfoDto mainInfoDto = new MainInfoDto();

        if(mainInfo != null){
            mainInfoDto.setIin(mainInfo.getIin());
            mainInfoDto.setFIO(mainInfo.getFIO());
            mainInfoDto.setOldSurname(mainInfo.getOldSurname());
            mainInfoDto.setDateOfBirthday(mainInfo.getDateOfBirthday());
            mainInfoDto.setPlaceOfBirth(mainInfo.getPlaceOfBirth());
            mainInfoDto.setNationality(mainInfo.getNationality());
            mainInfoDto.setCitizenship(mainInfo.getCitizenship());
            mainInfoDto.setDocumentSeries(mainInfo.getDocumentSeries());
            mainInfoDto.setDocumentNumber(mainInfo.getDocumentNumber());
            mainInfoDto.setDocumentIssued(mainInfo.getDocumentIssued());
            mainInfoDto.setHomePhoneNumber(mainInfo.getHomePhoneNumber());
            mainInfoDto.setWorkPhoneNumber(mainInfo.getWorkPhoneNumber());
            mainInfoDto.setMobilePhoneNumber(mainInfo.getMobilePhoneNumber());
            mainInfoDto.setContactPersonFio(mainInfo.getContactPersonFio());
            mainInfoDto.setContactPersonDegreeOfRelationship(mainInfo.getContactPersonDegreeOfRelationship());
            mainInfoDto.setContactPersonPhoneNumber(mainInfo.getContactPersonPhoneNumber());
            mainInfoDto.setEmail(mainInfo.getEmail());
            mainInfoDto.setPermanentRegistrationAddressCity(mainInfo.getPermanentRegistrationAddressCity());
            mainInfoDto.setPermanentRegistrationAddressDistrict(mainInfo.getPermanentRegistrationAddressDistrict());
            mainInfoDto.setPermanentRegistrationAddressRegion(mainInfo.getPermanentRegistrationAddressRegion());
            mainInfoDto.setPermanentRegistrationAddressStreet(mainInfo.getPermanentRegistrationAddressStreet());
            mainInfoDto.setPermanentRegistrationAddressHouseNumber(mainInfo.getPermanentRegistrationAddressHouseNumber());
            mainInfoDto.setPermanentRegistrationAddressCorpus(mainInfo.getPermanentRegistrationAddressCorpus());
            mainInfoDto.setPermanentRegistrationAddressApartment(mainInfo.getPermanentRegistrationAddressApartment());
            mainInfoDto.setActualAddressCity(mainInfo.getActualAddressCity());
            mainInfoDto.setActualAddressDistrict(mainInfo.getActualAddressDistrict());
            mainInfoDto.setActualAddressRegion(mainInfo.getActualAddressRegion());
            mainInfoDto.setActualAddressStreet(mainInfo.getActualAddressStreet());
            mainInfoDto.setActualAddressHouseNumber(mainInfo.getActualAddressHouseNumber());
            mainInfoDto.setActualAddressCorpus(mainInfo.getActualAddressCorpus());
            mainInfoDto.setActualAddressApartment(mainInfo.getActualAddressApartment());
            mainInfoDto.setStartOfWorkingOne(mainInfo.getStartOfWorkingOne());
            mainInfoDto.setEndOfWorkingOne(mainInfo.getEndOfWorkingOne());
            mainInfoDto.setWorkingPlaceInfoOne(mainInfo.getWorkingPlaceInfoOne());
            mainInfoDto.setWorkTypeOne(mainInfo.getWorkTypeOne());
            mainInfoDto.setWorkingPlaceAddressOne(mainInfo.getWorkingPlaceAddressOne());
            mainInfoDto.setWorkingPlacePhoneNumberOne(mainInfo.getWorkingPlacePhoneNumberOne());
            mainInfoDto.setPositionOne(mainInfo.getPositionOne());
            mainInfoDto.setManagerFullNameOne(mainInfo.getManagerFullNameOne());
            mainInfoDto.setManagerPhoneNumberOne(mainInfo.getManagerPhoneNumberOne());
            mainInfoDto.setReasonForDismissalOne(mainInfo.getReasonForDismissalOne());
            mainInfoDto.setStartOfWorkingTwo(mainInfo.getStartOfWorkingTwo());
            mainInfoDto.setEndOfWorkingTwo(mainInfo.getEndOfWorkingTwo());
            mainInfoDto.setWorkingPlaceInfoTwo(mainInfo.getWorkingPlaceInfoTwo());
            mainInfoDto.setWorkTypeTwo(mainInfo.getWorkTypeTwo());
            mainInfoDto.setWorkingPlaceAddressTwo(mainInfo.getWorkingPlaceAddressTwo());
            mainInfoDto.setWorkingPlacePhoneNumberTwo(mainInfo.getWorkingPlacePhoneNumberTwo());
            mainInfoDto.setPositionTwo(mainInfo.getPositionTwo());
            mainInfoDto.setManagerFullNameTwo(mainInfo.getManagerFullNameTwo());
            mainInfoDto.setManagerPhoneNumberTwo(mainInfo.getManagerPhoneNumberTwo());
            mainInfoDto.setReasonForDismissalTwo(mainInfo.getReasonForDismissalTwo());
            mainInfoDto.setStartOfWorkingThree(mainInfo.getStartOfWorkingThree());
            mainInfoDto.setEndOfWorkingThree(mainInfo.getEndOfWorkingThree());
            mainInfoDto.setWorkingPlaceNameThree(mainInfo.getWorkingPlaceNameThree());
            mainInfoDto.setWorkTypeThree(mainInfo.getWorkTypeThree());
            mainInfoDto.setWorkingPlaceAddressThree(mainInfo.getWorkingPlaceAddressThree());
            mainInfoDto.setWorkingPlacePhoneNumberThree(mainInfo.getWorkingPlacePhoneNumberThree());
            mainInfoDto.setPositionThree(mainInfo.getPositionThree());
            mainInfoDto.setManagerFullNameThree(mainInfo.getManagerFullNameThree());
            mainInfoDto.setManagerPhoneNumberThree(mainInfo.getManagerPhoneNumberThree());
            mainInfoDto.setReasonForDismissalThree(mainInfo.getReasonForDismissalThree());
            mainInfoDto.setProfRefFullName1(mainInfo.getProfRefFullName1());
            mainInfoDto.setProfRefWorkPlace1(mainInfo.getProfRefWorkPlace1());
            mainInfoDto.setProfRefWorkPosition1(mainInfo.getProfRefWorkPosition1());
            mainInfoDto.setProfRefTel1(mainInfo.getProfRefTel1());
            mainInfoDto.setProfRefFullName2(mainInfo.getProfRefFullName2());
            mainInfoDto.setProfRefWorkPlace2(mainInfo.getProfRefWorkPlace2());
            mainInfoDto.setProfRefWorkPosition2(mainInfo.getProfRefWorkPosition2());
            mainInfoDto.setProfRefTel2(mainInfo.getProfRefTel2());
            mainInfoDto.setProfRefFullName3(mainInfo.getProfRefFullName3());
            mainInfoDto.setProfRefWorkPlace3(mainInfo.getProfRefWorkPlace3());
            mainInfoDto.setProfRefWorkPosition3(mainInfo.getProfRefWorkPosition3());
            mainInfoDto.setProfRefTel3(mainInfo.getProfRefTel3());
            mainInfoDto.setMaritalStatus(mainInfo.getMaritalStatus());
            mainInfoDto.setSpouseFIO(mainInfo.getSpouseFIO());
            mainInfoDto.setSpouseDateOfBirthday(mainInfo.getSpouseDateOfBirthday());
            mainInfoDto.setSpouseWorkingInfo(mainInfo.getSpouseWorkingInfo());
            mainInfoDto.setSpouseWorkingPosition(mainInfo.getSpouseWorkingPosition());
            mainInfoDto.setSpouseAddress(mainInfo.getSpouseAddress());
            mainInfoDto.setSpouseCitizenship(mainInfo.getSpouseCitizenship());
            mainInfoDto.setSpouseContacts(mainInfo.getSpouseContacts());
            mainInfoDto.setCarModel(mainInfo.getCarModel());
            mainInfoDto.setCarYearOfManufacture(mainInfo.getCarYearOfManufacture());
            mainInfoDto.setCarNumber(mainInfo.getCarNumber());
            mainInfoDto.setMilitaryStatus(mainInfo.getMilitaryStatus());
            mainInfoDto.setBenefitsStatus(mainInfo.getBenefitsStatus());
            mainInfoDto.setOverdueLoanStatus(mainInfo.getOverdueLoanStatus());
            mainInfoDto.setOverdueLoanReason(mainInfo.getOverdueLoanReason());
            mainInfoDto.setCriminalLiabilityStatus(mainInfo.getCriminalLiabilityStatus());
            mainInfoDto.setCriminalLiabilityReason(mainInfo.getCriminalLiabilityReason());
            mainInfoDto.setRelativesCriminalCaseStatus(mainInfo.getRelativesCriminalCaseStatus());
            mainInfoDto.setRelativesCriminalCaseReason(mainInfo.getRelativesCriminalCaseReason());
            mainInfoDto.setCriminalCaseStatus(mainInfo.getCriminalCaseStatus());
            mainInfoDto.setCriminalCaseReason(mainInfo.getCriminalCaseReason());
            mainInfoDto.setAlimonyStatus(mainInfo.getAlimonyStatus());
            mainInfoDto.setAlimonyReason(mainInfo.getAlimonyReason());
            mainInfoDto.setAdministrativeLiabilityStatus(mainInfo.getAdministrativeLiabilityStatus());
            mainInfoDto.setAdministrativeLiabilityReason(mainInfo.getAdministrativeLiabilityReason());
            mainInfoDto.setAdditionalInformation(mainInfo.getAdditionalInformation());
            mainInfoDto.setAdditionalIncome(mainInfo.getAdditionalIncome());
            mainInfoDto.setDateOfFillingIn(mainInfo.getDateOfFillingIn());

            List<UniversityInfo> universityInfos = universityInfoRepository.findByUserId(userId);
            List<UniversityInfoDto> universityInfoDtos = new ArrayList<>();
            for (UniversityInfo universityInfo : universityInfos) {
                UniversityInfoDto universityInfoDto = new UniversityInfoDto();
                universityInfoDto.setStartDateOfEducation(universityInfo.getStartDateOfEducation());
                universityInfoDto.setEndDateOfEducation(universityInfo.getEndDateOfEducation());
                universityInfoDto.setNameOfInstitution(universityInfo.getNameOfInstitution());
                universityInfoDto.setSpeciality(universityInfo.getSpeciality());
                universityInfoDto.setFormOfStudy(universityInfo.getFormOfStudy());
                universityInfoDto.setQualification(universityInfo.getQualification());
                universityInfoDtos.add(universityInfoDto);
            }
            mainInfoDto.setUniversityInfoDtos(universityInfoDtos);


            List<AdditionalEducationInfo> additionalEducationInfos = additionalEducationInfoRepository.findByUserId(userId);
            List<AdditionalEducationInfoDto> additionalEducationInfoDtos = new ArrayList<>();
            for (AdditionalEducationInfo info : additionalEducationInfos) {
                AdditionalEducationInfoDto additionalEducationInfoDto = new AdditionalEducationInfoDto();
                additionalEducationInfoDto.setDurationOfTraining(info.getDurationOfTraining());
                additionalEducationInfoDto.setYearOfGraduation(info.getYearOfGraduation());
                additionalEducationInfoDto.setNameOfCourse(info.getNameOfCourse());
                additionalEducationInfoDto.setSpeciality(info.getSpeciality());
                additionalEducationInfoDto.setYearOfGraduation(info.getYearOfGraduation());
                additionalEducationInfoDto.setAcademicDegreeOrCertificates(info.getAcademicDegreeOrCertificates());
                additionalEducationInfoDtos.add(additionalEducationInfoDto);
            }
            mainInfoDto.setAdditionalEducationInfoDtos(additionalEducationInfoDtos);


            List<ChildrenInfo> childrenInfos = childrenInfoRepository.findByUserId(userId);
            List<ChildrenInfoDto> childrenInfoDtos = new ArrayList<>();
            for (ChildrenInfo info : childrenInfos) {
                ChildrenInfoDto childrenInfoDto = new ChildrenInfoDto();
                childrenInfoDto.setFIO(info.getFIO());
                childrenInfoDto.setDateOfBirthday(info.getDateOfBirthday());
                childrenInfoDto.setWorkPlace(info.getWorkPlace());
                childrenInfoDto.setPhoneNumber(info.getPhoneNumber());
                childrenInfoDtos.add(childrenInfoDto);
            }
            mainInfoDto.setChildrenInfoDtos(childrenInfoDtos);


            List<RelativesInfo> relativesInfos = relativesInfoRepository.findByUserId(userId);
            List<RelativesInfoDto> relativesInfoDtos = new ArrayList<>();
            for (RelativesInfo info : relativesInfos) {
                RelativesInfoDto relativesInfoDto = new RelativesInfoDto();
                relativesInfoDto.setFIO(info.getFIO());
                relativesInfoDto.setDateOfBirthday(info.getDateOfBirthday());
                relativesInfoDto.setAddress(info.getAddress());
                relativesInfoDto.setPhoneNumber(info.getPhoneNumber());
                relativesInfoDto.setDegreeOfRelationship(info.getDegreeOfRelationship());
                relativesInfoDto.setWorkingPlace(info.getWorkingPlace());
                relativesInfoDto.setWorkingPosition(info.getWorkingPosition());
                relativesInfoDtos.add(relativesInfoDto);
            }
            mainInfoDto.setRelativesInfoDtos(relativesInfoDtos);


            List<AdditionalWorkingInfo> additionalWorkingInfos = additionalWorkingInfoRepository.findByUserId(userId);
            List<AdditionalWorkingInfoDto> additionalWorkingInfoDtos = new ArrayList<>();
            for (AdditionalWorkingInfo info : additionalWorkingInfos) {
                AdditionalWorkingInfoDto additionalWorkingInfoDto = new AdditionalWorkingInfoDto();
                additionalWorkingInfoDto.setTypeOfWork(info.getTypeOfWork());
                additionalWorkingInfoDto.setInn(info.getInn());
                additionalWorkingInfoDto.setAddress(info.getAddress());
                additionalWorkingInfoDto.setPhoneNumber(info.getPhoneNumber());
                additionalWorkingInfoDto.setName(info.getName());
                additionalWorkingInfoDtos.add(additionalWorkingInfoDto);
            }
            mainInfoDto.setAdditionalWorkingInfoDtos(additionalWorkingInfoDtos);


            List<RelativesInJusan> relativesInJusans = relativesInJusanRepository.findByUserId(userId);
            List<RelativesInJusanDto> relativesInJusanDtos = new ArrayList<>();
            for (RelativesInJusan info : relativesInJusans) {
                RelativesInJusanDto relativesInJusanDto = new RelativesInJusanDto();
                relativesInJusanDto.setFIO(info.getFIO());
                relativesInJusanDto.setDegreeOfRelationship(info.getDegreeOfRelationship());
                relativesInJusanDto.setDepartmentAndPosition(info.getDepartmentAndPosition());
                relativesInJusanDtos.add(relativesInJusanDto);
            }
            mainInfoDto.setRelativesInJusanDtos(relativesInJusanDtos);

         }
        return mainInfoDto;
    }
}
