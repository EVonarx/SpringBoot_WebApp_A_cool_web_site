package fr.evonarx.SpringBoot_WebApp.Controller;

import java.lang.annotation.Repeatable;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AppController {

	@GetMapping("/help")
	@ResponseBody // the string that is returned by the method is the content of the HTML body and
					// not a template
	public String help() {
		return "<br/><h1>Use /home1 to display a static page</h1><br/> "
				+ "<h1>Use /home2?name=Eric to display a dynamic page (using Thymeleaf templates)</h1><br/>"
				+ "<h1 style=\"color:green\">Click  <a href=\"https://itericvonarx.wordpress.com/\">here</a> to visit my IT Blog ;-)</h1>";
	}

	@GetMapping("/home")
	@ResponseBody // same as /help
	public String home() {
		return "<br/><h1>Use /home1 to display a static page</h1> <br/> "
				+ "<h1>Use /home2?name=Eric to display a dynamic page (using Thymeleaf templates)</h1><br/>"
				+ "<h1 style=\"color:green\">Click  <a href=\"https://itericvonarx.wordpress.com/\">here</a> to visit my IT Blog ;-)</h1>";
	}

	// display a static page and also the parameter name in the console (for tests
	// purposes)
	@GetMapping("/home1")
	public String home1(HttpServletRequest request) {

		String name = "World";
		if (request.getParameter("name") != null && !request.getParameter("name").isEmpty())
			name = request.getParameter("name");

		System.out.println(name);
		return "pages/home1";
	}

	// display a dynamic page using thymeleaf....
	@GetMapping("/home2")
	public String home2(HttpServletRequest request, ModelMap mm) {

		String name = "World";
		if (request.getParameter("name") != null && !request.getParameter("name").isEmpty())
			name = request.getParameter("name");

		System.out.println(name);
		mm.put("key", name);
		return "pages/home2";
	}

	// same as home2 in the Spring Boot way
	@GetMapping("/home22")
	public String home22(@RequestParam(defaultValue = "World") String name, ModelMap mm) {
		mm.put("key", name);
		return "pages/home2";
	}

}
