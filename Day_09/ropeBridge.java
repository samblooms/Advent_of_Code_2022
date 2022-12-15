package Day_09;

import java.io.*;
import java.util.*;

public class ropeBridge{
    
    public static void main(String[] args){
        try {
            File file = new File("input.txt");
            Scanner scanner = new Scanner(file);
            ArrayList<String> moves = new ArrayList<String>();
            while (scanner.hasNextLine()) {
                moves.add(scanner.nextLine());
            }
            Part_01(moves);
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    public static void Part_01( ArrayList<String> moves ){
        System.out.println( countUniquePositions(moves));
    }

    public static void Part_02(){

    }

    public static int countUniquePositions(ArrayList<String> moves){
        ArrayList<String> positionsVisited = new ArrayList<String>();
        int positionsVisitedCount = 0;

        int headX = 10000;
        int headY = 10000;

        int tailX = 10000;
        int tailY = 10000;

        for (String move : moves){
            String test = String.format("x: %d y: %d", tailX, tailY);
            if (!positionsVisited.contains(test)){
                positionsVisited.add(test);
            }
            char direction = move.charAt(0);
            String temp = move.substring(2);
            int amount = Integer.parseInt(temp);
            if (direction == 'R'){
                headX += amount;
                while (Math.abs(headX - tailX) > 1){
                    if (headY > tailY){
                        tailY++;
                    }
                    else if (headY < tailY){
                        tailY--;
                    }
                    tailX++;
                    test = String.format("x: %d y: %d", tailX, tailY);
                    if (!positionsVisited.contains(test)){
                        positionsVisited.add(test);
                    }
                }
            }
            else if (direction == 'L'){
                headX -= amount;
                while (Math.abs(headX - tailX) > 1){
                    if (headY > tailY){
                        tailY++;
                    }
                    else if (headY < tailY){
                        tailY--;
                    }
                    tailX--;
                    test = String.format("x: %d y: %d", tailX, tailY);
                    if (!positionsVisited.contains(test)){
                        positionsVisited.add(test);
                    }
                }
            }
            else if (direction == 'U'){
                headY += amount;
                while (Math.abs(headY - tailY) > 1){
                    if (headX > tailX){
                        tailX++;
                    }
                    else if (headX < tailX){
                        tailX--;
                    }
                    tailY++;
                    test = String.format("x: %d y: %d", tailX, tailY);
                    if (!positionsVisited.contains(test)){
                        positionsVisited.add(test);
                    }
                }
            }
            else if (direction == 'D'){
                headY -= amount;
                while (Math.abs(headY - tailY) > 1){
                    if (headX > tailX){
                        tailX++;
                    }
                    else if (headX < tailX){
                        tailX--;
                    }
                    tailY--;
                    test = String.format("x: %d y: %d", tailX, tailY);
                    if (!positionsVisited.contains(test)){
                        positionsVisited.add(test);
                    }
                }
            }
            
        } 
        return positionsVisited.size();
    }

}