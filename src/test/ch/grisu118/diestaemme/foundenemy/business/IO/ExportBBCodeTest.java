package ch.grisu118.diestaemme.foundenemy.business.IO;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ch.grisu118.diestaemme.foundenemy.business.Objects.Player;
import ch.grisu118.diestaemme.foundenemy.business.Objects.Tribe;

public class ExportBBCodeTest {
    
    Tribe owntribe;
    Tribe enemytribe;

    @Before
    public void setUp() throws Exception {
        owntribe = new Tribe("Name", "kürzel", (byte)2);
        enemytribe = new Tribe("Name2", "kürzel2", (byte)4);
        
        Player p1 = new Player("Spieler1", 10, 10000);
        Player p2 = new Player("Spieler2", 20, 20000);
        Player p3 = new Player("Spieler3", 10, 9000);
        Player p4 = new Player("Spieler4", 10, 11000);
        Player p5 = new Player("Spieler5", 10, 13000);
        Player p6 = new Player("Spieler6", 10, 25000);
        
        owntribe.addPlayer(p1);
        owntribe.addPlayer(p2);
        
        enemytribe.addPlayer(p3);
        enemytribe.addPlayer(p4);
        enemytribe.addPlayer(p5);
        enemytribe.addPlayer(p6);
        int[] i = {0, 1, 2};
        int[] i1 = null;
        p1.setTargets(i);
        p2.setTargets(i1);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testExportToBBCodeTable() {
        String[] s = ExportBBCode.exportToBBCodeTable(owntribe, enemytribe);
        assertEquals(1, s.length);
        String expected = "[table][**]Eigener Spieler[||]Mögliche Gegner[/**][*][player]Spieler1[/player][|][player]Spieler3[/player][*][|][player]Spieler4[/player][*][|][player]Spieler5[/player][*][player]Spieler2[/player][|]Keine möglichen Gegner[/table]";
        assertEquals(expected, s[0]);
      
    }
    
    @Test
    public void testAddTag() {
       assertEquals("[player]Bronzeadler[/player]", ExportBBCode.addTag("Bronzeadler", ExportBBCode.PLAYER));
       assertEquals("[coord]123|543[/coord]", ExportBBCode.addTag("123|543", ExportBBCode.VILLAGE));
       assertEquals("[ally]~CL~[/ally]", ExportBBCode.addTag("~CL~", ExportBBCode.TRIBE));
    }

}
