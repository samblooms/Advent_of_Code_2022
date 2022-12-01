package Day_01;

import java.io.*;
import java.util.*;

public class Part_02 {
    public static void main(String[] args) {
        try {
        
            File inputFile = new File(args[0]);
            Scanner s = new Scanner(inputFile);

            ArrayList<Integer> elves = new ArrayList<Integer>();
            int currentElf = 0;

            for (int i = 0; s.hasNextLine(); ){
                String line = s.nextLine();
                if (line.length() == 0) {
                    elves.add(currentElf);
                    currentElf = 0;
                    i++;
                    continue;
                } else {
                    currentElf += Integer.parseInt(line);
                }
            }

            int mostCalories = Collections.max(elves);
            int mostCaloriesIndex = elves.indexOf(mostCalories);
            Collections.sort (elves);
            int length = elves.size();

            System.out.println(mostCalories);
            System.out.println(mostCaloriesIndex);
            System.out.println(elves.get(length -1 ) + elves.get(length - 2) + elves.get(length - 3));

            } catch (FileNotFoundException e) {
                System.out.println("File not found");
            }

    } // End Main

}