package models;

public class TourData {
	
	private int idTour;
	private String title;
	private String description;
	private String dateTour;
	private double price;
	private String hotel;
	
	public TourData() {
		super();
	}

	public TourData(String title, String description, String dateTour, double price, String hotel) {
		super();
		this.title = title;
		this.description = description;
		this.dateTour = dateTour;
		this.price = price;
		this.hotel = hotel;
	}

	public int getIdTour() {
		return idTour;
	}

	public void setIdTour(int idTour) {
		this.idTour = idTour;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDateTour() {
		return dateTour;
	}

	public void setDateTour(String dateTour) {
		this.dateTour = dateTour;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getHotel() {
		return hotel;
	}

	public void setHotel(String hotel) {
		this.hotel = hotel;
	}

	@Override
	public String toString() {
		return "TourData [idTour=" + idTour + ", title=" + title + ", description=" + description + ", dateTour="
				+ dateTour + ", price=" + price + ", hotel=" + hotel + "]";
	}

	
	

}
