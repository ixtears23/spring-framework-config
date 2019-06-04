package com.ibdata.project2;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Locale;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextHierarchy(value = {
		@ContextConfiguration("classpath:config/**/*-context.xml"),
		@ContextConfiguration("classpath:config/servlet/dispatcher-servlet.xml")
})

@WebAppConfiguration
public class UserControllerTest {

	@Autowired
	private WebApplicationContext applicationContext;
	
	private MockMvc mockMvc;
	
	
	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.applicationContext).build();
	}
	
	@Test
	@Transactional
	public void insertUserTest() throws Exception {
		this.mockMvc.perform(get("/insertUser.do")
				.param("id", "ojs")
				.param("name", "junseok")
				.param("emain", "ojs@ibdata.co.kr")
				.param("phone", "01026162419")
				.param("sex", "man")
				.locale(Locale.KOREA))
		.andDo(print())
		.andExpect(status().isOk());
		
		this.mockMvc.perform(get("/selectUserOne.do")
				.param("id", "ojs")
				.locale(Locale.KOREA))
		.andDo(print())
		.andExpect(status().isOk());
	}
}
