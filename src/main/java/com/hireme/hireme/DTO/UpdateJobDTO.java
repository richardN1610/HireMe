package com.hireme.hireme.dto;

import java.util.ArrayList;

import com.hireme.hireme.enums.Industries;
import com.hireme.hireme.enums.JobTypes;

import lombok.Data;

@Data
public class UpdateJobDTO {
	private Long jobId;
	private String jobTitle, jobDescription, jobSalary, jobBenefits, jobShift;
	private ArrayList<JobTypes> jobTypes;
	private Industries jobIndustry;
}
