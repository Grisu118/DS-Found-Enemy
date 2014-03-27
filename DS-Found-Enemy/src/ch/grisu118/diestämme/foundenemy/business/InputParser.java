package ch.grisu118.diestämme.foundenemy.business;

public class InputParser {

	private InputParser() {
	}

	/**
	 * 
	 * @param s
	 *            The Input String
	 * @return Object Array with follow specification
	 *         <ul>
	 *         <li>0 - Player Name - String</li>
	 *         <li>1 - Points of the Player - int</li>
	 *         <li>2 - Count of villages - int</li>
	 *         </ul>
	 */
	public static Object[] Parse(String s) {
		Object[] data = new Object[3];
		String delims = "[	]+";
		String[] tokens = s.split(delims);
		data[0] = tokens[0];
		data[2] = Integer.parseInt(tokens[4]);

		delims = "[.]";
		String[] t2 = tokens[2].split(delims);
		String s1 = t2[0] + t2[1];
		s1 = s1.trim();
		data[1] = Integer.parseInt(s1);

		return data;
	}

}
