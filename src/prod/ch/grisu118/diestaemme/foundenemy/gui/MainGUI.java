package ch.grisu118.diestaemme.foundenemy.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import ch.grisu118.gui.GrisuMainFrame;

public class MainGUI extends GrisuMainFrame {

    public MainGUI(String title, String folder, String fileName) {
        super(title, folder, fileName);
    }

    @Override
    public JPanel createMenu() {
        JPanel menu = new JPanel();
        return menu;
    }
    
    private class EventHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
        }
        
    }

}
