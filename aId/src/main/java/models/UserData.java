package models;

public class UserData {
	public static final int ADMIN_ROLE = 5;
	private int idUser;
	private String firstName;
	private String lastName;
	private String dateBirthday;
	private String email;
	private String password;
	private int idRole;
	private int toursNumber;

	public UserData() {

	}

	public UserData(String firstName, String lastName, String dateBirthday, String email, String password,
			int idRole, int toursNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateBirthday = dateBirthday;
		this.email = email;
		this.password = password;
		this.idRole = idRole;
		this.toursNumber = toursNumber;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDateBirthday() {
		return dateBirthday;
	}

	public void setDateBirthday(String dateBirthday) {
		this.dateBirthday = dateBirthday;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getIdRole() {
		return idRole;
	}

	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}

	public int getToursNumber() {
		return toursNumber;
	}

	public void setToursNumber(int toursNumber) {
		this.toursNumber = toursNumber;
	}

	@Override
	public String toString() {
		return "UserData [idUser=" + idUser + ", firstName=" + firstName + ", lastName=" + lastName + ", dateBirthday="
				+ dateBirthday + ", email=" + email + ", password=" + password + ", idRole=" + idRole + ", toursNumber="
				+ toursNumber + "]";
	}

	

}
// alt shift s generate geter setter