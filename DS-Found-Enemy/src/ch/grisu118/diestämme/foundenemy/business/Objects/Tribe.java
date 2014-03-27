package ch.grisu118.diestämme.foundenemy.business.Objects;

public class Tribe {
	
	private final String tribeName;
	private final String name;
	private final byte memberCount;
	private final Player[] members;
	private int index = 0;

	public Tribe(String tName, String name, byte memberCount) {
		this.tribeName = tName;
		this.name = name;
		this.memberCount = memberCount;
		this.members = new Player[memberCount];
	}

	public String getTribeName() {
		return tribeName;
	}

	public String getName() {
		return name;
	}

	public byte getMemberCount() {
		return memberCount;
	}
	
	public void addPlayer(Player player) {
		members[index++] = player;
	}
	public Player getPlayer(int id) {
		return members[id];
	}

}
