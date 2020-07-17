package trungtamjava.service;

import java.util.List;

import trungtamjava.model.UserDTO;

public interface UserService {
	public void addUser(UserDTO user);

	public void deleteUser(int id);

	public void updateUser(UserDTO user);

	public UserDTO getUserbyId(int id);

	public List<UserDTO> getAllUser();
}
