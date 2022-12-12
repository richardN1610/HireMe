package com.hireme.hireme.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hireme.hireme.model.Company;
import com.hireme.hireme.model.CompanyReview;
import com.hireme.hireme.model.Job;

public interface CompanyRepository extends JpaRepository<Company, Long>{
	List<CompanyReview> findAllReviewsById(Long companyId);
}
