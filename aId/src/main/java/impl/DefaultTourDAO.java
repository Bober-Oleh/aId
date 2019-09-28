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

import dao.TourDAO;
import dbutils.DataSourceUtils;
import models.TourData;


public class DefaultTourDAO implements TourDAO {

	public static final String SELECT_TOUR_BY_ID = "SELECT * FROM tours WHERE idTour = ?";
	public static final String SELECT_ALL_TOURS = "SELECT * FROM tours";
	public static final String INSERT_TOUR = "INSERT INTO tours (title, description, dateTour, price, hotel) VALUES (?, ?, ?, ?, ?)";
	public static final String DELETE_TOUR_BY_ID = "DELETE FROM tours WHERE idTour = ?";
	public static final String UPDATE_TOUR_BY_ID = "UPDATE tours SET price = ? WHERE idTour = ?";
	private static DefaultTourDAO instance;
	private DataSource ds;

	public DefaultTourDAO() {
		this.ds = DataSourceUtils.getDataSource();
	}

	public static synchronized DefaultTourDAO getTourDaoInstance() {

		if (instance == null) {
			instance = new DefaultTourDAO();
		}
		return instance;
	}

	@Override
	public TourData getTourById(int idTour) {
		TourData tourData = null;

		 try (Connection conn = ds.getConnection();
	                PreparedStatement statement = conn.prepareStatement(SELECT_TOUR_BY_ID);) {

	            if (conn != null) {
	                System.out.println("Yeees,we have connection!");
	            } else {
	                System.out.println("Ohhhh.. we don't have connection.");
	            }
			statement.setInt(1, idTour);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				tourData = new TourData();
				tourData.setIdTour(rs.getInt("idTour"));
				tourData.setTitle(rs.getString("title"));
				tourData.setDescription(rs.getString("description"));
				tourData.setDateTour(rs.getString("dateTour"));
				tourData.setPrice(rs.getDouble("price"));
				tourData.setHotel(rs.getString("hotel"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tourData;
	}

	@Override
	public List<TourData> getAllTours() {
		List<TourData> allTours = new ArrayList<>();

		try (Connection conn = ds.getConnection(); PreparedStatement statement = conn.prepareStatement(SELECT_ALL_TOURS);) {

            if (conn != null) {
                System.out.println("Yeees,we have connection!");
            } else {
                System.out.println("Ohhhh.. we don't have connection.");
            }

			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				TourData tourData = new TourData();

				tourData.setIdTour(rs.getInt("idTour"));
				tourData.setTitle(rs.getString("title"));
				tourData.setDescription(rs.getString("description"));
				tourData.setDateTour(rs.getString("dateTour"));
				tourData.setPrice(rs.getDouble("price"));
				tourData.setHotel(rs.getString("hotel"));

				allTours.add(tourData);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allTours;
	}

	@Override
	public boolean saveTour(TourData tourData) {
		boolean result = true;
		try (Connection conn = ds.getConnection(); PreparedStatement statement = conn.prepareStatement(INSERT_TOUR);) {

            if (conn != null) {
                System.out.println("Yeees,we have connection!");
            } else {
                System.out.println("Ohhhh.. we don't have connection.");
            }

			statement.setString(1, tourData.getTitle());
			statement.setString(2, tourData.getDescription());
			statement.setString(3, tourData.getDateTour());
			statement.setDouble(4, tourData.getPrice());
			statement.setString(5, tourData.getHotel());

			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			result = false;
		}
		return result;
	}

	@Override
	public boolean deleteTour(int idTour) {
		boolean result = true;
		try (Connection conn = ds.getConnection(); PreparedStatement statement = conn.prepareStatement(DELETE_TOUR_BY_ID);) {

            if (conn != null) {
                System.out.println("Yeees,we have connection!");
            } else {
                System.out.println("Ohhhh.. we don't have connection.");
            }

			statement.setInt(1, idTour);
			statement.executeUpdate();
			System.out.println("Tour with idTour=" + idTour + " has been deleted!");

		} catch (SQLException e) {
			e.printStackTrace();
			result = false;
		}
		return result;
	}

	@Override
	public boolean updateTour(int idTour, double price) {
		boolean result = true;

		try (Connection conn = ds.getConnection(); PreparedStatement statement = conn.prepareStatement(UPDATE_TOUR_BY_ID);) {

            if (conn != null) {
                System.out.println("Yeees,we have connection!");
            } else {
                System.out.println("Ohhhh.. we don't have connection.");
            }


			statement.setDouble(1, price);
			statement.setInt(2, idTour);
			statement.executeUpdate();
			System.out.println("Tour with idTour=" + idTour + " has been updated!");
			System.out.println("New price=" + price);

		} catch (SQLException e) {
			e.printStackTrace();
			result = false;
		}
		return result;
	}

}
