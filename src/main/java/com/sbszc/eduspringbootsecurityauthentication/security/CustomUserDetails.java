//package com.sbszc.eduspringbootsecurityauthentication.security;//package com.sbszc.eduspringbootsecurityauthentication.security;
//
//import com.sbszc.eduspringbootsecurityauthentication.entity.UserAuthentication;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Collection;
//import java.util.stream.Collectors;
//
//public class CustomUserDetails implements UserDetails {
//
//    private final UserAuthentication userAuthentication;
//
//    public CustomUserDetails(UserAuthentication userAuthentication) {
//        this.userAuthentication = userAuthentication;
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return userAuthentication.getUserRoles().stream()
//                .map(userRol -> new SimpleGrantedAuthority("ROLE_" + userRol.getRole()))
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public String getPassword() {
//        return userAuthentication.getPassword();
//    }
//
//    @Override
//    public String getUsername() {
//        return userAuthentication.getUsername();
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return userAuthentication.getIsAccountNonExpired();
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return userAuthentication.getIsAccountNonLocked();
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return userAuthentication.getIsCredentialsNonExpired();
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return userAuthentication.getIsEnabled();
//    }
//
//}
