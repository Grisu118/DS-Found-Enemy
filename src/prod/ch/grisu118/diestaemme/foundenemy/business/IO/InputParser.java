package ch.grisu118.diestaemme.foundenemy.business.IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

public class InputParser {

    private InputParser() {
    }

    /**
     * 
     * @param s The Input String.
     * @return Object Array with follow specification.
     *         <ul>
     *         <li>0 - Player Name - String</li>
     *         <li>1 - Points of the Player - int</li>
     *         <li>2 - Count of villages - int</li>
     *         </ul>
     */
    private static Object[] parse(String s) {
        Object[] data = new Object[3];
        String delims = "[	]+";
        String[] tokens = s.split(delims);
        data[0] = tokens[0];
        data[2] = Integer.parseInt(tokens[4]);

        if (tokens[2].contains(".")) {
            delims = "[.]";
            String[] t2 = tokens[2].split(delims);
            String s1 = t2[0] + t2[1];
            s1 = s1.trim();
            data[1] = Integer.parseInt(s1);
        } else {
            tokens[2] = tokens[2].trim();
            data[1] = Integer.parseInt(tokens[2]);
        }

        return data;
    }

    /**
     * 
     * @param s The Input String.
     * @return Object Array with all Players and the specification of them.
     *         <ul>
     *         <li>i-0 - Player Name - String</li>
     *         <li>i-1 - Points of the Player - int</li>
     *         <li>i-2 - Count of villages - int</li>
     *         </ul>
     */
    public static Object[][] reader(String s, int count) {
        StringReader sr = new StringReader(s);
        BufferedReader br = new BufferedReader(sr);
        Object[][] data = new Object[count][];
        try {
            for (int i = 0; i < count; i++) {
                data[i] = parse(br.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return data;
    }

}
