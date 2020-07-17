package trungtamjava.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import trungtamjava.entity.User;
import trungtamjava.model.UserDTO;
import trungtamjava.service.UserService;

@Controller
public class UserController {
	@Autowired
	UserService userService;
	
	
	@RequestMapping(value = "/listuser" ,method = RequestMethod.GET)
	public String getAllUser(HttpServletRequest request) {
		List<UserDTO> users = userService.getAllUser();
		for (UserDTO user : users) {
			System.out.println(user.getId());
		}
		request.setAttribute("users", users);
		return "user/list-user";
		
	}
	
	@RequestMapping(value = "/chi-tiet/{userId}" ,method = RequestMethod.GET)
	public String viewUser(HttpServletRequest request ,@PathVariable(value ="userId") int userId) {
		UserDTO user = userService.getUserbyId(userId);
		request.setAttribute("user", user);
		return "user/viewUser";		
	}
	
	@RequestMapping(value = { "addUser" }, method = RequestMethod.GET)
	public String addUser(HttpServletRequest request) {
		UserDTO user = new UserDTO();
		user.setName("defaul name");
		request.setAttribute("user", user);
		return "user/addUser";
	}
	@RequestMapping(value = { "addUser" }, method = RequestMethod.POST)
	public String addUser(HttpServletRequest request, @ModelAttribute("user") @Valid UserDTO user,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "user/addUser";
		}
		userService.addUser(user);
		request.setAttribute("user", user);
		return "user/viewUser";
	}

}
