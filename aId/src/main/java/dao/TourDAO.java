package dao;

import java.util.List;

import models.TourData;
import models.UserData;

public interface TourDAO {
	//CRUD - Create, Read, Update, Delete
	// UserData getUserById();
	public TourData getTourById(int idTour);
	
	public List<TourData> getAllTours();

	boolean saveTour(TourData tourData);
	
	boolean deleteTour(int idTour);
	
	boolean updateTour(int idTour, double price);
	
}
