package com.zhelezov.unikoom.rest.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ByteArraySerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.zhelezov.unikoom.data.entity.Sex;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long id;
    private String username;
    private String fullName;
    private String email;
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate dateOfBirth;
    private Sex sex;
    private String photo;
}
