package io.policydetailservice.policydetailservice.service;

import io.policydetailservice.policydetailservice.dao.PolicyDetailsRepository;
import io.policydetailservice.policydetailservice.model.PolicyDetail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PolicyDetailsService {
	
	@Autowired
	PolicyDetailsRepository repo;

	public PolicyDetail saveNewPolicy(PolicyDetail policy) {
		// TODO Auto-generated method stub
		return repo.save(policy);
	}
	
	public PolicyDetail findByPolicyNumber(String policyNumber){
		return repo.findByPolicyNumber(policyNumber);
	}

}
