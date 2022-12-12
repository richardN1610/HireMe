package com.hireme.hireme.service;


import com.hireme.hireme.mapper.UserMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.hireme.hireme.dto.NewUserDTO;
import com.hireme.hireme.dto.UpdateUserDTO;
import com.hireme.hireme.model.User;
import com.hireme.hireme.repository.UserRepository;

import com.hireme.hireme.exceptions.UserException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserMapper userMapper;
	
	private BCryptPasswordEncoder passwordEncoder;
	
	public User saveUser(NewUserDTO userDTO) throws UserException {
		if(userRepository.existsByEmail(userDTO.getEmail()))
			throw new UserException("Email address is not valid. Please try something else"); 
		
		userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));	
		
		User user = userMapper.newUser(userDTO);

		return userRepository.save(user);
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

		userMapper.updateUserFromDto(updateUser,user);

		return userRepository.save(user);
	}
}
