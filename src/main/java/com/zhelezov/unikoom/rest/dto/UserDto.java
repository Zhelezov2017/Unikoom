package com.zhelezov.unikoom.rest.dto;

import com.zhelezov.unikoom.data.entity.Sex;
import lombok.Data;
import java.time.LocalDate;

@Data
public class UserDto {
    private Long id;
    private String username;
    private String fullName;
    private String email;
    private LocalDate dateOfBirth;
    private Sex sex;
    private byte[] photo;
}
