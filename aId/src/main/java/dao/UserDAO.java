package dao;

import java.util.List;

import models.UserData;

public interface UserDAO {
	//CRUD - Create, Read, Update, Delete
	// UserData getUserById();
	public UserData getUserById(int idUser);
	
	public List<UserData> getAllUsers();

	boolean saveUser(UserData userData);
	
	boolean deleteUser(int idUser);
	
	boolean updateUser(int idUser, String email);
	
}
