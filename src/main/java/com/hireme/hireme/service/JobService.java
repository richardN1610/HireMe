package com.hireme.hireme.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.hireme.hireme.DTO.NewJobDTO;
import com.hireme.hireme.Exceptions.JobException;
import com.hireme.hireme.model.Job;
import com.hireme.hireme.repository.JobRepository;

public class JobService {
	
	@Autowired
	private JobRepository jobRepository;

	public JobService(JobRepository jobRepository) {
		super();
		this.jobRepository = jobRepository;
	}
	
	public Job addJob(NewJobDTO jobDTO) {
		Job job = new Job();
		BeanUtils.copyProperties(jobDTO, job);
		return jobRepository.save(job);
	}
	
	public Job updateJob(NewJobDTO jobDTO) throws JobException{
		Job foundJob = jobRepository.findById(jobDTO.getJobId()).orElseThrow(() -> new JobException("Job not found."));
		BeanUtils.copyProperties(jobDTO, foundJob);
		return jobRepository.save(foundJob);
	}
	
	public Long deleteJob(Long jobId) throws JobException {
		Job foundJob = jobRepository.findById(jobId).orElseThrow(() -> new JobException("Job not found."));
		jobRepository.deleteById(foundJob.getJobId());
		return foundJob.getJobId();
	}
	
	public ArrayList<Job> viewAllJobs(){
		
	}
}
