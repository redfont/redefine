package com.redefine.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Table(name="addresses")
@Entity
public class Address implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="address_id")
	private String addressId;
	
	@Column(name="person_id")
	private Integer personId;
	
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
	
	@Column(name="created_by")
	private String createdBy;
	
	@Column(name="updated_by")
	private String updatedBy;
	
	@Column(name="date_created")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;
	
	@Column(name="date_updated")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateUpdated;
	
	public Address(){}
}
