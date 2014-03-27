package ch.grisu118.diest�mme.foundenemy.business;

import ch.grisu118.diest�mme.foundenemy.business.Objects.Tribe;

public class ExportBBCode {

	private ExportBBCode() {
	}

	public static String[] exportToBBCode(Tribe ownTribe, Tribe enemyTribe) {
		String[] exportString = new String[ownTribe.getMemberCount() / 10];
		String start = "[table][**]Eigener Spieler[||]M�gliche Gegner[/**]";
		String end = "[/table]";

		for (int i = 0; i < exportString.length; i++) {
			exportString[i] = start;
		}

		for (int k = 0; k < ownTribe.getMemberCount() / 10; k++) {
			for (int i = 0; i < 10; i++) {
				if (ownTribe.getPlayer(k * 10 + i).hasTargets()) {
					String temp = "[*][player]"
							+ ownTribe.getPlayer(k * 10 + i).getUserName()
							+ "[/player][|][player]"
							+ enemyTribe
									.getPlayer(
											ownTribe.getPlayer(k * 10 + i)
													.getTargets()[0])
									.getUserName() + "[/player]";
					exportString[k] += temp;
					for (int j = 1; j < ownTribe.getPlayer(k * 10 + i)
							.getTargets().length; j++) {
						String s1 = "[*][|][player]"
								+ enemyTribe.getPlayer(
										ownTribe.getPlayer(k * 10 + i)
												.getTargets()[j]).getUserName()
								+ "[/player]";
						exportString[k] += s1;
					}
				} else {
					String temp = "[*][player]"
							+ ownTribe.getPlayer(k * 10 + i).getUserName()
							+ "[/player][|]" + "Keine m�glichen Gegner";
					exportString[k] += temp;
				}
			}
		}
		for (int i = 0; i < exportString.length; i++) {
			exportString[i] += end;
		}

		// [*]Inhalt 1[|]Inhalt 2[|]Inhalt 3
		for (String string : exportString) {
			System.out.println(string);
		}
		return exportString;

	}

}
