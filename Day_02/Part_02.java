package Day_02;

import java.io.*;
import java.util.*;

public class Part_02 {


    static int totalScore = 0;
    

    public static void main(String args[]){
        try {
            File inputFile = new File(args[0]);
            Scanner s = new Scanner(inputFile);

            char oppMove = 0;
            char myMove = 0;
            char result = 0;

            while (s.hasNextLine()){
                String line = s.nextLine();
                oppMove = line.charAt(0);
                result = line.charAt(2);
                myMove = getMove(oppMove, result);
                if (oppMove == 'A' && myMove == 'X' || oppMove == 'B' && myMove == 'Y' || oppMove == 'C' && myMove == 'Z'){
                    totalScore += 3;
                } 
                if (checkWin(oppMove, myMove)){
                    totalScore += 6;
                }
            }

            s.close();
            System.out.println(totalScore);

        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

    }

    private static char getMove(char oppMove, char result){
        if (result == 'X'){
            if (oppMove == 'A'){
                return 'Z';
            }
            if (oppMove == 'B'){
                return 'X';
            }
            if (oppMove == 'C'){
                return 'Y';
            }
        }
        if (result == 'Y'){
            if (oppMove == 'A'){
                return 'X';
            }
            if (oppMove == 'B'){
                return 'Y';
            }
            if (oppMove == 'C'){
                return 'Z';
            }
        }
        if (result == 'Z'){
            if (oppMove == 'A'){
                return 'Y';
            }
            if (oppMove == 'B'){
                return 'Z';
            }
            if (oppMove == 'C'){
                return 'X';
            }
        }
        return 0;
    }


    private static boolean checkWin(char oppMove, char myMove){
        if (myMove == 'X'){
            totalScore += 1;
            return (oppMove == 'C');
        }else if (myMove == 'Y'){
            totalScore += 2;
            return (oppMove == 'A');
        }else if (myMove == 'Z'){
            totalScore += 3;
            return (oppMove == 'B');
        }
        return false;
    }

}