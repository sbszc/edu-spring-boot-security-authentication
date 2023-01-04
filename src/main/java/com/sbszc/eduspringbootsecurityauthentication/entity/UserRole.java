package com.sbszc.eduspringbootsecurityauthentication.entity;

import com.sbszc.eduspringbootsecurityauthentication.dto.UserRoleDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRole implements Serializable {

    @Id
    private String role;

    public UserRole(UserRoleDto userRoleDto) {
        this.role = userRoleDto.getRole();
    }

}
