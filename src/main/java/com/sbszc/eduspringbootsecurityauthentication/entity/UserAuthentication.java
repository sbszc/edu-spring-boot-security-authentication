package com.sbszc.eduspringbootsecurityauthentication.entity;

import com.sbszc.eduspringbootsecurityauthentication.dto.UserAuthenticationDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAuthentication implements Serializable {

    @Id
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private Boolean isAccountNonExpired;

    @Column(nullable = false)
    private Boolean isAccountNonLocked;

    @Column(nullable = false)
    private Boolean isCredentialsNonExpired;

    @Column(nullable = false)
    private Boolean isEnabled;

    @ManyToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    @JoinTable(
            name = "userauthentication_userrole",
            joinColumns = @JoinColumn(
                    name = "username",
                    referencedColumnName = "username"),
            inverseJoinColumns = @JoinColumn(
                    name = "role",
                    referencedColumnName = "role"))
    private List<UserRole> userRoles;

    public UserAuthentication(UserAuthenticationDto userAuthenticationDto) {
        this.username = userAuthenticationDto.getUsername();
        this.password = userAuthenticationDto.getPassword();
        this.isAccountNonExpired = userAuthenticationDto.getIsAccountNonExpired();
        this.isAccountNonLocked = userAuthenticationDto.getIsAccountNonLocked();
        this.isCredentialsNonExpired = userAuthenticationDto.getIsCredentialsNonExpired();
        this.isEnabled = userAuthenticationDto.getIsEnabled();

        if (userAuthenticationDto.getUserRoles() != null) {
            this.userRoles = userAuthenticationDto.getUserRoles().stream()
                    .map(UserRole::new)
                    .collect(Collectors.toList());
        }
    }

}
