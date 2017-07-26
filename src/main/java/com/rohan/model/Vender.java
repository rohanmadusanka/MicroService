package com.rohan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="vender")
public class Vender {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="city")
	private String city;
	
	@Column(name="street")
	private String street;
	
	@Column(name="mobile_no")
	private String mobileno;
	
	@Column(name="office_no")
	private String officeno;
	
	public Vender(long id) {
		this.id=id;
	}
	
	public Vender() {}
	public Vender(String companyName,String city, String street,String mobileNo, String officeNo) {
		this.companyName=companyName;
		this.city=city;
		this.street=street;
		this.mobileno=mobileNo;
		this.officeno=officeNo;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	public String getOfficeno() {
		return officeno;
	}
	public void setOfficeno(String officeno) {
		this.officeno = officeno;
	}
	
}
