package com.zhelezov.unikoom.rest.mapper;

import com.zhelezov.unikoom.data.entity.User;
import com.zhelezov.unikoom.rest.dto.UserDto;
import com.zhelezov.unikoom.rest.dto.UserShortDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface UserMapper {

    @Mapping(target = "photo", expression = "java(new String(saved.getPhoto()))")
     UserDto toDto(User saved);

    UserShortDto toUserShortDto(User user);

    @Mapping(target = "photo", expression = "java(userDto.getPhoto().getBytes())")
    User toEntity(UserDto userDto);
}
