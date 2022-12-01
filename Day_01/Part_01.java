package Day_01;

import java.io.*;
import java.util.*;

public class Part_01 {
    public static void main(String[] args) {
        try {
        
            File inputFile = new File(args[0]);
            Scanner s = new Scanner(inputFile);

            ArrayList<Integer> elves = new ArrayList<Integer>();
            int currentElf = 0;

            // Map each elf from the highest calorie count to the lowest and include their index
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

            System.out.println(mostCalories);
            System.out.println(mostCaloriesIndex);

            } catch (FileNotFoundException e) {
                System.out.println("File not found");
            }

        
    } // End Main

}