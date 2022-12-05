package com.hireme.hireme.DTO;

import com.hireme.hireme.model.User;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class NewUserDTO {
	private Long id;
	private String firstName, lastName, email, mobileNumber,password;
}
