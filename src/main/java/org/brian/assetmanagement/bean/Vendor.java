package org.brian.assetmanagement.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Vendor")
public class Vendor {
	@Id
	@Column(name = "vendorId", updatable = false, nullable = false)
	private long vendorID;

	@Column(name = "name")
	private String name;

	@Column(name = "phone_number")
	private String phoneNumber;

	@Column(name = "email")
	private String email;

	@Column(name = "vendorRep")
	private String vendorRep;

	public long getVendorID() {
		return vendorID;
	}

	public void setVendorID(long vendorID) {
		this.vendorID = vendorID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getVendorRep() {
		return vendorRep;
	}

	public void setVendorRep(String vendorRep) {
		this.vendorRep = vendorRep;
	}

	@Override
	public String toString() {
		return "Vendor{" + "vendorID=" + vendorID + ", name=" + name + ", phoneNumber=" + phoneNumber + ", email="
				+ email + ", vendorRep=" + vendorRep + '}';
	}

}