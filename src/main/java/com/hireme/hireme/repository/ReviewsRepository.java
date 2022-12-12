package com.hireme.hireme.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hireme.hireme.model.CompanyReview;

@Repository
public interface ReviewsRepository extends JpaRepository<CompanyReview,Long>{

	List<CompanyReview> findByCompanyCompanyId(Long id);
	List<CompanyReview> findByCompanyCompanyReviews(String name);
}
