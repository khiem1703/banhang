package trungtamjava.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import trungtamjava.dao.UserDao;
import trungtamjava.entity.User;

@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	SessionFactory sessionFactory;


	public void addUser(User user) {
		sessionFactory.getCurrentSession().save(user);
	}

	public void deleteUser(int id) {
		sessionFactory.getCurrentSession().delete(getUserbyId(id));

		
	}

	public void updateUser(User user) {
		sessionFactory.getCurrentSession().merge(user);

		
	}

	// queryForObject : sellect 1 đối tượng
	public User getUserbyId(int id) {
		return (User) sessionFactory.getCurrentSession().get(User.class, id);
		
		
	}
	// query : sellect nhiều đối tượng

	public List<User> getAllUser() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
		
		return criteria.list();
		

	}
}
