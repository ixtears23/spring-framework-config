package com.ibdata.project2;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.ibdata.project2.service.UserCopyService;
import com.ibdata.project2.vo.UserCopy;

public class UserControllerUnitTest {

	@Mock
	private UserCopyService userCopyService;
	
	@InjectMocks
	private UserController userController;
	
	private MockMvc mockMvc;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
	}
	
	@Test
	public void loginViewTest() throws Exception {
		
		this.mockMvc.perform(get("/login.do"))
				.andDo(print())
			.andExpect(status().isOk())
			.andExpect(view().name("login"));
	}
	
	@Test
	public void selectUserOneTest() throws Exception {
		
		UserCopy userCopy = new UserCopy("005", "asjosh", null, null, null);
		when(userCopyService.selectUserOne("001")).thenReturn(userCopy);
//		verify(userCopyService, times(1)).selectUserOne("001");
		verifyNoMoreInteractions(userCopyService);
		
		
	}
	
}
