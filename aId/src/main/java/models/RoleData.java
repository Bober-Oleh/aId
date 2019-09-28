package models;

public class RoleData {
	private int idRole;
	private String roleName;
	private String discount;
	public RoleData() {
		
	}
	public RoleData(String roleName, String discount) {
		
		this.roleName = roleName;
		this.discount = discount;
	}
	public int getIdRole() {
		return idRole;
	}
	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getDiscount() {
		return discount;
	}
	public void setDiscount(String discount) {
		this.discount = discount;
	}
	@Override
	public String toString() {
		return "RoleData [idRole=" + idRole + ", roleName=" + roleName + ", discount=" + discount + "]";
	}

}
