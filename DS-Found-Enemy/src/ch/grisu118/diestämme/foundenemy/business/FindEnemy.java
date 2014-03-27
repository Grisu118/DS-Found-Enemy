package ch.grisu118.diestämme.foundenemy.business;

import ch.grisu118.diestämme.foundenemy.business.Objects.Player;
import ch.grisu118.diestämme.foundenemy.business.Objects.Tribe;

public class FindEnemy {

	private final static double factor = 1.2;

	private FindEnemy() {
	}

	public static int[] enemys(Player player, Tribe enemyTribe) {
		int min = (int) Math.ceil(player.getPoints() / factor);
		int max = (int) Math.floor(player.getPoints() * factor);
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
