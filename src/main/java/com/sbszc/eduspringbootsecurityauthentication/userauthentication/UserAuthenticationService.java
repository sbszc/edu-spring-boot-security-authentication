package com.sbszc.eduspringbootsecurityauthentication.userauthentication;

import com.sbszc.eduspringbootsecurityauthentication.dto.UserAuthenticationDto;
import com.sbszc.eduspringbootsecurityauthentication.entity.UserAuthentication;
import com.sbszc.eduspringbootsecurityauthentication.exception.RoleNotFoundException;
import com.sbszc.eduspringbootsecurityauthentication.exception.UserExistsException;
import com.sbszc.eduspringbootsecurityauthentication.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class UserAuthenticationService {

    @Autowired
    private UserAuthenticationRepository userAuthenticationRepository;

    @Autowired
    private UserRolRepository userRolRepository;

    public List<UserAuthentication> findAll() {

        return userAuthenticationRepository.findAll();
    }

    public UserAuthentication findById(String username) {

        return userAuthenticationRepository.findById(username)
                .orElseThrow(() -> new UserNotFoundException("User '" + username + "' not found"));
    }

    public UserAuthentication save(UserAuthenticationDto userAuthenticationDto) {

        if (userAuthenticationRepository.existsById(userAuthenticationDto.getUsername()))
            throw new UserExistsException("User '" + userAuthenticationDto.getUsername() + "' already exists");

        if (!CollectionUtils.isEmpty(userAuthenticationDto.getUserRoles())) {
            userAuthenticationDto.getUserRoles().forEach(userRol -> {
                if (userRolRepository.existsById(userRol.getRole()))
                    throw new RoleNotFoundException("Role '" + userRol.getRole() + "' not found");
            });
        }

        return userAuthenticationRepository.save(new UserAuthentication(userAuthenticationDto));
    }

    public UserAuthentication update(UserAuthenticationDto userAuthenticationDto) {

        if (!userAuthenticationRepository.existsById(userAuthenticationDto.getUsername()))
            throw new UserNotFoundException("User '" + userAuthenticationDto.getUsername() + "' not found");

        if (!CollectionUtils.isEmpty(userAuthenticationDto.getUserRoles())) {
            userAuthenticationDto.getUserRoles().forEach(userRol -> {
                if (userRolRepository.existsById(userRol.getRole()))
                    throw new RoleNotFoundException("Role '" + userRol.getRole() + "' not found");
            });
        }

        return userAuthenticationRepository.save(new UserAuthentication(userAuthenticationDto));
    }

    public UserAuthentication delete(String username) {

        UserAuthentication userToDelete = userAuthenticationRepository.findById(username)
                .orElseThrow(() -> new UserNotFoundException("User '" + username + "' not found"));

        userAuthenticationRepository.deleteById(username);

        return userToDelete;
    }

}
