package jp.co.pentain.sample.setup;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/setup")
public class UserController {

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String user(Model model) throws Exception{
		if(true) {
			throw new Exception();
		}
		return "/setup/user";
	}

	@RequestMapping(value = "/user/add", method = RequestMethod.POST)
	public String userAdd(Model model) {
		return "/setup/user";
	}
}
