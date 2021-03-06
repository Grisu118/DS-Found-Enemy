package ch.grisu118.diestaemme.foundenemy.business.Objects;

/**
 * This Class represents the Player.
 * 
 * @author Grisu118
 * 
 */
public class Player {
    /**
     * The number of villages of this Player.
     */
    private final int villageCount;
    /**
     * The points of this Player
     */
    private final int points;
    /**
     * The ingamename of this Player
     */
    private final String userName;
    /**
     * Array with the indices of the possible enemy targets.
     */
    private int[] targets;

    /**
     * Creates a new Player Object.
     * 
     * @param userName the ingamename of this Player. <b>Must not be null or empty!</b>
     * @param villageCount the number of villages of this Player. <b> Must be bigger than zero!</b>
     * @param points the points of this Player. <b> Must be bigger than zero!</b>
     */
    public Player(String userName, int villageCount, int points) {
        if (userName == null || userName.equals(""))
            throw new IllegalArgumentException("illegal userName");
        if (villageCount < 1)
            throw new IllegalArgumentException("illegal villageCount");
        if (points < 0)
            throw new IllegalArgumentException("illegal points");
        this.villageCount = villageCount;
        this.points = points;
        this.userName = userName;
        this.targets = null;
    }

    /**
     * Returns the count of villages.
     * 
     * @return the number of villages.
     */
    public int getVillageCount() {
        return villageCount;
    }

    /**
     * Returns the points of this Player.
     * 
     * @return the points of this player.
     */
    public int getPoints() {
        return points;
    }

    /**
     * Returns the UserName of this Player.
     * 
     * @return the ingameName.
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Set the Targets of this player.
     * 
     * @param targets int array with indices of Player's in the enemy {@link Tribe} Player[].
     */
    public void setTargets(int[] targets) {
        this.targets = targets;
    }

    /**
     * Returns the array with the indices of Player from the enemy {@link Tribe} Player[].
     * 
     * @return int array with indices.
     */
    public int[] getTargets() {
        return targets;
    }

    /**
     * Returns if targets array is null or not.
     * 
     * @return if targets[]==null => return false, else true.
     */
    public boolean hasTargets() {
        return targets != null;
    }

    /**
     * Indicates whether some other player is "equal to" this one.
     * 
     * The equals method implements an equivalence relation of the following fields:
     * <ul>
     * <li>userName</li>
     * <li>points</li>
     * <li>villageCount</li>
     * </ul>
     * 
     * @param p the reference object with which to compare.
     * @return true if this player is the same as the p argument; false otherwise.
     */
    @Override
    public boolean equals(Object p) {

        if (p instanceof Player) {
            Player p1 = (Player) p;
            return this.points == p1.points && this.villageCount == p1.villageCount
                    && this.userName.equals(p1.userName);
        } else
            return false;

    }
}
