package com.hireme.hireme.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.hireme.hireme.mapper.JobMapper;
import org.apache.coyote.Response;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.hireme.hireme.dto.NewJobDTO;
import com.hireme.hireme.dto.UpdateJobDTO;
import com.hireme.hireme.model.Job;
import com.hireme.hireme.repository.JobRepository;

import com.hireme.hireme.exceptions.JobException;
import org.springframework.http.ResponseEntity;

public class JobService {
	
	@Autowired
	private JobRepository jobRepository;

	@Autowired
	private JobMapper jobMapper;

	public JobService(JobRepository jobRepository, JobMapper jobMapper) {
		super();
		this.jobRepository = jobRepository;
		this.jobMapper = jobMapper;
	}
	
	public Job addJob(NewJobDTO jobDTO) {
		Job newJob = jobMapper.newJob(jobDTO);
		return jobRepository.save(newJob);
	}
	
	public Job updateJob(UpdateJobDTO updateJob) throws JobException{
		Job foundJob = 	jobRepository.findById(updateJob.getJobId()).orElseThrow(() -> new JobException("Job not found."));
		jobMapper.updateJobFromDto(updateJob, foundJob);
		return jobRepository.save(foundJob);
	}
	
	public Long deleteJob(Long jobId) throws JobException {
		Job foundJob = jobRepository.findById(jobId).orElseThrow(() -> new JobException("Job not found."));
		jobRepository.deleteById(foundJob.getJobId());
		return foundJob.getJobId();
	}
	
	public List<NewJobDTO> viewAllJobs(){
		return jobMapper.jobListToDto(jobRepository.findAll());
	}
	
	public int deleteExpiredJobs() throws JobException {
		LocalDate today = LocalDate.now();
		Optional<List<Job>> expiredJobList = jobRepository.findAllByJobExpiryDate(today);

		for (Job foundJob : expiredJobList.get()) {
			if(foundJob.getJobExpiryDate().isBefore(today)) {
				deleteJob(foundJob.getJobId());
			}
		}
		return expiredJobList.get().size();		
	}
}
