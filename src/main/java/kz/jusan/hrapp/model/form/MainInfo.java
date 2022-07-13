package kz.jusan.hrapp.model.form;


import kz.jusan.hrapp.model.User;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "mainInfo")
@Data
public class MainInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "iin")
    private String iin;

    @Column(name = "fio")
    private String FIO;

    @Column(name = "oldSurname")
    private String oldSurname;

    @Column(name = "dateOfBirthday")
    private String dateOfBirthday;

    @Column(name = "placeOfBirth")
    private String placeOfBirth;

    @Column(name = "nationality")
    private String nationality;

    @Column(name = "citizenship")
    private String citizenship;

    @Column(name = "documentSeries")
    private String documentSeries;

    @Column(name = "documentNumber")
    private String documentNumber;

    @Column(name = "documentIssued")
    private String documentIssued;

    @Column(name = "homePhoneNumber")
    private String homePhoneNumber;

    @Column(name = "workPhoneNumber")
    private String workPhoneNumber;

    @Column(name = "mobilePhoneNumber")
    private String mobilePhoneNumber;

    @Column(name = "contactPersonFio")
    private String contactPersonFio;

    @Column(name = "contactPersonDegreeOfRelationship")
    private String contactPersonDegreeOfRelationship;

    @Column(name = "contactPersonPhoneNumber")
    private String contactPersonPhoneNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "permanentRegistrationAddressCity")
    private String permanentRegistrationAddressCity;

    @Column(name = "permanentRegistrationAddressDistrict")
    private String permanentRegistrationAddressDistrict;

    @Column(name = "permanentRegistrationAddressRegion")
    private String permanentRegistrationAddressRegion;

    @Column(name = "permanentRegistrationAddressStreet")
    private String permanentRegistrationAddressStreet;

    @Column(name = "permanentRegistrationAddressHouseNumber")
    private String permanentRegistrationAddressHouseNumber;

    @Column(name = "permanentRegistrationAddressCorpus")
    private String permanentRegistrationAddressCorpus;

    @Column(name = "permanentRegistrationAddressApartment")
    private String permanentRegistrationAddressApartment;

    @Column(name = "actualAddressCity")
    private String actualAddressCity;

    @Column(name = "actualAddressDistrict")
    private String actualAddressDistrict;

    @Column(name = "actualAddressRegion")
    private String actualAddressRegion;

    @Column(name = "actualAddressStreet")
    private String actualAddressStreet;

    @Column(name = "actualAddressHouseNumber")
    private String actualAddressHouseNumber;

    @Column(name = "actualAddressCorpus")
    private String actualAddressCorpus;

    @Column(name = "actualAddressApartment")
    private String actualAddressApartment;

    @Column(name = "startOfWorkingOne")
    private String startOfWorkingOne;

    @Column(name = "endOfWorkingOne")
    private String endOfWorkingOne;

    @Column(name = "workingPlaceNameOne")
    private String workingPlaceInfoOne;

    @Column(name = "workTypeOne")
    private String workTypeOne;

    @Column(name = "workingPlaceAddressOne")
    private String workingPlaceAddressOne;

    @Column(name = "workingPlacePhoneNumberOne")
    private String workingPlacePhoneNumberOne;

    @Column(name = "positionOne")
    private String positionOne;

    @Column(name = "managerFullNameOne")
    private String managerFullNameOne;

    @Column(name = "managerPhoneNumberOne")
    private String managerPhoneNumberOne;

    @Column(name = "reasonForDismissalOne")
    private String reasonForDismissalOne;

    @Column(name = "startOfWorkingTwo")
    private String startOfWorkingTwo;

    @Column(name = "endOfWorkingTwo")
    private String endOfWorkingTwo;

    @Column(name = "workingPlaceNameTwo")
    private String workingPlaceInfoTwo;

    @Column(name = "workTypeTwo")
    private String workTypeTwo;

    @Column(name = "workingPlaceAddressTwo")
    private String workingPlaceAddressTwo;

    @Column(name = "workingPlacePhoneNumberTwo")
    private String workingPlacePhoneNumberTwo;

    @Column(name = "positionTwo")
    private String positionTwo;

    @Column(name = "managerFullNameTwo")
    private String managerFullNameTwo;

    @Column(name = "managerPhoneNumberTwo")
    private String managerPhoneNumberTwo;

    @Column(name = "reasonForDismissalTwo")
    private String reasonForDismissalTwo;

    @Column(name = "startOfWorkingThree")
    private String startOfWorkingThree;

    @Column(name = "endOfWorkingThree")
    private String endOfWorkingThree;

    @Column(name = "workingPlaceNameThree")
    private String workingPlaceNameThree;

    @Column(name = "workTypeThree")
    private String workTypeThree;

    @Column(name = "workingPlaceAddressThree")
    private String workingPlaceAddressThree;

    @Column(name = "workingPlacePhoneNumberThree")
    private String workingPlacePhoneNumberThree;

    @Column(name = "positionThree")
    private String positionThree;

    @Column(name = "managerFullNameThree")
    private String managerFullNameThree;

    @Column(name = "managerPhoneNumberThree")
    private String managerPhoneNumberThree;

    @Column(name = "reasonForDismissalThree")
    private String reasonForDismissalThree;

    @Column(name = "profRefFullName1")
    private String profRefFullName1;

    @Column(name = "profRefWorkPlace1")
    private String profRefWorkPlace1;

    @Column(name = "profRefWorkPosition1")
    private String profRefWorkPosition1;

    @Column(name = "profRefTel1")
    private String profRefTel1;

    @Column(name = "profRefFullName2")
    private String profRefFullName2;

    @Column(name = "profRefWorkPlace2")
    private String profRefWorkPlace2;

    @Column(name = "profRefWorkPosition2")
    private String profRefWorkPosition2;

    @Column(name = "profRefTel2")
    private String profRefTel2;

    @Column(name = "profRefFullName3")
    private String profRefFullName3;

    @Column(name = "profRefWorkPlace3")
    private String profRefWorkPlace3;

    @Column(name = "profRefWorkPosition3")
    private String profRefWorkPosition3;

    @Column(name = "profRefTel3")
    private String profRefTel3;
    @Column(name = "maritalStatus")
    private String maritalStatus;

    @Column(name = "spouseFIO")
    private String spouseFIO;

    @Column(name = "spouseDateOfBirthday")
    private String spouseDateOfBirthday;

    @Column(name = "spouseWorkingInfo")
    private String spouseWorkingInfo;

    @Column(name = "spouseWorkingPosition")
    private String spouseWorkingPosition;

    @Column(name = "spouseAddress")
    private String spouseAddress;

    @Column(name = "spouseCitizenship")
    private String spouseCitizenship;

    @Column(name = "spouseContacts")
    private String spouseContacts;

    @Column(name = "carModel")
    private String carModel;

    @Column(name = "carYearOfManufacture")
    private String carYearOfManufacture;

    @Column(name = "carNumber")
    private String carNumber;

    @Column(name = "militaryStatus")
    private String militaryStatus;

    @Column(name = "benefitsStatus")
    private String benefitsStatus;

    @Column(name = "overdueLoanStatus")
    private String overdueLoanStatus;

    @Column(name = "overdueLoanReason")
    private String overdueLoanReason;

    @Column(name = "criminalLiabilityStatus")
    private String criminalLiabilityStatus;

    @Column(name = "criminalLiabilityReason")
    private String criminalLiabilityReason;

    @Column(name = "relativesCriminalCaseStatus")
    private String relativesCriminalCaseStatus;

    @Column(name = "relativesCriminalCaseReason")
    private String relativesCriminalCaseReason;

    @Column(name = "criminalCaseStatus")
    private String criminalCaseStatus;

    @Column(name = "criminalCaseReason")
    private String criminalCaseReason;

    @Column(name = "alimonyStatus")
    private String alimonyStatus;

    @Column(name = "alimonyReason")
    private String alimonyReason;

    @Column(name = "administrativeLiabilityStatus")
    private String administrativeLiabilityStatus;

    @Column(name = "administrativeLiabilityReason")
    private String administrativeLiabilityReason;

    @Column(name = "additionalInformation")
    private String additionalInformation;

    @Column(name = "additionalIncome")
    private String additionalIncome;

    @Column(name = "dateOfFillingIn")
    private String dateOfFillingIn;

    @Column(name = "isAgreed")
    private Boolean isAgreed;


    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Override
    public String toString() {
        return "MainInfo{" +
                "id=" + id +
                ", iin='" + iin + '\'' +
                ", FIO='" + FIO + '\'' +
                ", oldSurname='" + oldSurname + '\'' +
                ", dateOfBirthday='" + dateOfBirthday + '\'' +
                ", placeOfBirth='" + placeOfBirth + '\'' +
                ", nationality='" + nationality + '\'' +
                ", citizenship='" + citizenship + '\'' +
                ", documentSeries='" + documentSeries + '\'' +
                ", documentNumber='" + documentNumber + '\'' +
                ", documentIssued='" + documentIssued + '\'' +
                ", homePhoneNumber='" + homePhoneNumber + '\'' +
                ", workPhoneNumber='" + workPhoneNumber + '\'' +
                ", mobilePhoneNumber='" + mobilePhoneNumber + '\'' +
                ", contactPersonFio='" + contactPersonFio + '\'' +
                ", contactPersonDegreeOfRelationship='" + contactPersonDegreeOfRelationship + '\'' +
                ", contactPersonPhoneNumber='" + contactPersonPhoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", permanentRegistrationAddressCity='" + permanentRegistrationAddressCity + '\'' +
                ", permanentRegistrationAddressDistrict='" + permanentRegistrationAddressDistrict + '\'' +
                ", permanentRegistrationAddressRegion='" + permanentRegistrationAddressRegion + '\'' +
                ", permanentRegistrationAddressStreet='" + permanentRegistrationAddressStreet + '\'' +
                ", permanentRegistrationAddressHouseNumber='" + permanentRegistrationAddressHouseNumber + '\'' +
                ", permanentRegistrationAddressCorpus='" + permanentRegistrationAddressCorpus + '\'' +
                ", permanentRegistrationAddressApartment='" + permanentRegistrationAddressApartment + '\'' +
                ", actualAddressCity='" + actualAddressCity + '\'' +
                ", actualAddressDistrict='" + actualAddressDistrict + '\'' +
                ", actualAddressRegion='" + actualAddressRegion + '\'' +
                ", actualAddressStreet='" + actualAddressStreet + '\'' +
                ", actualAddressHouseNumber='" + actualAddressHouseNumber + '\'' +
                ", actualAddressCorpus='" + actualAddressCorpus + '\'' +
                ", actualAddressApartment='" + actualAddressApartment + '\'' +
                ", startOfWorkingOne='" + startOfWorkingOne + '\'' +
                ", endOfWorkingOne='" + endOfWorkingOne + '\'' +
                ", workingPlaceInfoOne='" + workingPlaceInfoOne + '\'' +
                ", workTypeOne='" + workTypeOne + '\'' +
                ", workingPlaceAddressOne='" + workingPlaceAddressOne + '\'' +
                ", workingPlacePhoneNumberOne='" + workingPlacePhoneNumberOne + '\'' +
                ", positionOne='" + positionOne + '\'' +
                ", managerFullNameOne='" + managerFullNameOne + '\'' +
                ", managerPhoneNumberOne='" + managerPhoneNumberOne + '\'' +
                ", reasonForDismissalOne='" + reasonForDismissalOne + '\'' +
                ", startOfWorkingTwo='" + startOfWorkingTwo + '\'' +
                ", endOfWorkingTwo='" + endOfWorkingTwo + '\'' +
                ", workingPlaceInfoTwo='" + workingPlaceInfoTwo + '\'' +
                ", workTypeTwo='" + workTypeTwo + '\'' +
                ", workingPlaceAddressTwo='" + workingPlaceAddressTwo + '\'' +
                ", workingPlacePhoneNumberTwo='" + workingPlacePhoneNumberTwo + '\'' +
                ", positionTwo='" + positionTwo + '\'' +
                ", managerFullNameTwo='" + managerFullNameTwo + '\'' +
                ", managerPhoneNumberTwo='" + managerPhoneNumberTwo + '\'' +
                ", reasonForDismissalTwo='" + reasonForDismissalTwo + '\'' +
                ", startOfWorkingThree='" + startOfWorkingThree + '\'' +
                ", endOfWorkingThree='" + endOfWorkingThree + '\'' +
                ", workingPlaceNameThree='" + workingPlaceNameThree + '\'' +
                ", workTypeThree='" + workTypeThree + '\'' +
                ", workingPlaceAddressThree='" + workingPlaceAddressThree + '\'' +
                ", workingPlacePhoneNumberThree='" + workingPlacePhoneNumberThree + '\'' +
                ", positionThree='" + positionThree + '\'' +
                ", managerFullNameThree='" + managerFullNameThree + '\'' +
                ", managerPhoneNumberThree='" + managerPhoneNumberThree + '\'' +
                ", reasonForDismissalThree='" + reasonForDismissalThree + '\'' +
                ", profRefFullName1='" + profRefFullName1 + '\'' +
                ", profRefWorkPlace1='" + profRefWorkPlace1 + '\'' +
                ", profRefWorkPosition1='" + profRefWorkPosition1 + '\'' +
                ", profRefTel1='" + profRefTel1 + '\'' +
                ", profRefFullName2='" + profRefFullName2 + '\'' +
                ", profRefWorkPlace2='" + profRefWorkPlace2 + '\'' +
                ", profRefWorkPosition2='" + profRefWorkPosition2 + '\'' +
                ", profRefTel2='" + profRefTel2 + '\'' +
                ", profRefFullName3='" + profRefFullName3 + '\'' +
                ", profRefWorkPlace3='" + profRefWorkPlace3 + '\'' +
                ", profRefWorkPosition3='" + profRefWorkPosition3 + '\'' +
                ", profRefTel3='" + profRefTel3 + '\'' +
                ", maritalStatus='" + maritalStatus + '\'' +
                ", spouseFIO='" + spouseFIO + '\'' +
                ", spouseDateOfBirthday='" + spouseDateOfBirthday + '\'' +
                ", spouseWorkingInfo='" + spouseWorkingInfo + '\'' +
                ", spouseWorkingPosition='" + spouseWorkingPosition + '\'' +
                ", spouseAddress='" + spouseAddress + '\'' +
                ", spouseCitizenship='" + spouseCitizenship + '\'' +
                ", spouseContacts='" + spouseContacts + '\'' +
                ", carModel='" + carModel + '\'' +
                ", carYearOfManufacture='" + carYearOfManufacture + '\'' +
                ", carNumber='" + carNumber + '\'' +
                ", militaryStatus='" + militaryStatus + '\'' +
                ", benefitsStatus='" + benefitsStatus + '\'' +
                ", overdueLoanStatus='" + overdueLoanStatus + '\'' +
                ", overdueLoanReason='" + overdueLoanReason + '\'' +
                ", criminalLiabilityStatus='" + criminalLiabilityStatus + '\'' +
                ", criminalLiabilityReason='" + criminalLiabilityReason + '\'' +
                ", relativesCriminalCaseStatus='" + relativesCriminalCaseStatus + '\'' +
                ", relativesCriminalCaseReason='" + relativesCriminalCaseReason + '\'' +
                ", criminalCaseStatus='" + criminalCaseStatus + '\'' +
                ", criminalCaseReason='" + criminalCaseReason + '\'' +
                ", alimonyStatus='" + alimonyStatus + '\'' +
                ", alimonyReason='" + alimonyReason + '\'' +
                ", administrativeLiabilityStatus='" + administrativeLiabilityStatus + '\'' +
                ", administrativeLiabilityReason='" + administrativeLiabilityReason + '\'' +
                ", additionalInformation='" + additionalInformation + '\'' +
                ", additionalIncome='" + additionalIncome + '\'' +
                ", dateOfFillingIn='" + dateOfFillingIn + '\'' +
                '}';
    }
}
