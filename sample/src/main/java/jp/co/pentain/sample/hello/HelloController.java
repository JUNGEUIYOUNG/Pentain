package jp.co.pentain.sample.hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {

	@RequestMapping(value="/hello", method=RequestMethod.GET)
	public String hello() {
		return "hello";
	}

	@RequestMapping(value="/hello2", method=RequestMethod.GET)
	public String hello2(Model model) {
		model.addAttribute("message", "Hello World");
		return "hello2";
	}
}
