package com.hireme.hireme.mapper;

import com.hireme.hireme.dto.NewUserDTO;
import com.hireme.hireme.dto.UpdateUserDTO;
import com.hireme.hireme.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    JobMapper INSTANCE = Mappers.getMapper(JobMapper.class);

    NewUserDTO newUserToDto(User user);
    User newUser(NewUserDTO userDTO);
    UpdateUserDTO updateUserToDto(User user);
    void updateUserFromDto(UpdateUserDTO updateUserDTO, @MappingTarget User updateUser);
}
