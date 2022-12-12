package com.hireme.hireme.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.mapstruct.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;

import com.hireme.hireme.model.Job;

public interface JobRepository extends JpaRepository<Job, Long>{
	
	Optional<List<Job>> findByJobTitle(String jobTitle);
	Optional<List<Job>> findAllByJobExpiryDate(LocalDate date);


}
