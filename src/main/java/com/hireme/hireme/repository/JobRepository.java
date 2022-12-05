package com.hireme.hireme.repository;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hireme.hireme.model.Job;

public interface JobRepository extends JpaRepository<Job, Long>{
	
	Optional<ArrayList<Job>> findByJobTitle(String jobTitle);
}
