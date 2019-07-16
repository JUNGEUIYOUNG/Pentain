package jp.co.pentain.sample.login.DTO;

import org.springframework.security.core.authority.AuthorityUtils;

import jp.co.pentain.sample.domain.entity.Users;
import lombok.Getter;

@Getter
public class LoginUser extends  org.springframework.security.core.userdetails.User{

	private Users users;

	public LoginUser(Users users) {

		super(users.getEmail(), users.getPasswd(), AuthorityUtils.createAuthorityList("ROLE_USER"));
		this.users = users;
	}
}