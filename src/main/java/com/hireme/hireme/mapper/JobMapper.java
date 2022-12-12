package com.hireme.hireme.mapper;

import com.hireme.hireme.dto.NewJobDTO;
import org.hibernate.sql.Update;
import org.mapstruct.Mapper;

import com.hireme.hireme.dto.UpdateJobDTO;
import com.hireme.hireme.model.Job;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface JobMapper {

	JobMapper INSTANCE = Mappers.getMapper(JobMapper.class);
	UpdateJobDTO jobToUpdateJobDTO(Job job);
	void updateJobFromDto(UpdateJobDTO updateJobDTO, @MappingTarget Job jobToUpdate);
	NewJobDTO jobToNewJobDTO(Job job);
	Job newJob(NewJobDTO newJobDTO);
	List<NewJobDTO> jobListToDto(List<Job> jobs);
}
