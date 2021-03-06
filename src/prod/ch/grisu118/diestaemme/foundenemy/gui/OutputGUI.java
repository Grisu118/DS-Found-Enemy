package ch.grisu118.diestaemme.foundenemy.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import ch.grisu118.diestaemme.foundenemy.business.Objects.Tribe;

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

    }

}
