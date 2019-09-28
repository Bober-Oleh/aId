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
import dao.TourUserDAO;
import dbutils.DataSourceUtils;
import models.TourUserData;

public class DefaultTourUserDAO implements TourUserDAO {

	public static final String SELECT_TOUR_USER_BY_TOUR_ID_AND_BY_USER_ID = "SELECT * FROM toursusers WHERE idTour = ? and idUser = ?";
	public static final String SELECT_ALL_TOURS_USERS = "SELECT * FROM toursusers";
	public static final String INSERT_TOUR_USER = "INSERT INTO toursusers (idTour, idUser) VALUES (?, ?)";
	public static final String DELETE_TOUR_USER_BY_TOUR_ID_AND_BY_USER_ID = "DELETE FROM toursusers WHERE idTour = ? and idUser = ?";
	public static final String UPDATE_TOUR_USER_BY_TOUR_ID_AND_BY_USER_ID = "UPDATE toursusers SET idTour = ? and idUser = ? WHERE idTour = ? and idUser = ?";
	private static DefaultTourUserDAO instance;
	private DataSource ds;

	public DefaultTourUserDAO() {
		this.ds = DataSourceUtils.getDataSource();
	}

	public static synchronized DefaultTourUserDAO getTourUserDaoInstance() {

		if (instance == null) {
			instance = new DefaultTourUserDAO();
		}
		return instance;
	}


	@Override
	public TourUserData getTourUserByIdTourAndByIdUser(int idTour, int idUser) {
		TourUserData tourUserData = null;

		  try (Connection conn = ds.getConnection();
	                PreparedStatement statement = conn.prepareStatement(SELECT_TOUR_USER_BY_TOUR_ID_AND_BY_USER_ID);) {

	            if (conn != null) {
	                System.out.println("Yeees,we have connection!");
	            } else {
	                System.out.println("Ohhhh.. we don't have connection.");
	            }

			statement.setInt(1, idTour);
			statement.setInt(2, idUser);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				tourUserData = new TourUserData();
				tourUserData.setIdTour(rs.getInt("idTour"));
				tourUserData.setIdUser(rs.getInt("idUser"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tourUserData;
	}

	@Override
	public List<TourUserData> getAllToursUsers() {
		List<TourUserData> allToursUsers = new ArrayList<>();

		try (Connection conn = ds.getConnection(); PreparedStatement statement = conn.prepareStatement(SELECT_ALL_TOURS_USERS);) {

            if (conn != null) {
                System.out.println("Yeees,we have connection!");
            } else {
                System.out.println("Ohhhh.. we don't have connection.");
            }
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				TourUserData tourUserData = new TourUserData();
				tourUserData.setIdTour(rs.getInt("idTour"));
				tourUserData.setIdUser(rs.getInt("idUser"));

				allToursUsers.add(tourUserData);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allToursUsers;
	}

	@Override
	public boolean saveTourUser(TourUserData tourUserData) {
		boolean result = true;

		  try (Connection conn = ds.getConnection();
	                PreparedStatement statement = conn.prepareStatement(INSERT_TOUR_USER);) {

	            if (conn != null) {
	                System.out.println("Yeees,we have connection!");
	            } else {
	                System.out.println("Ohhhh.. we don't have connection.");
	            }
			statement.setInt(1, tourUserData.getIdTour());
			statement.setInt(2, tourUserData.getIdUser());

			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			result = false;
		}
		return result;
	}

	@Override
	public boolean deleteTourUser(int idTour, int idUser) {
		boolean result = true;

		try (Connection conn = ds.getConnection();
                PreparedStatement statement = conn.prepareStatement(DELETE_TOUR_USER_BY_TOUR_ID_AND_BY_USER_ID);) {

            if (conn != null) {
                System.out.println("Yeees,we have connection!");
            } else {
                System.out.println("Ohhhh.. we don't have connection.");
            }

			statement.setInt(1, idTour);
			statement.setInt(2, idUser);
			statement.executeUpdate();
			System.out.println("TourUser with idTour and idUser=" + idTour + idUser + " has been deleted!");

		} catch (SQLException e) {
			e.printStackTrace();
			result = false;
		}
		return result;
	}

	@Override
	public boolean updateTourUser(int idTour, int idUser, int newIdTour, int newIdUser) {
		boolean result = true;

		try (Connection conn = ds.getConnection();
                PreparedStatement statement = conn.prepareStatement(UPDATE_TOUR_USER_BY_TOUR_ID_AND_BY_USER_ID);) {

            if (conn != null) {
                System.out.println("Yeees,we have connection!");
            } else {
                System.out.println("Ohhhh.. we don't have connection.");
            }
			statement.setInt(1, idTour);
			statement.setInt(2, idUser);
			statement.setInt(3, newIdTour);
			statement.setInt(4, newIdUser);
			statement.executeUpdate();
			System.out.println("TourUser with idTour =" + idTour + " and idUser= " + idUser + " has been deleted!");
			System.out.println("New idTour=" + newIdTour);
			System.out.println("New idUSer=" + newIdUser);

		} catch (SQLException e) {
			e.printStackTrace();
			result = false;
		}
		return result;
	}

}
