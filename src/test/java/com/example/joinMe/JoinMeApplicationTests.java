package com.example.joinMe;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class JoinMeApplicationTests {

	@Autowired
	MockMvc mvc;


	@Autowired
	private JoinMeRepository repository;

	@Autowired
	ObjectMapper mapper;


	@Test
	void contextLoads() {
	}


	@Test
	public void testGetActivity() throws Exception {
		mvc.perform(
				MockMvcRequestBuilders.get("/activity")
		)
				.andExpect(status().is2xxSuccessful())
				.andExpect(MockMvcResultMatchers.content().string(containsString("activity")))
				.andExpect(MockMvcResultMatchers.content().string(containsString("Cloud-Native Applications in Java")))
				.andExpect(MockMvcResultMatchers.content().string(containsString("Spring Boot in Action")));
	}


	@Test
	public void testAddActivity() throws Exception {

		//Activity a = new Activity(0, "New eat activity", "test.testson@hm.com", 8, DateUtil.toModelDate("2020-12-20 13:00"), "Home", 1, 1);
        //repository.addActivity(a, 2);


		mvc.perform(
				MockMvcRequestBuilders.get("/addActivity")
		)
				.andExpect(status().is2xxSuccessful())
				.andExpect(MockMvcResultMatchers.content().string(containsString("activity")))
				.andExpect(MockMvcResultMatchers.content().string(containsString("Cloud-Native Applications in Java")))
				.andExpect(MockMvcResultMatchers.content().string(containsString("Spring Boot in Action")));
	}
}
