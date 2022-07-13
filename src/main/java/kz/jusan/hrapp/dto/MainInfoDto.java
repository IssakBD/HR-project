package kz.jusan.hrapp.dto;

import kz.jusan.hrapp.model.form.*;
import lombok.Data;

import javax.persistence.Column;
import java.util.List;

@Data
public class MainInfoDto {

    private String iin;

    private String FIO;

    private String oldSurname;

    private String dateOfBirthday;

    private String placeOfBirth;

    private String nationality;

    private String citizenship;

    private String documentSeries;

    private String documentNumber;

    private String documentIssued;

    private String homePhoneNumber;

    private String workPhoneNumber;

    private String mobilePhoneNumber;

    private String contactPersonFio;

    private String contactPersonDegreeOfRelationship;

    private String contactPersonPhoneNumber;

    private String email;

    private String permanentRegistrationAddressCity;

    private String permanentRegistrationAddressDistrict;

    private String permanentRegistrationAddressRegion;

    private String permanentRegistrationAddressStreet;

    private String permanentRegistrationAddressHouseNumber;

    private String permanentRegistrationAddressCorpus;

    private String permanentRegistrationAddressApartment;

    private String actualAddressCity;

    private String actualAddressDistrict;

    private String actualAddressRegion;

    private String actualAddressStreet;

    private String actualAddressHouseNumber;

    private String actualAddressCorpus;

    private String actualAddressApartment;

    private List<UniversityInfoDto> universityInfoDtos;

    private List<AdditionalEducationInfoDto> additionalEducationInfoDtos;

    private String startOfWorkingOne;

    private String endOfWorkingOne;

    private String workingPlaceInfoOne;

    private String workTypeOne;

    private String workingPlaceAddressOne;

    private String workingPlacePhoneNumberOne;

    private String positionOne;

    private String managerFullNameOne;

    private String managerPhoneNumberOne;

    private String reasonForDismissalOne;

    private String startOfWorkingTwo;

    private String endOfWorkingTwo;

    private String workingPlaceInfoTwo;

    private String workTypeTwo;

    private String workingPlaceAddressTwo;

    private String workingPlacePhoneNumberTwo;

    private String positionTwo;

    private String managerFullNameTwo;

    private String managerPhoneNumberTwo;

    private String reasonForDismissalTwo;

    private String startOfWorkingThree;

    private String endOfWorkingThree;

    private String workingPlaceNameThree;

    private String workTypeThree;

    private String workingPlaceAddressThree;

    private String workingPlacePhoneNumberThree;

    private String positionThree;

    private String managerFullNameThree;

    private String managerPhoneNumberThree;

    private String reasonForDismissalThree;

    private String profRefFullName1;

    private String profRefWorkPlace1;

    private String profRefWorkPosition1;

    private String profRefTel1;

    private String profRefFullName2;

    private String profRefWorkPlace2;

    private String profRefWorkPosition2;

    private String profRefTel2;

    private String profRefFullName3;

    private String profRefWorkPlace3;

    private String profRefWorkPosition3;

    private String profRefTel3;

    private String maritalStatus;

    private String spouseFIO;

    private String spouseDateOfBirthday;

    private String spouseWorkingInfo;

    private String spouseWorkingPosition;

    private String spouseAddress;

    private String spouseCitizenship;

    private String spouseContacts;

    private List<ChildrenInfoDto> childrenInfoDtos;

    private List<RelativesInfoDto> relativesInfoDtos;

    private List<AdditionalWorkingInfoDto> additionalWorkingInfoDtos;
    private List<RelativesInJusanDto> relativesInJusanDtos;

    private String carModel;

    private String carYearOfManufacture;

    private String carNumber;

    private String militaryStatus;

    private String benefitsStatus;

    private String overdueLoanStatus;

    private String overdueLoanReason;

    private String criminalLiabilityStatus;

    private String criminalLiabilityReason;

    private String relativesCriminalCaseStatus;

    private String relativesCriminalCaseReason;

    private String criminalCaseStatus;

    private String criminalCaseReason;

    private String alimonyStatus;

    private String alimonyReason;

    private String administrativeLiabilityStatus;

    private String administrativeLiabilityReason;

    private String additionalInformation;

    private String additionalIncome;

    private String dateOfFillingIn;
}
