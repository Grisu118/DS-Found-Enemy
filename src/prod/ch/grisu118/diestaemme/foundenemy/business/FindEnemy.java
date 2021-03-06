package ch.grisu118.diestaemme.foundenemy.business;

import ch.grisu118.diestaemme.foundenemy.business.Objects.Player;
import ch.grisu118.diestaemme.foundenemy.business.Objects.Tribe;
/**
 * This class provides methods for finding the enemy.
 * @author Grisu118
 *
 */
public class FindEnemy {
    /**
     * The Factor which comes from Casual World configuration.
     */
    private final static double FACTOR = 1.2;
    /**
     * Private Constructor, because this class must never be initialized.
     */
    private FindEnemy() {
    }
    /**
     * Find Enemy's for the {@link Player}.
     * @param player The Player for them the method search enemy's.
     * @param enemyTribe The Enemy Tribe, in them the enemy's are searched.
     * @return An Array of int. With the index of the Player in the members Array of the Tribe.
     */
    public static int[] enemys(Player player, Tribe enemyTribe) {
        int min = (int) Math.ceil(player.getPoints() / FACTOR);
        int max = (int) Math.floor(player.getPoints() * FACTOR);
        Player pl;
        int j = 0;
        for (int i = 0; i < enemyTribe.getMemberCount(); i++) {
            pl = enemyTribe.getPlayer(i);
            if (pl.getPoints() <= max && pl.getPoints() >= min) {
                j++;
            }
        }
        int[] targets = new int[j];

        j = 0;
        for (int i = 0; i < enemyTribe.getMemberCount(); i++) {
            pl = enemyTribe.getPlayer(i);
            if (pl.getPoints() <= max && pl.getPoints() >= min) {
                targets[j++] = i;
            }
        }
        if (targets.length == 0)
            return null;
        return targets;
    }
}
