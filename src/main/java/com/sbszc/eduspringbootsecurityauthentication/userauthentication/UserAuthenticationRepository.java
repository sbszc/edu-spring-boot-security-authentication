package com.sbszc.eduspringbootsecurityauthentication.userauthentication;

import com.sbszc.eduspringbootsecurityauthentication.entity.UserAuthentication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAuthenticationRepository extends JpaRepository<UserAuthentication, String> {

}
