package com.android.redowsko.model.report;

import com.google.gson.annotations.SerializedName;
public class ListItem{

	@SerializedName("address")
	private String address;

	@SerializedName("insured_client")
	private String insuredClient;

	@SerializedName("noticeofdamage")
	private String noticeofdamage;

	@SerializedName("contact_person")
	private String contactPerson;

	@SerializedName("signature")
	private String signature;

	@SerializedName("work")
	private String work;

	@SerializedName("observation")
	private String observation;

	@SerializedName("phone_contact_person")
	private String phoneContactPerson;

	@SerializedName("reference")
	private String reference;

	@SerializedName("phone_insured_client")
	private String phoneInsuredClient;

	@SerializedName("other_order")
	private String otherOrder;

	@SerializedName("detail")
	private Detail detail;

	@SerializedName("email")
	private String email;

	public void setAddress(String address){
		this.address = address;
	}

	public String getAddress(){
		return address;
	}

	public void setInsuredClient(String insuredClient){
		this.insuredClient = insuredClient;
	}

	public String getInsuredClient(){
		return insuredClient;
	}

	public void setNoticeofdamage(String noticeofdamage){
		this.noticeofdamage = noticeofdamage;
	}

	public String getNoticeofdamage(){
		return noticeofdamage;
	}

	public void setContactPerson(String contactPerson){
		this.contactPerson = contactPerson;
	}

	public String getContactPerson(){
		return contactPerson;
	}

	public void setSignature(String signature){
		this.signature = signature;
	}

	public String getSignature(){
		return signature;
	}

	public void setWork(String work){
		this.work = work;
	}

	public String getWork(){
		return work;
	}

	public void setObservation(String observation){
		this.observation = observation;
	}

	public String getObservation(){
		return observation;
	}

	public void setPhoneContactPerson(String phoneContactPerson){
		this.phoneContactPerson = phoneContactPerson;
	}

	public String getPhoneContactPerson(){
		return phoneContactPerson;
	}

	public void setReference(String reference){
		this.reference = reference;
	}

	public String getReference(){
		return reference;
	}

	public void setPhoneInsuredClient(String phoneInsuredClient){
		this.phoneInsuredClient = phoneInsuredClient;
	}

	public String getPhoneInsuredClient(){
		return phoneInsuredClient;
	}

	public void setOtherOrder(String otherOrder){
		this.otherOrder = otherOrder;
	}

	public String getOtherOrder(){
		return otherOrder;
	}

	public void setDetail(Detail detail){
		this.detail = detail;
	}

	public Detail getDetail(){
		return detail;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	@Override
 	public String toString(){
		return 
			"ListItem{" + 
			"address = '" + address + '\'' + 
			",insured_client = '" + insuredClient + '\'' + 
			",noticeofdamage = '" + noticeofdamage + '\'' + 
			",contact_person = '" + contactPerson + '\'' + 
			",signature = '" + signature + '\'' + 
			",work = '" + work + '\'' + 
			",observation = '" + observation + '\'' + 
			",phone_contact_person = '" + phoneContactPerson + '\'' + 
			",reference = '" + reference + '\'' + 
			",phone_insured_client = '" + phoneInsuredClient + '\'' + 
			",other_order = '" + otherOrder + '\'' + 
			",detail = '" + detail + '\'' + 
			",email = '" + email + '\'' + 
			"}";
		}
}