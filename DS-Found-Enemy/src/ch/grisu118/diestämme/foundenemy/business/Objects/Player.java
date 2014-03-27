package ch.grisu118.diestämme.foundenemy.business.Objects;

public class Player {

	private final int villages;
	private final int points;
	private final String userName;
	
	public Player(String userName, int villages, int points) {
		this.villages = villages;
		this.points = points;
		this.userName = userName;
	}

	public int getVillages() {
		return villages;
	}

	public int getPoints() {
		return points;
	}

	public String getUserName() {
		return userName;
	}
	
	

}
