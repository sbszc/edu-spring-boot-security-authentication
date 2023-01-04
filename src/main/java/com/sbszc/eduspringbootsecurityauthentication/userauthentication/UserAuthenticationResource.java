package com.sbszc.eduspringbootsecurityauthentication.userauthentication;

import com.sbszc.eduspringbootsecurityauthentication.dto.UserAuthenticationDto;
import com.sbszc.eduspringbootsecurityauthentication.dto.UserAuthenticationResponse;
import com.sbszc.eduspringbootsecurityauthentication.entity.UserAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/user-authentication")
public class UserAuthenticationResource {

    @Autowired
    private UserAuthenticationService userAuthenticationService;

    @GetMapping
    public ResponseEntity<UserAuthenticationResponse> findAll() {

        List<UserAuthentication> foundUsers = userAuthenticationService.findAll();

        UserAuthenticationResponse body = UserAuthenticationResponse.builder()
                .messages("found users")
                .data(foundUsers)
                .build();

        return new ResponseEntity<>(body, HttpStatus.OK);
    }

    @GetMapping("{username}")
    public ResponseEntity<UserAuthenticationResponse> findById(
            @PathVariable String username) {

        UserAuthentication foundUser = userAuthenticationService.findById(username);

        UserAuthenticationResponse body = UserAuthenticationResponse.builder()
                .messages("found user")
                .data(foundUser)
                .build();

        return new ResponseEntity<>(body, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<UserAuthenticationResponse> save(
            @Valid @RequestBody UserAuthenticationDto userAuthenticationDto) {

        UserAuthentication savedUser = userAuthenticationService.save(userAuthenticationDto);

        UserAuthenticationResponse body = UserAuthenticationResponse.builder()
                .messages("saved user")
                .data(savedUser)
                .build();

        return new ResponseEntity<>(body, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<UserAuthenticationResponse> update(
            @Valid @RequestBody UserAuthenticationDto userAuthenticationDto) {

        UserAuthentication updatedUser = userAuthenticationService.update(userAuthenticationDto);

        UserAuthenticationResponse body = UserAuthenticationResponse.builder()
                .messages("updated user")
                .data(updatedUser)
                .build();

        return new ResponseEntity<>(body, HttpStatus.OK);
    }

    @DeleteMapping("{username}")
    public ResponseEntity<UserAuthenticationResponse> delete(
            @PathVariable String username) {

        UserAuthentication deletedUser = userAuthenticationService.delete(username);

        UserAuthenticationResponse body = UserAuthenticationResponse.builder()
                .messages("deleted user")
                .data(deletedUser)
                .build();

        return new ResponseEntity<>(body, HttpStatus.OK);
    }

    @GetMapping("ping")
    public String ping() {
        return "ping";
    }

}
