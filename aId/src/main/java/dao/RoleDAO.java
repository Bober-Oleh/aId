package dao;

import java.util.List;

import models.RoleData;

public interface RoleDAO {
	// CRUD - Create, Read, Update, Delete
	// UserData getUserById();
	public RoleData getRoleById(int idRole);

	public List<RoleData> getAllRoles();

	boolean saveRole(RoleData roleData);

	boolean deleteRole(int idRole);

	boolean updateRole(int idRole, String discount);

}
