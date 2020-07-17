package trungtamjava.model;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

public class UserDTO {
	@Min(0)
	private int id;
	@NotEmpty
	private String name;
	private String phoneNumber;
	@Length(min = 6,max = 12)
	private String password;
	private String favourist;
	private String gender;
	private MultipartFile avatar;

	
	
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public MultipartFile getAvatar() {
		return avatar;
	}

	public void setAvatar(MultipartFile avatar) {
		this.avatar = avatar;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

	public String getFavourist() {
		return favourist;
	}

	public void setFavourist(String favourist) {
		this.favourist = favourist;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setName(String name) {
		this.name = name;
	}

}
