package com.sbszc.eduspringbootsecurityauthentication.userauthentication;

import com.sbszc.eduspringbootsecurityauthentication.entity.UserAuthentication;
import com.sbszc.eduspringbootsecurityauthentication.entity.UserRole;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
public class UserAuthenticationRepositoryTest {

	@Autowired
	private UserAuthenticationRepository userAuthenticationRepository;

	@Test
	public void insertUsers() {
		UserAuthentication userAuthentication1 = new UserAuthentication();
		userAuthentication1.setUsername("user1");
		userAuthentication1.setPassword("pass1");
		userAuthentication1.setIsEnabled(true);
		userAuthentication1.setIsAccountNonLocked(true);
		userAuthentication1.setIsAccountNonExpired(true);
		userAuthentication1.setIsCredentialsNonExpired(true);

		UserAuthentication userAuthentication2 = new UserAuthentication();
		userAuthentication2.setUsername("user2");
		userAuthentication2.setPassword("pass2");
		userAuthentication2.setIsEnabled(true);
		userAuthentication2.setIsAccountNonLocked(true);
		userAuthentication2.setIsAccountNonExpired(true);
		userAuthentication2.setIsCredentialsNonExpired(true);

		UserAuthentication userAuthentication3 = new UserAuthentication();
		userAuthentication3.setUsername("user3");
		userAuthentication3.setPassword("pass3");
		userAuthentication3.setIsEnabled(true);
		userAuthentication3.setIsAccountNonLocked(true);
		userAuthentication3.setIsAccountNonExpired(true);
		userAuthentication3.setIsCredentialsNonExpired(true);

		userAuthenticationRepository.saveAll(List.of(userAuthentication1, userAuthentication2, userAuthentication3));
		
		userAuthenticationRepository.findAll().forEach(System.out::println);
	}

	@Test
	public void insertUsersWithRoles() {
		UserRole userRole1 = new UserRole();
		userRole1.setRole("role1");

		UserRole userRole2 = new UserRole();
		userRole2.setRole("role2");

		UserRole userRole3 = new UserRole();
		userRole3.setRole("role3");

		UserAuthentication userAuthentication1 = new UserAuthentication();
		userAuthentication1.setUsername("user1");
		userAuthentication1.setPassword("pass1");
		userAuthentication1.setIsEnabled(true);
		userAuthentication1.setIsAccountNonLocked(true);
		userAuthentication1.setIsAccountNonExpired(true);
		userAuthentication1.setIsCredentialsNonExpired(true);
		userAuthentication1.setUserRoles(List.of(userRole1, userRole2));

		UserAuthentication userAuthentication2 = new UserAuthentication();
		userAuthentication2.setUsername("user2");
		userAuthentication2.setPassword("pass2");
		userAuthentication2.setIsEnabled(true);
		userAuthentication2.setIsAccountNonLocked(true);
		userAuthentication2.setIsAccountNonExpired(true);
		userAuthentication2.setIsCredentialsNonExpired(true);
		userAuthentication2.setUserRoles(List.of(userRole2, userRole3));

		UserAuthentication userAuthentication3 = new UserAuthentication();
		userAuthentication3.setUsername("user3");
		userAuthentication3.setPassword("pass3");
		userAuthentication3.setIsEnabled(true);
		userAuthentication3.setIsAccountNonLocked(true);
		userAuthentication3.setIsAccountNonExpired(true);
		userAuthentication3.setIsCredentialsNonExpired(true);
		userAuthentication3.setUserRoles(List.of(userRole1, userRole3));

		userAuthenticationRepository.saveAll(List.of(userAuthentication1, userAuthentication2, userAuthentication3));

		userAuthenticationRepository.findAll().forEach(System.out::println);
	}

	@Test
	public void findUsers() {
		userAuthenticationRepository.findAll().forEach(System.out::println);
	}
}
