package ch.grisu118.diestaemme.foundenemy.gui;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class InputGUI extends JPanel {

    private final JTextField tribeName;
    private final JTextField tribeName2;
    private final JTextField tribe;
    private final JTextField tribe2;
    private final JTextField memberCount;
    private final JTextField memberCount2;
    private final JTextArea members;
    private final JTextArea members2;

    public InputGUI() {
        setBorder(new EmptyBorder(10, 10, 10, 10));
        setLayout(new BorderLayout());
        JPanel center = new JPanel();
        center.setBorder(new EmptyBorder(0, 0, 10, 0));
        add(center, BorderLayout.CENTER);
        GridBagLayout gbl_center = new GridBagLayout();
        gbl_center.columnWidths = new int[] { 225, 225, 0 };
        gbl_center.rowHeights = new int[] { 15, 15, 15, 100 };
        gbl_center.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
        gbl_center.rowWeights = new double[] { 0.0, 0.0, 0.0, 1.0 };
        center.setLayout(gbl_center);

        tribeName = new JTextField();
        tribeName.setBorder(new BevelBorder(BevelBorder.LOWERED));

        GridBagConstraints gbc_tribeName = new GridBagConstraints();
        gbc_tribeName.fill = GridBagConstraints.BOTH;
        gbc_tribeName.insets = new Insets(0, 0, 5, 5);
        gbc_tribeName.gridx = 0;
        gbc_tribeName.gridy = 0;
        center.add(tribeName, gbc_tribeName);
        tribeName2 = new JTextField();
        tribeName2.setBorder(new BevelBorder(BevelBorder.LOWERED));
        GridBagConstraints gbc_tribeName2 = new GridBagConstraints();
        gbc_tribeName2.fill = GridBagConstraints.BOTH;
        gbc_tribeName2.insets = new Insets(0, 0, 5, 0);
        gbc_tribeName2.gridx = 1;
        gbc_tribeName2.gridy = 0;
        center.add(tribeName2, gbc_tribeName2);
        tribe = new JTextField();
        tribe.setBorder(new BevelBorder(BevelBorder.LOWERED));
        GridBagConstraints gbc_tribe = new GridBagConstraints();
        gbc_tribe.fill = GridBagConstraints.BOTH;
        gbc_tribe.insets = new Insets(0, 0, 5, 5);
        gbc_tribe.gridx = 0;
        gbc_tribe.gridy = 1;
        center.add(tribe, gbc_tribe);
        tribe2 = new JTextField();
        tribe2.setBorder(new BevelBorder(BevelBorder.LOWERED));
        GridBagConstraints gbc_tribe2 = new GridBagConstraints();
        gbc_tribe2.fill = GridBagConstraints.BOTH;
        gbc_tribe2.insets = new Insets(0, 0, 5, 0);
        gbc_tribe2.gridx = 1;
        gbc_tribe2.gridy = 1;
        center.add(tribe2, gbc_tribe2);
        memberCount = new JTextField();
        memberCount.setBorder(new BevelBorder(BevelBorder.LOWERED));
        GridBagConstraints gbc_memberCount = new GridBagConstraints();
        gbc_memberCount.fill = GridBagConstraints.BOTH;
        gbc_memberCount.insets = new Insets(0, 0, 5, 5);
        gbc_memberCount.gridx = 0;
        gbc_memberCount.gridy = 2;
        center.add(memberCount, gbc_memberCount);
        memberCount2 = new JTextField();
        memberCount2.setBorder(new BevelBorder(BevelBorder.LOWERED));
        GridBagConstraints gbc_memberCount2 = new GridBagConstraints();
        gbc_memberCount2.fill = GridBagConstraints.BOTH;
        gbc_memberCount2.insets = new Insets(0, 0, 5, 0);
        gbc_memberCount2.gridx = 1;
        gbc_memberCount2.gridy = 2;
        center.add(memberCount2, gbc_memberCount2);

        members = new JTextArea();

        JScrollPane sc1 = new JScrollPane(members);
        sc1.setBorder(new BevelBorder(BevelBorder.LOWERED));
        GridBagConstraints gbc_sc1 = new GridBagConstraints();
        gbc_sc1.fill = GridBagConstraints.BOTH;
        gbc_sc1.insets = new Insets(0, 0, 0, 5);
        gbc_sc1.gridx = 0;
        gbc_sc1.gridy = 3;
        center.add(sc1, gbc_sc1);
        members2 = new JTextArea();
        JScrollPane sc2 = new JScrollPane(members2);
        sc2.setBorder(new BevelBorder(BevelBorder.LOWERED));
        GridBagConstraints gbc_sc2 = new GridBagConstraints();
        gbc_sc2.fill = GridBagConstraints.BOTH;
        gbc_sc2.gridx = 1;
        gbc_sc2.gridy = 3;
        center.add(sc2, gbc_sc2);

        new GhostText(tribeName, "Stammesname - eigener Stamm - nicht benötigt");
        new GhostText(tribeName2, "Stammesname - gegnerischer Stamm - nicht benötigt");
        new GhostText(tribe, "Stammeskürzel - eigener Stamm - nicht benötigt");
        new GhostText(tribe2, "Stammesname - gegnerischer Stamm - nicht benötigt");
        new GhostText(memberCount, "Anzahl Stammesmitglieder - eigener Stamm");
        new GhostText(memberCount2, "Anzahl Stammesmitglieder - gegnerischer Stamm");
        new GhostText(members, "Stammesmitglieder - eigener Stamm - Copy-Paste");
        new GhostText(members2, "Stammesmitglieder - gegnerischer Stamm - Copy-Paste");

        JPanel southPanel = new JPanel();
        add(southPanel, BorderLayout.SOUTH);
        southPanel.setLayout(new BorderLayout(0, 0));

        JButton btnNext = new JButton("Weiter");
        btnNext.addActionListener(new EventHandler(this));
        southPanel.add(btnNext, BorderLayout.EAST);

    }

    public JTextField getTribeName() {
        return tribeName;
    }

    public JTextField getTribeName2() {
        return tribeName2;
    }

    public JTextField getTribe() {
        return tribe;
    }

    public JTextField getTribe2() {
        return tribe2;
    }

    public JTextField getMemberCount() {
        return memberCount;
    }

    public JTextField getMemberCount2() {
        return memberCount2;
    }

    public JTextArea getMembers() {
        return members;
    }

    public JTextArea getMembers2() {
        return members2;
    }
}
