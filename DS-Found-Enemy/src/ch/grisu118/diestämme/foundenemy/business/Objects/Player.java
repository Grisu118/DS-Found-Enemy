package ch.grisu118.diestämme.foundenemy.business.Objects;

public class Player {

	private final int villages;
	private final int points;
	private final String userName;
	private int[] targets;
	private boolean hasTargets;
	
	public Player(String userName, int villages, int points) {
		this.villages = villages;
		this.points = points;
		this.userName = userName;
		this.hasTargets = false;
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
	
	public void setTargets(int[] targets) {
		if (targets != null) {
			this.hasTargets = true;
			this.targets = targets;
		} else {
			this.hasTargets = false;
			this.targets = null;
		}
		
	}
	
	public int[] getTargets() {
		return targets;
	}
	
	public boolean hasTargets() {
		return hasTargets;
	}
	
	

}
