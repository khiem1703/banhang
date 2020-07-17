package trungtamjava.dao;

import java.util.List;

import trungtamjava.entity.User;
import trungtamjava.model.UserDTO;

public interface UserDao {
	public void addUser(User user);
	public void deleteUser(int id);
	public void updateUser(User user);
	public User getUserbyId(int id);
	public List<User> getAllUser ();

}
