package bean;

public class UserBean {
	
	private String id;
	private String password;
	private String name;
	private String email;
	
	public UserBean() {}
	
	public UserBean(String id, String password) {
		this.id = id;
		this.password = password;
	}
	public UserBean(String id, String password, String name, String email) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.email = email;
	}
	
	public UserBean(String id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	}
	
	public String getUserId() {
		return id;
	}
	public void setUserId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
