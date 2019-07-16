package jp.co.pentain.sample.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.pentain.sample.login.service.UsersDetailServiceImp;

@Controller
public class SearchController {

	@Autowired
	public UsersDetailServiceImp userService;

	@RequestMapping(value="/common/search", method = RequestMethod.GET)
	public String search(Model model) {

	}


}
