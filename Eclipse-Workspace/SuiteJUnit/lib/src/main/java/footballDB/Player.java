package footballDB;

import java.io.Serializable;


public class Player implements Serializable {

	private Integer id;

	private Integer clubid;

	private String firstname;

	private String lastname;

	private String nationality;

	public Player() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getClubid() {
		return this.clubid;
	}

	public void setClubid(Integer clubid) {
		this.clubid = clubid;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getNationality() {
		return this.nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
}