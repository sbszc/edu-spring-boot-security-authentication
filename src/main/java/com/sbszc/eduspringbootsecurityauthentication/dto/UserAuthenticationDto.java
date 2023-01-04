package com.sbszc.eduspringbootsecurityauthentication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAuthenticationDto implements Serializable {

    @NotBlank(message = "username is required")
    private String username;

    @NotBlank(message = "password is required")
    private String password;

    @NotNull(message = "isAccountNonExpired is required")
    private Boolean isAccountNonExpired;

    @NotNull(message = "isAccountNonLocked is required")
    private Boolean isAccountNonLocked;

    @NotNull(message = "isCredentialsNonExpired is required")
    private Boolean isCredentialsNonExpired;

    @NotNull(message = "isEnabled is required")
    private Boolean isEnabled;

    @Valid
    private List<UserRoleDto> userRoles;
}
