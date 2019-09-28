package impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import dao.RoleDAO;
import dbutils.DataSourceUtils;
import models.RoleData;

public class DefaultRoleDAO implements RoleDAO {


	public static final String SELECT_ROLE_BY_ID = "SELECT * FROM roles WHERE idRole = ?";
	public static final String SELECT_ALL_ROLES = "SELECT * FROM roles";
	public static final String INSERT_ROLE = "INSERT INTO roles (roleName, discount) VALUES (?, ?)";
	public static final String DELETE_ROLE_BY_ID = "DELETE FROM roles WHERE idRole = ?";
	public static final String UPDATE_ROLE_BY_ID = "UPDATE roles SET discount = ? WHERE idRole = ?";

	private static DefaultRoleDAO instance;
	private DataSource ds;

	public DefaultRoleDAO() {
		this.ds = DataSourceUtils.getDataSource();
	}

	public static synchronized DefaultRoleDAO getRoleDaoInstance() {

		if (instance == null) {
			instance = new DefaultRoleDAO();
		}
		return instance;
	}

	@Override
	public RoleData getRoleById(int idRole) {
		RoleData roleData = null;

		 try (Connection conn = ds.getConnection();
	                PreparedStatement statement = conn.prepareStatement(SELECT_ROLE_BY_ID);) {

	            if (conn != null) {
	                System.out.println("Yeees,we have connection!");
	            } else {
	                System.out.println("Ohhhh.. we don't have connection.");
	            }


			statement.setInt(1, idRole);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				roleData = new RoleData();
				roleData.setIdRole(rs.getInt("idRole"));
				roleData.setRoleName(rs.getString("roleName"));
				roleData.setDiscount(rs.getString("discount"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return roleData;
	}

	@Override
	public List<RoleData> getAllRoles() {
		List<RoleData> allRoles = new ArrayList<>();


        try (Connection conn = ds.getConnection();
                PreparedStatement statement = conn.prepareStatement(SELECT_ALL_ROLES);) {

            if (conn != null) {
                System.out.println("Yeees,we have connection!");
            } else {
                System.out.println("Ohhhh.. we don't have connection.");
            }
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				RoleData roleData = new RoleData();
				roleData.setIdRole(rs.getInt("idRole"));
				roleData.setRoleName(rs.getString("roleName"));
				roleData.setDiscount(rs.getString("discount"));

				allRoles.add(roleData);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allRoles;
	}

	@Override
	public boolean saveRole(RoleData roleData) {
		boolean result = true;

		 try (Connection conn = ds.getConnection(); PreparedStatement statement = conn.prepareStatement(INSERT_ROLE);) {

	            if (conn != null) {
	                System.out.println("Yeees,we have connection!");
	            } else {
	                System.out.println("Ohhhh.. we don't have connection.");
	            }
			statement.setString(1, roleData.getRoleName());
			statement.setString(2, roleData.getDiscount());

			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			result = false;
		}
		return result;
	}

	@Override
	public boolean deleteRole(int idRole) {
	    boolean result = true;

        try (Connection conn = ds.getConnection();
                PreparedStatement statement = conn.prepareStatement(DELETE_ROLE_BY_ID);) {

            if (conn != null) {
                System.out.println("Yeees,we have connection!");
            } else {
                System.out.println("Ohhhh.. we don't have connection.");
            }
            statement.setInt(1, idRole);
            statement.executeUpdate();
            System.out.println("Role with idRole=" + idRole + " has been deleted!");

        } catch (SQLException e) {
            e.printStackTrace();
            result = false;
        }
        return result;
	}

	@Override
	public boolean updateRole(int idRole, String discount) {
	    boolean result = true;

	    try (Connection conn = ds.getConnection();
                PreparedStatement statement = conn.prepareStatement(UPDATE_ROLE_BY_ID);) {

            if (conn != null) {
                System.out.println("Yeees,we have connection!");
            } else {
                System.out.println("Ohhhh.. we don't have connection.");
            }

            statement.setString(1, discount);
            statement.setInt(2, idRole);
            statement.executeUpdate();
            System.out.println("Role with idRole=" + idRole + " has been updated!");
            System.out.println("New discount=" + discount);

        } catch (SQLException e) {
            e.printStackTrace();
            result = false;
        }
        return result;
	}

}
