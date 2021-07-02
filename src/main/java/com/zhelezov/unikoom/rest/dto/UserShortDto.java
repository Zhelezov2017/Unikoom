package com.zhelezov.unikoom.rest.dto;

import lombok.Data;


@Data
public class UserShortDto {
    private Long id;
    private String username;
    private String fullName;
}
