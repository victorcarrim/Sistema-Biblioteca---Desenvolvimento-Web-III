package models;

public class User {
	private Integer id;
	private String name;
	private String email;
	private String password;
	private TypeUser type;
	
	public User(Integer id, String name, String email, String password, String typeUser) {
		setId(id);
		setName(name);
		setEmail(email);
		setPassword(password);
		setType(typeUser);
	}
	
	public User(String name, String email, String password, String typeUser) {
		setName(name);
		setEmail(email);
		setPassword(password);
		setType(typeUser);
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public TypeUser getType() {
		return type;
	}
	public String getTypeDAO() {
		return type.toString();
	}
	public void setType(String typeUser) {
		if(typeUser.equals("CLIENT")) {
			this.type = TypeUser.CLIENT;
		} else {
			this.type = TypeUser.ADMIN;
		}
	}
	
	
}
