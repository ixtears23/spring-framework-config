package com.ibdata.project2;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ibdata.project2.service.UserCopyService;
import com.ibdata.project2.vo.UserCopy;

/**
 * Handles requests for the application home page.
 */
@Controller
public class UserController {
	
//	private static final Logger logger = LogManager.getLogger(UserController.class);
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserCopyService userCopyService;
	
	@GetMapping("/login.do")
	public String login() {
		return "login";
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/User.do", method = RequestMethod.GET)
	public String home(Locale locale, Model model) throws Exception {
		logger.debug("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		System.out.println("test");
		
//		httpRequest.textRequest();
		
		UserCopy user = new UserCopy();
		user.setId("001");
		
		List<UserCopy> selectUser = userCopyService.selectUserAll();
		
		logger.debug("selectUser ::: {}", selectUser);
		
		return "home";
	}
	
	@RequestMapping(value = "/selectUserOne.do", method = RequestMethod.GET)
	public String insertUser(Locale locale, 
			@RequestParam String id) throws Exception {
		UserCopy user = userCopyService.selectUserOne(id);
		
		logger.debug("user ::: {}", user);
		
		return "home";
	}
	
	
	@RequestMapping(value = "/insertUser.do", method = RequestMethod.GET)
	public String insertUser(Locale locale, 
			@RequestParam String id,
			@RequestParam String name,
			@RequestParam String emain,
			@RequestParam String phone,
			@RequestParam String sex) throws Exception {
		UserCopy userCopy = new UserCopy(id, name, emain, phone, sex);
		userCopyService.insertUser(userCopy);
		
		return "home";
	}
	
	@RequestMapping(value = "/updateUser.do", method = RequestMethod.GET)
	public String updateUser(Locale locale, 
			@RequestParam String id,
			@RequestParam String name,
			@RequestParam String emain,
			@RequestParam String phone,
			@RequestParam String sex) throws Exception {
		UserCopy userCopy = new UserCopy(id, name, emain, phone, sex);
		userCopyService.updateUser(userCopy);
		return "home";
	}
	
	
	@RequestMapping(value = "/insertMaria.do", method = RequestMethod.GET)
	public String insertMaria(
			@RequestParam String id,
			@RequestParam String name,
			@RequestParam String age) throws Exception {
		UserCopy userCopy = new UserCopy();
		userCopy.setId(id);;
		userCopy.setName(name);
		userCopy.setAge(age);
		userCopyService.insertMaria(userCopy);
		return "home";
	}
	
}
