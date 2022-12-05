package com.hireme.hireme.model;

import java.util.ArrayList;
import java.util.Date;

import com.hireme.hireme.enums.Industries;
import com.hireme.hireme.enums.JobTypes;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
@Table(name="jobs")
public class Job {

	@Id
	@GeneratedValue
	private Long jobId;
	private String jobTitle, jobDescription, jobSalary, jobBenefits, jobShift;
	private ArrayList<JobTypes> jobTypes;
	private Industries jobIndustry;
	private Date postDate,jobExpiryDate;
}
