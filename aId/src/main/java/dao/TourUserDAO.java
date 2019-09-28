package dao;

import java.util.List;

import models.TourUserData;
import models.UserData;

public interface TourUserDAO {
	// CRUD - Create, Read, Update, Delete
	// UserData getUserById();
	public TourUserData getTourUserByIdTourAndByIdUser(int idTour, int idUser);

	public List<TourUserData> getAllToursUsers();

	boolean saveTourUser(TourUserData tourUserData);

	boolean deleteTourUser(int idTour, int idUser);

	boolean updateTourUser(int idTour, int idUser, int newIdTour, int newIdUser);

}
