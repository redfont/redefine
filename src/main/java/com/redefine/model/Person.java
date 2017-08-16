package com.redefine.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Table(name="persons")
@Entity
public class Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="person_id")
	private Integer personId;

	@Column(name="firstname")
	private String firstName;
	
	@Column(name="middlename")
	private String middleName;
	
	@Column(name="lastname")
	private String lastName;
	
	@Column(name="email")
	private String email;
	
	@Column(name="birthdate")
	private Date birthDate;
	
	@Column(name="address_1")
	private String address1;
	
	@Column(name="address_2")
	private String address2;
	
	@Column(name="barangay")
	private String barangay;
	
	@Column(name="city_or_municipality")
	private String cityOrMunicipality;
	
	@Column(name="province")
	private String province;
	
	@Column(name="postal_code")
	private String postalCode;
	
	@Column(name="is_prospect")
	private Boolean isProspect;
	
	@ManyToOne
	@JoinColumn(name="contact_type_code", referencedColumnName="code")
	private ContactType contactType;
	
	@Column(name="date_created", insertable=false, updatable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;
	
	@Column(name="date_updated", insertable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateUpdated;
	
	@Column(name="created_by")
	private String createdBy;
	
	@Column(name="updated_by")
	private String updatedBy;
	
	public Person(){}

	public Integer getPersonId() {
		return personId;
	}

	public void setPersonId(Integer personId) {
		this.personId = personId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getBarangay() {
		return barangay;
	}

	public void setBarangay(String barangay) {
		this.barangay = barangay;
	}

	public String getCityOrMunicipality() {
		return cityOrMunicipality;
	}

	public void setCityOrMunicipality(String cityOrMunicipality) {
		this.cityOrMunicipality = cityOrMunicipality;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public Boolean getIsProspect() {
		return isProspect;
	}

	public void setIsProspect(Boolean isProspect) {
		this.isProspect = isProspect;
	}


	/**
	 * @return the contactType
	 */
	public ContactType getContactType() {
		return contactType;
	}

	/**
	 * @param contactType the contactType to set
	 */
	public void setContactType(ContactType contactType) {
		this.contactType = contactType;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateUpdated() {
		return dateUpdated;
	}

	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
}
