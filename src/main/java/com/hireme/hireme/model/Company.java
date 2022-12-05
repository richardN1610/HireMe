package com.hireme.hireme.model;

import java.util.ArrayList;

import com.hireme.hireme.enums.Industries;

import jakarta.persistence.Entity;
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
@Table(name ="companies")
public class Company {

	@Id
	@GeneratedValue
	private Long companyId;
	private Long companyReputation;
	private Industries industry;
	private String companyName,companySize, companyLocation, companyWebsite;
	private ArrayList<Job> jobList;
}
