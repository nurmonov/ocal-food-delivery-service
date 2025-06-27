package com.uz.localfoodeliveryservice.mapper;

import com.uz.localfoodeliveryservice.dto.UserDto;
import com.uz.localfoodeliveryservice.entity.User;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel="spring")
public interface UserMapper {
    UserDto userResponse(User user);
   User user(UserDto userDto);
}
