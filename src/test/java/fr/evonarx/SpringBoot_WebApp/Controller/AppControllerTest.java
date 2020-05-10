package fr.evonarx.SpringBoot_WebApp.Controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(AppController.class)
public class AppControllerTest {

	// to get an idea how to do...google 'Spring boot test' ;-)
	@Autowired
	MockMvc mockMvc;
	
	@Test 
	public void hello() throws Exception {
		mockMvc.perform(get("/help")).andExpect(status().isOk())
		.andExpect(content().string(containsString("use /home1; /home2?name=Eric to get different messages...")));
	 }
}
