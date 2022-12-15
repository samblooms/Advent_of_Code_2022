package Day_06;

import java.io.*;
import java.util.*;

public class Parts_01_02{
    public static void main(String[] args) {
        try {
            int markerLength = Integer.parseInt(args[0]);
            File inputFile = new File(args[1]);
            Scanner s = new Scanner(inputFile);
            String inputText = "";

            while (s.hasNext()) {
                inputText += s.next();
            }

            getMarkerIndex(inputText, markerLength);


        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    public static void getMarkerIndex(String input, int markerLength) {
        List<Character> charList= new ArrayList<Character>();
        for (int i = 0; i < input.length(); i++) {
            if (charList.size() <= markerLength) {
                charList.add(input.charAt(i));
            } else if (checkList(charList, markerLength)) {
                System.out.println("Marker found at index " + (i -1));
                break;
            } else {
                charList.remove(0);
                charList.add(input.charAt(i));
            }
                
        }
    }

    public static boolean checkList(List<Character> charList, int markerLength) {
        //check for any duplicate characters in the last markerLength characters of the list
        int start = charList.size() - markerLength -1;
        for (int i = start; i < markerLength; i++) {
            for (int j = i + 1; j < markerLength; j++) {
                if (charList.get(i) == charList.get(j)) {
                    return false;
                }
            }
        }
        return true;
    }


}