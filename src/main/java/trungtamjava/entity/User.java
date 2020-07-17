package trungtamjava.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity(name = "USER")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_u")
	private int id;

	@Column(name="name_u")
	private String name;

	@Column(name="phone_u")
	private String phoneNumber;

	public User() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	

}