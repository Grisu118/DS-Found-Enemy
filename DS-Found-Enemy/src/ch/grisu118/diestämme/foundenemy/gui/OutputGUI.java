package ch.grisu118.diestämme.foundenemy.gui;

import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JScrollPane;

import ch.grisu118.diestämme.foundenemy.business.Objects.Tribe;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JViewport;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class OutputGUI extends JPanel {

	public OutputGUI(Tribe ownTribe, Tribe enemyTribe) {
		setLayout(new BorderLayout(0, 0));
				
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		JPanel temp = new JPanel();
		JScrollPane scrollPane = new JScrollPane(temp);
		panel.add(scrollPane);
		temp.setLayout(new GridLayout(ownTribe.getMemberCount(), 1));

		JPanel[] playerPanel = new JPanel[ownTribe.getMemberCount()];
		

		for (int i = 0; i < ownTribe.getMemberCount(); i++) {
			playerPanel[i] = new PlayerPanel(ownTribe.getPlayer(i), enemyTribe);
			temp.add(playerPanel[i]);
		}

		// add(playerPanel, BorderLayout.NORTH);
		// playerPanel.setLayout(new GridLayout(0, 1, 0, 0));
		//
		// JSplitPane splitPane = new JSplitPane();
		// playerPanel.add(splitPane);
		//
		// JPanel panel = new JPanel();
		// splitPane.setLeftComponent(panel);
		//
		// JPanel panel_1 = new JPanel();
		// splitPane.setRightComponent(panel_1);

	}

}
