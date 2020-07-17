package trungtamjava.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import trungtamjava.dao.UserDao;
import trungtamjava.entity.User;
import trungtamjava.model.UserDTO;
import trungtamjava.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserDao userDao;

	
	
	public UserServiceImpl() {
		super();
	}
	// covert từ userDTO sang user (trong db)
	public void addUser(UserDTO userDTO) {
		// TODO Auto-generated method stub
		User user = new User();
		user.setName(userDTO.getName());
		user.setPhoneNumber(userDTO.getPhoneNumber());
		userDao.addUser(user);	
	}

	public void deleteUser(int id) {
		User user =userDao.getUserbyId(id);
		if(user!= null) {
			
			userDao.deleteUser(id);
		}
	}

	public void updateUser(UserDTO userDTO) {
		User user =userDao.getUserbyId(userDTO.getId());
		if(user!= null) {
			user.setName(userDTO.getName());
			user.setPhoneNumber(userDTO.getPhoneNumber());
			userDao.updateUser(user);
		}
		
		// TODO Auto-generated method stub
		
	}

	public UserDTO getUserbyId(int id) {
		
		User user = userDao.getUserbyId(id);
		
		UserDTO userDTO = new UserDTO();
		userDTO.setId(user.getId());
		userDTO.setName(user.getName());
		userDTO.setPhoneNumber(user.getPhoneNumber());
		
		return userDTO;
	}

	public List<UserDTO> getAllUser() {
		List<User> users = userDao.getAllUser();
		List<UserDTO> userDTOs= new ArrayList<UserDTO>();
		for (User user : users) {
			
			UserDTO userDTO = new UserDTO();
			
			userDTO.setId(user.getId());
			userDTO.setName(user.getName());
			userDTO.setPhoneNumber(user.getPhoneNumber());
			userDTOs.add(userDTO);		
		}
		for (UserDTO userDTO : userDTOs) {
			System.out.println(userDTO.getId());
		}
		
		return userDTOs;
		
	}
}
