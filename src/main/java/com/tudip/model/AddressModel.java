package com.tudip.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class AddressModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long addressId;
	private String address;
	private String city;
	private String state;
	private String cuntry;
	private String pinCode;

	public AddressModel() {
		super();
	}

	public AddressModel(long addressId, String address, String city, String state, String cuntry, String pinCode) {
		super();
		this.addressId = addressId;
		this.address = address;
		this.city = city;
		this.state = state;
		this.cuntry = cuntry;
		this.pinCode = pinCode;
	}

	public long getAddressId() {
		return addressId;
	}

	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCuntry() {
		return cuntry;
	}

	public void setCuntry(String cuntry) {
		this.cuntry = cuntry;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	@Override
	public String toString() {
		return "AddressModel [addressId=" + addressId + ", address=" + address + ", city=" + city + ", state=" + state
				+ ", cuntry=" + cuntry + ", pinCode=" + pinCode + "]";
	}

}
