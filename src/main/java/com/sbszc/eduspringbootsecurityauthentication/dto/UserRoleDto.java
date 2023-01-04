package com.sbszc.eduspringbootsecurityauthentication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRoleDto {

    @NotBlank(message = "role is required")
    private String role;
}
