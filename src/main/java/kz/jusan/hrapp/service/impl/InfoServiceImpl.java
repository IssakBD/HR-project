package kz.jusan.hrapp.service.impl;

import kz.jusan.hrapp.dto.MainInfoDto;
import kz.jusan.hrapp.model.User;
import kz.jusan.hrapp.model.form.*;
import kz.jusan.hrapp.repository.*;
import kz.jusan.hrapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        mainInfo.setPersonsInfoWhoCanGiveProfessionalRecommendationFIOOne(mainInfoDto.getPersonsInfoWhoCanGiveProfessionalRecommendationFIOOne());
        mainInfo.setPersonsInfoWhoCanGiveProfessionalRecommendationWorkingInfoOne(mainInfoDto.getPersonsInfoWhoCanGiveProfessionalRecommendationWorkingInfoOne());
        mainInfo.setPersonsInfoWhoCanGiveProfessionalRecommendationWorkingPositionOne(mainInfoDto.getPersonsInfoWhoCanGiveProfessionalRecommendationWorkingPositionOne());
        mainInfo.setPersonsInfoWhoCanGiveProfessionalRecommendationPhoneNumberOne(mainInfoDto.getPersonsInfoWhoCanGiveProfessionalRecommendationPhoneNumberOne());
        mainInfo.setPersonsInfoWhoCanGiveProfessionalRecommendationFIOTwo(mainInfoDto.getPersonsInfoWhoCanGiveProfessionalRecommendationFIOTwo());
        mainInfo.setPersonsInfoWhoCanGiveProfessionalRecommendationWorkingInfoTwo(mainInfoDto.getPersonsInfoWhoCanGiveProfessionalRecommendationWorkingInfoTwo());
        mainInfo.setPersonsInfoWhoCanGiveProfessionalRecommendationWorkingPositionTwo(mainInfoDto.getPersonsInfoWhoCanGiveProfessionalRecommendationWorkingPositionTwo());
        mainInfo.setPersonsInfoWhoCanGiveProfessionalRecommendationPhoneNumberTwo(mainInfoDto.getPersonsInfoWhoCanGiveProfessionalRecommendationPhoneNumberTwo());
        mainInfo.setPersonsInfoWhoCanGiveProfessionalRecommendationFIOThree(mainInfoDto.getPersonsInfoWhoCanGiveProfessionalRecommendationFIOThree());
        mainInfo.setPersonsInfoWhoCanGiveProfessionalRecommendationWorkingInfoThree(mainInfoDto.getPersonsInfoWhoCanGiveProfessionalRecommendationWorkingInfoThree());
        mainInfo.setPersonsInfoWhoCanGiveProfessionalRecommendationWorkingPositionThree(mainInfoDto.getPersonsInfoWhoCanGiveProfessionalRecommendationWorkingPositionThree());
        mainInfo.setPersonsInfoWhoCanGiveProfessionalRecommendationPhoneNumberThree(mainInfoDto.getPersonsInfoWhoCanGiveProfessionalRecommendationPhoneNumberThree());
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

        List<UniversityInfo> universityInfoList = mainInfoDto.getUniversityInfos();
        for (UniversityInfo info : universityInfoList) {
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

        List<AdditionalEducationInfo> additionalEducationInfoList = mainInfoDto.getAdditionalEducationInfos();
        for (AdditionalEducationInfo info : additionalEducationInfoList) {
            AdditionalEducationInfo additionalEducationInfo = new AdditionalEducationInfo();
            additionalEducationInfo.setYearOfGraduation(info.getYearOfGraduation());
            additionalEducationInfo.setDurationOfTraining(info.getDurationOfTraining());
            additionalEducationInfo.setNameOfCourse(info.getNameOfCourse());
            additionalEducationInfo.setSpeciality(info.getSpeciality());
            additionalEducationInfo.setAcademicDegreeOrCertificates(info.getAcademicDegreeOrCertificates());
            additionalEducationInfo.setUser(user);
            additionalEducationInfoRepository.save(additionalEducationInfo);
        }

        List<ChildrenInfo> childrenInfoList = mainInfoDto.getChildrenInfos();
        for (ChildrenInfo info : childrenInfoList) {
            ChildrenInfo childrenInfo = new ChildrenInfo();
            childrenInfo.setFIO(info.getFIO());
            childrenInfo.setDateOfBirthday(info.getDateOfBirthday());
            childrenInfo.setPhoneNumber(info.getPhoneNumber());
            childrenInfo.setWorkPlace(info.getWorkPlace());
            childrenInfo.setUser(user);
            childrenInfoRepository.save(childrenInfo);
        }

        List<RelativesInfo> relativesInfos = mainInfoDto.getRelativesInfos();
        for (RelativesInfo info : relativesInfos) {
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

        List<AdditionalWorkingInfo> additionalWorkingInfoList = mainInfoDto.getAdditionalWorkingInfo();
        for (AdditionalWorkingInfo info : additionalWorkingInfoList) {
            AdditionalWorkingInfo additionalWorkingInfo = new AdditionalWorkingInfo();
            additionalWorkingInfo.setName(info.getName());
            additionalWorkingInfo.setIin(info.getIin());
            additionalWorkingInfo.setAddress(info.getAddress());
            additionalWorkingInfo.setTypeOfWork(info.getTypeOfWork());
            additionalWorkingInfo.setPhoneNumber(info.getPhoneNumber());
            additionalWorkingInfo.setUser(user);
            additionalWorkingInfoRepository.save(additionalWorkingInfo);
        }


        List<RelativesInJusan> relativesInJusanList = mainInfoDto.getRelativesInJusan();
        for (RelativesInJusan info : relativesInJusanList) {
            RelativesInJusan relativesInJusan = new RelativesInJusan();
            relativesInJusan.setDegreeOfRelationship(info.getDegreeOfRelationship());
            relativesInJusan.setFIO(info.getFIO());
            relativesInJusan.setDepartmentAndPosition(info.getDepartmentAndPosition());
            relativesInJusan.setUser(user);
            relativesInJusanRepository.save(relativesInJusan);
        }
    }
    public void save(AdditionalEducationInfo additionalEducationInfo){
        additionalEducationInfoRepository.save(additionalEducationInfo);
    }
    public void save(AdditionalWorkingInfo additionalWorkingInfo){
        additionalWorkingInfoRepository.save(additionalWorkingInfo);
    }
    public void save(ChildrenInfo childrenInfo){
        childrenInfoRepository.save(childrenInfo);
    }
    public void save(RelativesInfo relativesInfo){
        relativesInfoRepository.save(relativesInfo);
    }
    public void save(RelativesInJusan relativesInJusan){
        relativesInJusanRepository.save(relativesInJusan);
    }
    public void save(UniversityInfo universityInfo){
        universityInfoRepository.save(universityInfo);
    }

    public Optional<MainInfo> findById(Long user_id) {
        return mainInfoRepository.findById(user_id);
    }
}
