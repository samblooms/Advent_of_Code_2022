package Day_03;

import java.io.*;
import java.util.*;

public class Part_01 {

    public static void main(String[] args){
        try {
            File inputFile = new File(args[0]);
            Scanner s = new Scanner(inputFile);

            ArrayList<Character> duplicates = new ArrayList<Character>();

            while (s.hasNextLine()){
                String line = s.nextLine();
                String[] currentLine = {line.substring(0, line.length()/2), line.substring(line.length()/2)};
                /*for (int i = 0; i < currentLine.length/2; i++){
                    if (currentLine[1].indexOf(currentLine[0].charAt(i)) != -1){
                        duplicates.add(currentLine[0].charAt(i));
                    }
                }*/
                // Find duplicate characters in current line
                boolean found = false;
                for (int i = 0; i < currentLine[0].length(); i++){
                    for (int j = 0; j < currentLine[1].length(); j++){
                        if (currentLine[0].charAt(i) == currentLine[1].charAt(j)){
                            duplicates.add(currentLine[0].charAt(i));
                            found = true;
                            break;
                        }
                    }
                    if (found){
                        break;
                    }
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
            System.out.println(duplicates);
            System.out.println(totalWeight);
            //System.out.println('z'- 96);
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

}