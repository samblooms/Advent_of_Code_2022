package Day_03;

import java.io.*;
import java.util.*;

public class Part_02 {
    
    public static void main(String[] args){
        try {
            File inputFile = new File(args[0]);
            Scanner s = new Scanner(inputFile);

            ArrayList<Character> duplicates = new ArrayList<Character>();
            String[] lines = new String[3];

           for (int i = 0; s.hasNextLine(); i++) {
                lines[i] = s.nextLine();
                if (i == 2) {
                    i = -1;
                    for (int j = 0; j < lines[0].length(); j++) {
                        if (lines[0].charAt(j) == lines[1].charAt(j) && lines[1].charAt(j) == lines[2].charAt(j)) {
                            duplicates.add(lines[0].charAt(j));
                        }
                    }
                    lines = new String[3];
                    i = 0;
                }
            }

            int totalWeight = 0;
            for (Character currChar: duplicates){
                if (Character.isUpperCase(currChar)){
                    totalWeight += 26;
                    currChar = Character.toLowerCase(currChar);
                    //System.out.println(Character.toUpperCase(currChar) + " " + (currChar - 'a' + 1 + 26));
                }
                else {
                    //System.out.println(currChar + " " + (currChar - 'a' + 1));
                }
                totalWeight += currChar - 'a' + 1;
            }
            System.out.println(totalWeight);
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

}
