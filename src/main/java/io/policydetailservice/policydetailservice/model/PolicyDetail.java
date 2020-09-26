package io.policydetailservice.policydetailservice.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class PolicyDetail {
	@Id
	@GeneratedValue
	private Long id;
	private String policyNumber;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="policy_id")
	private List<Driver> drivers;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="premium_id")
	private Premium totalPremium;
	
	public PolicyDetail(){
		
	}
	
	public PolicyDetail(String policyNumber) {
		super();
		this.policyNumber = policyNumber;
	}
	public String getPolicyNumber() {
		return policyNumber;
	}
	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}
	public List<Driver> getDrivers() {
		return drivers;
	}
	public void setDrivers(List<Driver> drivers) {
		this.drivers = drivers;
	}
	public Premium getTotalPremium() {
		return totalPremium;
	}
	public void setTotalPremium(Premium totalPremium) {
		this.totalPremium = totalPremium;
	}
	

}
