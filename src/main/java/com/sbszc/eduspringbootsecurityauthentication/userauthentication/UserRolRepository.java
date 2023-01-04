package com.sbszc.eduspringbootsecurityauthentication.userauthentication;

import com.sbszc.eduspringbootsecurityauthentication.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRolRepository extends JpaRepository<UserRole, String> {

}
