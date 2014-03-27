package ch.grisu118.diestämme.foundenemy.gui;

import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;

import java.awt.BorderLayout;

import javax.swing.JLabel;

import ch.grisu118.diestämme.foundenemy.business.Objects.Player;
import ch.grisu118.diestämme.foundenemy.business.Objects.Tribe;

import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

@SuppressWarnings("serial")
public class PlayerPanel extends JPanel {

	public PlayerPanel(Player player, Tribe enemyTribe) {
		setLayout(new BorderLayout(0, 0));

		JSplitPane splitPane = new JSplitPane();
		add(splitPane, BorderLayout.CENTER);

		JPanel left = new JPanel();
		splitPane.setLeftComponent(left);
		GridBagLayout gbl_left = new GridBagLayout();
		gbl_left.columnWidths = new int[]{150, 0};
		gbl_left.rowHeights = new int[]{20, 0};
		gbl_left.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_left.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		left.setLayout(gbl_left);
		
				JLabel lblPlayer = new JLabel(player.getUserName());
				GridBagConstraints gbc_lblPlayer = new GridBagConstraints();
				gbc_lblPlayer.anchor = GridBagConstraints.NORTH;
				gbc_lblPlayer.fill = GridBagConstraints.HORIZONTAL;
				gbc_lblPlayer.gridx = 0;
				gbc_lblPlayer.gridy = 0;
				left.add(lblPlayer, gbc_lblPlayer);

		JPanel right = new JPanel();
		splitPane.setRightComponent(right);
		if (player.hasTargets()) {
			right.setLayout(new GridLayout(player.getTargets().length, 0));
			for (int i = 0; i < player.getTargets().length; i++) {
				JTextField txt = new JTextField(enemyTribe.getPlayer(player.getTargets()[i]).getUserName());
				txt.setEditable(false);
				right.add(txt);
			}
		} else 
			right.add(new JLabel("Keine möglichen Gegner"));
		
	}

}
