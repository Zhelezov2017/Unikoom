package com.zhelezov.unikoom.rest.mapper;

import com.zhelezov.unikoom.data.entity.User;
import com.zhelezov.unikoom.rest.dto.UserDto;
import com.zhelezov.unikoom.rest.dto.UserShortDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface UserMapper {
    User userDtoToUser(UserDto userDto);

    UserDto userToUserDto(User saved);

    UserShortDto userToUserShortDto(User user);
}
