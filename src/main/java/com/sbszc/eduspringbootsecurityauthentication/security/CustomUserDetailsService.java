//package com.sbszc.eduspringbootsecurityauthentication.security;//package com.sbszc.eduspringbootsecurityauthentication.security;
//
//import com.sbszc.eduspringbootsecurityauthentication.entity.UserAuthentication;
//import com.sbszc.eduspringbootsecurityauthentication.exception.UserNotFoundException;
//import com.sbszc.eduspringbootsecurityauthentication.userauthentication.UserAuthenticationRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class CustomUserDetailsService implements UserDetailsService {
//
//    @Autowired
//    private UserAuthenticationRepository userAuthenticationRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        UserAuthentication userAuthentication =
//                userAuthenticationRepository.findById(username)
//                        .orElseThrow(() -> new UserNotFoundException("User '" + username + "' not found"));
//
//        return new CustomUserDetails(userAuthentication);
//    }
//
//}
