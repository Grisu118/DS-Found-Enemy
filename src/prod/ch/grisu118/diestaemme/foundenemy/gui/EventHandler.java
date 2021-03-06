package ch.grisu118.diestaemme.foundenemy.gui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ch.grisu118.diestaemme.foundenemy.business.FindEnemy;
import ch.grisu118.diestaemme.foundenemy.business.IO.ExportBBCode;
import ch.grisu118.diestaemme.foundenemy.business.IO.InputParser;
import ch.grisu118.diestaemme.foundenemy.business.Objects.Player;
import ch.grisu118.diestaemme.foundenemy.business.Objects.Tribe;

public class EventHandler implements ActionListener {

    private InputGUI iUI;
    private BBCodeOutput bbCodeOutput;

    public EventHandler(InputGUI iUI) {
        this.iUI = iUI;
    }

    public EventHandler(BBCodeOutput bbCodeOutput) {
        this.bbCodeOutput = bbCodeOutput;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (iUI != null) {
            if (e.getActionCommand().equals("Weiter")) {
                byte memberCount = Byte.parseByte(iUI.getMemberCount().getText());
                byte memberCount2 = Byte.parseByte(iUI.getMemberCount2().getText());
                Tribe ownTribe = new Tribe(iUI.getTribeName().getText(), iUI.getTribe().getText(), memberCount);
                Tribe enemyTribe = new Tribe(iUI.getTribeName2().getText(), iUI.getTribe2().getText(), memberCount2);

                Object[][] data = InputParser.reader(iUI.getMembers().getText(), memberCount);
                Object[][] data2 = InputParser.reader(iUI.getMembers2().getText(), memberCount2);
                Player pl;
                for (int i = 0; i < data.length; i++) {
                    pl = new Player((String) data[i][0], (int) data[i][2], (int) data[i][1]);
                    ownTribe.addPlayer(pl);
                }

                for (int i = 0; i < data2.length; i++) {
                    pl = new Player((String) data2[i][0], (int) data2[i][2], (int) data2[i][1]);
                    enemyTribe.addPlayer(pl);
                }

                for (int i = 0; i < ownTribe.getMemberCount(); i++) {
                    pl = ownTribe.getPlayer(i);
                    pl.setTargets(FindEnemy.enemys(pl, enemyTribe));
                }

                Container parent = iUI.getParent();
                parent.removeAll();
                parent.add(new OutputGUI(ownTribe, enemyTribe));
                String[] s = ExportBBCode.exportToBBCodeTable(ownTribe, enemyTribe);
                String s1 = "";
                for (String string : s) {
                    s1 += string;
                    s1 += "\n\n";
                }
                parent.validate();
                parent.repaint();

                BBCodeOutput out = new BBCodeOutput();
                out.getTextArea().setText(s1);
                out.setVisible(true);

            }
        } else if (bbCodeOutput != null) {
            if (e.getActionCommand().equals("OK")) {
                bbCodeOutput.dispose();
            }
        }

    }

}
