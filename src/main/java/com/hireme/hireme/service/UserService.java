package com.hireme.hireme.service;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.hireme.hireme.DTO.NewUserDTO;
import com.hireme.hireme.DTO.UpdateUserDTO;
import com.hireme.hireme.Exceptions.UserException;
import com.hireme.hireme.model.User;
import com.hireme.hireme.repository.UserRepository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	private BCryptPasswordEncoder passwordEncoder;
	
	public User saveUser(NewUserDTO userDTO) throws UserException {
		if(userRepository.existsByEmail(userDTO.getEmail()))
			throw new UserException("Email address is not valid. Please try something else"); 
		
		userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));	
		
		User user = new User();
		BeanUtils.copyProperties(userDTO, user);
		
		userRepository.save(user);
		return user;
	}
	
	public void deleteUser(Long userId) throws UserException {
		if(!userRepository.existsById(userId)) {
			throw new UserException("User not found exception.");
		}
		userRepository.deleteById(userId);
	}
	
	public User updateUserDetails(UpdateUserDTO updateUser) throws UserException {
		User user = userRepository.findByEmail(updateUser.getEmail())
				.orElseThrow(() -> new UserException("Invalid credentials, please try again."));
		
		if(userRepository.existsByEmail(updateUser.getEmail())){
			throw new UserException("Email is already being used.");
		}
		if(userRepository.existsByMobile(updateUser.getMobile())) {
			throw new UserException("Mobile number is already being used.");
		}
			
		user.setPassword(passwordEncoder.encode(updateUser.getPassword()));	
		user.setFirstName(updateUser.getFirstName());
		user.setLastName(updateUser.getLastNameString());
		user.setMobile(updateUser.getMobile());
		user.setEmail(updateUser.getEmail());

		return user;
	}
}
