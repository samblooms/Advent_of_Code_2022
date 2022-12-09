package Day_04;

import java.io.*;
import java.util.*;

public class Part_02 {
    
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
                int overlapStart = Math.max(range1Start, range2Start);
                int overlapEnd = Math.min(range1End, range2End);
                for (int i = overlapStart; i <= overlapEnd; i++){
                    overlapCount++;
                    break;
                }

            }
            
            System.out.println(overlapCount);
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
        }


    }
}
