package com.uz.localfoodeliveryservice.mapper;

import com.uz.localfoodeliveryservice.dto.request.UserUpdateRequest;
import com.uz.localfoodeliveryservice.dto.response.UserResponse;
import com.uz.localfoodeliveryservice.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface UserMapper {
    UserResponse userResponse(User user);
    User userEntity( UserUpdateRequest userUpdateRequest);

}
