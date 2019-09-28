package models;

public class TourUserData {
	private int idTour;
	private int idUser;

	public TourUserData() {
		super();
	}

	public TourUserData(int idTour, int idUser) {
		super();
		this.idTour = idTour;
		this.idUser = idUser;
	}

	public int getIdTour() {
		return idTour;
	}

	public void setIdTour(int idTour) {
		this.idTour = idTour;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	@Override
	public String toString() {
		return "TourUserData [idTour=" + idTour + ", idUser=" + idUser + "]";
	}

}
