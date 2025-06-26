package com.uz.localfoodeliveryservice.mapper;

import com.uz.localfoodeliveryservice.dto.request.UserUpdateRequest;
import com.uz.localfoodeliveryservice.dto.response.UserResponse;
import com.uz.localfoodeliveryservice.entity.User;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel="spring")
public interface UserMapper {
    UserResponse userResponse(User user);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateUserFromDto(UserUpdateRequest request, @MappingTarget User user);
}
