package ch.grisu118.diestaemme.foundenemy.business.IO;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class InputParserTest {


	@Test
	public void testReader() {
		String s = "Rio Bravo		1 	240.414 	1.066 	35\nwormly		2 	166.516 	1.722 	27\neszetschnitte		29 	829 	12.219 	1";
		Object[][] array = InputParser.reader(s, 3);
		
		assertEquals(array[0][0], "Rio Bravo");
		assertEquals(array[1][0], "wormly");
		assertEquals(array[2][0], "eszetschnitte");
		assertEquals(array[0][1], 240414);
		assertEquals(array[1][1], 166516);
		assertEquals(array[2][1], 829);
		assertEquals(array[0][2], 35);
		assertEquals(array[1][2], 27);
		assertEquals(array[2][2], 1);
	}

}
