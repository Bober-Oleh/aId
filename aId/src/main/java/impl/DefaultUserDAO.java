package impl;

import dao.UserDAO;
import dbutils.DataSourceUtils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import models.UserData;

public class DefaultUserDAO implements UserDAO {

	public static final String SELECT_USER_BY_ID = "SELECT * FROM users WHERE idUser = ?";
	public static final String SELECT_ALL_USERS = "SELECT * FROM users";
	public static final String INSERT_USER = "INSERT INTO users (firstName, lastName, dateBirthday, email, password, idRole, toursNumber) VALUES (?, ?, ?, ?, ?, ?, ?)";
	public static final String DELETE_USER_BY_ID = "DELETE FROM users WHERE idUser = ?";
	public static final String UPDATE_USER_BY_ID = "UPDATE users SET email = ? WHERE idUser = ?";
	private static DefaultUserDAO instance;
	private DataSource ds;

	public DefaultUserDAO() {
		this.ds = DataSourceUtils.getDataSource();
	}

	public static synchronized DefaultUserDAO getUserDaoInstance() {

		if (instance == null) {
			instance = new DefaultUserDAO();
		}
		return instance;
	}

	@Override
    public UserData getUserById(int idUser) {
        UserData userData = null;

        try (Connection conn = ds.getConnection();
                PreparedStatement statement = conn.prepareStatement(SELECT_USER_BY_ID);) {

            if (conn != null) {
                System.out.println("Yeees,we have connection!");
            } else {
                System.out.println("Ohhhh.. we don't have connection.");
            }

            statement.setInt(1, idUser);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                userData = new UserData();
                userData.setIdUser(rs.getInt("idUser"));
                userData.setFirstName(rs.getString("firstName"));
                userData.setLastName(rs.getString("lastName"));
                userData.setDateBirthday(rs.getString("dateBirthday"));
                userData.setEmail(rs.getString("email"));
                userData.setPassword(rs.getString("password"));
                userData.setIdRole(rs.getInt("idRole"));
                userData.setToursNumber(rs.getInt("toursNumber"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userData;
    }


	@Override
    public boolean saveUser(UserData userData) {

        boolean result = true;

        try (Connection conn = ds.getConnection(); PreparedStatement statement = conn.prepareStatement(INSERT_USER);) {

            if (conn != null) {
                System.out.println("Yeees,we have connection!");
            } else {
                System.out.println("Ohhhh.. we don't have connection.");
            }

            statement.setString(1, userData.getFirstName());
            statement.setString(2, userData.getLastName());
            statement.setString(3, userData.getDateBirthday());
            statement.setString(4, userData.getEmail());
            statement.setString(5, userData.getPassword());
            statement.setInt(6, userData.getIdRole());
            statement.setInt(7, userData.getToursNumber());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            result = false;
        }
        return result;
    }

	@Override
    public List<UserData> getAllUsers() {
        // TODO Auto-generated method stub
        List<UserData> allUsers = new ArrayList<>();

        try (Connection conn = ds.getConnection();
                PreparedStatement statement = conn.prepareStatement(SELECT_ALL_USERS);) {

            if (conn != null) {
                System.out.println("Yeees,we have connection!");
            } else {
                System.out.println("Ohhhh.. we don't have connection.");
            }

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                UserData userData = new UserData();

                userData.setIdUser(rs.getInt("idUser"));
                userData.setFirstName(rs.getString("firstName"));
                userData.setLastName(rs.getString("lastName"));
                userData.setDateBirthday(rs.getString("dateBirthday"));
                userData.setEmail(rs.getString("email"));
                userData.setPassword(rs.getString("password"));
                userData.setFirstName(rs.getString("firstName"));
                userData.setIdRole(rs.getInt("idRole"));
                userData.setToursNumber(rs.getInt("toursNumber"));

                allUsers.add(userData);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allUsers;
    }

    @Override
    public boolean deleteUser(int idUser) {
        boolean result = true;

        try (Connection conn = ds.getConnection();
                PreparedStatement statement = conn.prepareStatement(DELETE_USER_BY_ID);) {

            if (conn != null) {
                System.out.println("Yeees,we have connection!");
            } else {
                System.out.println("Ohhhh.. we don't have connection.");
            }

            statement.setInt(1, idUser);
            statement.executeUpdate();
            System.out.println("User with idUser=" + idUser + " has been deleted!");

        } catch (SQLException e) {
            e.printStackTrace();
            result = false;
        }
        return result;
    }

    @Override
    public boolean updateUser(int idUser, String email) {
        boolean result = true;

        try (Connection conn = ds.getConnection();
                PreparedStatement statement = conn.prepareStatement(UPDATE_USER_BY_ID);) {

            if (conn != null) {
                System.out.println("Yeees,we have connection!");
            } else {
                System.out.println("Ohhhh.. we don't have connection.");
            }

            statement.setString(1, email);
            statement.setInt(2, idUser);
            statement.executeUpdate();
            System.out.println("User with idUser=" + idUser + " has been updated!");
            System.out.println("New email=" + email);

        } catch (SQLException e) {
            e.printStackTrace();
            result = false;
        }
        return result;
    }

}

