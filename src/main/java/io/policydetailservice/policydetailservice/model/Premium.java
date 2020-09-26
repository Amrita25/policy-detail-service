package io.policydetailservice.policydetailservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Premium {
	
	@Id
	@GeneratedValue
	private long id;
	private long grossPremium;
	private long commission;
	private long netPremium;
	
	public Premium(){
		
	}
	
	public Premium(long grossPremium, long commission, long netPremium) {
		super();
		this.grossPremium = grossPremium;
		this.commission = commission;
		this.netPremium = netPremium;
	}
	public long getGrossPremium() {
		return grossPremium;
	}
	public void setGrossPremium(long grossPremium) {
		this.grossPremium = grossPremium;
	}
	public long getCommission() {
		return commission;
	}
	public void setCommission(long commission) {
		this.commission = commission;
	}
	public long getNetPremium() {
		return netPremium;
	}
	public void setNetPremium(long netPremium) {
		this.netPremium = netPremium;
	}
	
	



}
