package com.tudip.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class CandidatesModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long candidateId;
	private String candidateName;
	private String candidatePhoneNumber;
	private String candidateEmail;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	List<AddressModel> address;

	public long getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(long candidateId) {
		this.candidateId = candidateId;
	}

	public String getCandidateName() {
		return candidateName;
	}

	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}

	public String getCandidatePhoneNumber() {
		return candidatePhoneNumber;
	}

	public void setCandidatePhoneNumber(String candidatePhoneNumber) {
		this.candidatePhoneNumber = candidatePhoneNumber;
	}

	public String getCandidateEmail() {
		return candidateEmail;
	}

	public void setCandidateEmail(String candidateEmail) {
		this.candidateEmail = candidateEmail;
	}

	public List<AddressModel> getAddress() {
		return address;
	}

	public void setAddress(List<AddressModel> address) {
		this.address = address;
	}

	public CandidatesModel() {
		super();
	}

	public CandidatesModel(long candidateId, String candidateName, String candidatePhoneNumber, String candidateEmail,
			List<AddressModel> address) {
		super();
		this.candidateId = candidateId;
		this.candidateName = candidateName;
		this.candidatePhoneNumber = candidatePhoneNumber;
		this.candidateEmail = candidateEmail;
		this.address = address;
	}

	@Override
	public String toString() {
		return "CandidatesModel [candidateId=" + candidateId + ", candidateName=" + candidateName
				+ ", candidatePhoneNumber=" + candidatePhoneNumber + ", candidateEmail=" + candidateEmail + ", address="
				+ address + "]";
	}

}
