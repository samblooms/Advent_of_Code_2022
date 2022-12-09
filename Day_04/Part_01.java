package Day_04;

import java.io.*;
import java.util.*;

public class Part_01 {
    
    public static void main(String[] args){
        try {
            File inputFile = new File(args[0]);
            Scanner s = new Scanner(inputFile);

            int overlapCount = 0;
            String[] currentRangePair = new String[2];
            String range1 = "";
            String range2 = "";
            
            while (s.hasNextLine()){
                currentRangePair = s.nextLine().split(",");
                range1 = currentRangePair[0];
                range2 = currentRangePair[1];
                int range1Start = Integer.parseInt(range1.substring(0, range1.indexOf("-")));
                int range1End = Integer.parseInt(range1.substring(range1.indexOf("-") + 1));
                int range2Start = Integer.parseInt(range2.substring(0, range2.indexOf("-")));
                int range2End = Integer.parseInt(range2.substring(range2.indexOf("-") + 1));
                if (range1Start <= range2Start && range1End >= range2End){
                    overlapCount++;
                } else if (range2Start <= range1Start && range2End >= range1End){
                    overlapCount++;
                }

            }
            
            System.out.println(overlapCount);
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
        }


    }
}
