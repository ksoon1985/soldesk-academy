package kr.co.sol;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/h")
	public String hello() {
		System.out.println(111);
		return "NewFile222";
	}
	
}
