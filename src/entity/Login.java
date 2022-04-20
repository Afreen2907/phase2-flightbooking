package entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="login")
public class Login implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "useremail")
	private String userEmail;
	
	
	@Column(name = "password")
    private String password;
	

	public Login() {}


	public Login(String userEmail, String password) {
		super();
		this.userEmail = userEmail;
		this.password = password;
	}


	public String getUserEmail() {
		return userEmail;
	}


	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	
	

}
