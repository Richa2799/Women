package model;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="candidate")
public class Candidate {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	String fname;
	String lname;
	String email;
	String password;
	String nationality;
	String country;
	String state;
	String city;
	String addressLine;
	String motherName;
	String fatherName;
	Long mobile;
	int age;
	Date dob;
	Long adharNumber;
	String highestQualification;
	String maritalStatus;
	Long income;
	boolean isWorking;
	String incomeProof;
	String adharPhoto;
	String highestQualificationProof;
	public Candidate() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Candidate(int id, String fname, String lname, String email, String password, String nationality,
			String country, String state, String city, String addressLine, String motherName, String fatherName,
			Long mobile, int age, Date dob, Long adharNumber, String highestQualification, String maritalStatus,
			Long income, boolean isWorking, String incomeProof, String adharPhoto, String highestQualificationProof) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.password = password;
		this.nationality = nationality;
		this.country = country;
		this.state = state;
		this.city = city;
		this.addressLine = addressLine;
		this.motherName = motherName;
		this.fatherName = fatherName;
		this.mobile = mobile;
		this.age = age;
		this.dob = dob;
		this.adharNumber = adharNumber;
		this.highestQualification = highestQualification;
		this.maritalStatus = maritalStatus;
		this.income = income;
		this.isWorking = isWorking;
		this.incomeProof = incomeProof;
		this.adharPhoto = adharPhoto;
		this.highestQualificationProof = highestQualificationProof;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAddressLine() {
		return addressLine;
	}
	public void setAddressLine(String addressLine) {
		this.addressLine = addressLine;
	}
	public String getMotherName() {
		return motherName;
	}
	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public Long getMobile() {
		return mobile;
	}
	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public Long getAdharNumber() {
		return adharNumber;
	}
	public void setAdharNumber(Long adharNumber) {
		this.adharNumber = adharNumber;
	}
	public String getHighestQualification() {
		return highestQualification;
	}
	public void setHighestQualification(String highestQualification) {
		this.highestQualification = highestQualification;
	}
	public String getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public Long getIncome() {
		return income;
	}
	public void setIncome(Long income) {
		this.income = income;
	}
	public boolean isWorking() {
		return isWorking;
	}
	public void setWorking(boolean isWorking) {
		this.isWorking = isWorking;
	}
	public String getIncomeProof() {
		return incomeProof;
	}
	public void setIncomeProof(String incomeProof) {
		this.incomeProof = incomeProof;
	}
	public String getAdharPhoto() {
		return adharPhoto;
	}
	public void setAdharPhoto(String adharPhoto) {
		this.adharPhoto = adharPhoto;
	}
	public String getHighestQualificationProof() {
		return highestQualificationProof;
	}
	public void setHighestQualificationProof(String highestQualificationProof) {
		this.highestQualificationProof = highestQualificationProof;
	}
	
	

}
