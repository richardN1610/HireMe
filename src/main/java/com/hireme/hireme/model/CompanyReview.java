package com.hireme.hireme.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "company_reviews")
public class CompanyReview {

	private Long reviewId;
	private String pros, cons,jobTitle;
	private int benefitsPerks,workLifeBalance,careerDevelopment,workingEnvironment,management,diversityEquals;
	private Date startMonth, endMonth, startYear,endYear;
	private boolean stillInRole;
	
	@OneToMany(mappedBy="company")
	private Company company;
}
