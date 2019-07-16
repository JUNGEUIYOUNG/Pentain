package jp.co.pentain.sample.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import jp.co.pentain.sample.domain.entity.Users;
import jp.co.pentain.sample.domain.repository.UsersRepository;
import jp.co.pentain.sample.login.DTO.LoginUser;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class UsersDetailServiceImp implements UserDetailsService {

	@Autowired
	private UsersRepository usersRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		Users users = usersRepository.findByEmail(email);
		log.debug(users.toString());

		LoginUser loginUser = new LoginUser(users);

		return loginUser;
	}

}