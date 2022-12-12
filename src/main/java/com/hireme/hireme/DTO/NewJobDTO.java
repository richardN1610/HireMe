package com.hireme.hireme.dto;

import java.util.ArrayList;
import java.util.Date;

import com.hireme.hireme.enums.Industries;
import com.hireme.hireme.enums.JobTypes;

import lombok.Data;

@Data
public class NewJobDTO {
	private Long jobId;
	private String jobTitle, jobDescription, jobSalary, jobBenefits, jobShift;
	private ArrayList<JobTypes> jobTypes;
	private Industries jobIndustry;
	private Date postDate,jobExpiryDate;
}
