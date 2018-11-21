package app.model;

import java.io.Serializable;
import java.util.List;

public class Role implements Serializable{

	private static final long serialVersionUID = 8841379482322599481L;
	private Integer id;
	private String name;
	private String description;
	private List<User> users;

	public Role() {
	}

	public Role(Integer id, String name, String description, List<User> users) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.users = users;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
}
