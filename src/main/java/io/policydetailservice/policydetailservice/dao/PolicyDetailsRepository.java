package io.policydetailservice.policydetailservice.dao;

import io.policydetailservice.policydetailservice.model.PolicyDetail;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PolicyDetailsRepository extends JpaRepository<PolicyDetail, Long>{
	PolicyDetail findByPolicyNumber(String policyNumber);
}
