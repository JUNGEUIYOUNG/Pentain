package jp.co.pentain.sample.hello;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.pentain.sample.domain.entity.Users;
import jp.co.pentain.sample.domain.repository.UsersRepository;


@Controller
public class UsersController {

	@Autowired
	private UsersRepository usersRepository;


	@RequestMapping(value = "/adduser", method = RequestMethod.GET)
	public String addUser(Model model) {

		List<Users> userlist = usersRepository.findAll();
		return "hello";
	}

}
