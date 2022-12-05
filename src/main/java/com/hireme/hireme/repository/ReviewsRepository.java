package com.hireme.hireme.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hireme.hireme.model.CompanyReview;

@Repository
public interface ReviewsRepository extends JpaRepository<CompanyReview,Long>{

	ArrayList<CompanyReview> findByCompany_companyId(Long id);
	ArrayList<CompanyReview> findByCompany_companyName(String name);
}
