package Day_08;

import java.io.*;
import java.util.*;

public class Part_02 {
    
    public static void main(String[] args){
            int[][] grid = parseFile();
            System.out.println(countDistance(grid));
    }

    // Count the distance 
    public static int countDistance(int[][] grid){
        int distance = 0;

        // Count the number of trees not in the perimeter that are visible
        for (int col = 1; col < grid.length - 1; col++){
            for (int row = 1; row < grid[0].length - 1; row++){
                int[] column = new int[grid.length];
				for (int k = 0; k < column.length; k++) {
					column[k] = grid[k][row];
				}
                int[] left = Arrays.copyOfRange(grid[col], 0, row);
                int[] right = Arrays.copyOfRange(grid[col], row + 1, grid[0].length);
                int[] top = Arrays.copyOfRange(column, 0, col);
                int[] down = Arrays.copyOfRange(column, col + 1, grid.length);
                int multipliedDistance = (int) (distanceFromStart(grid[col][row], left) * distanceFromStart(grid[col][row], top) * distanceToEnd(grid[col][row], right) * distanceToEnd(grid[col][row], down));
                distance = Math.max(distance, multipliedDistance);
                System.out.println(multipliedDistance);
            }
        }

        return distance;
    }

    public static double distanceToEnd(int number, int[] subarray) {
        double viewDistance = 0;

        for (int i : subarray) {
            if (i >= number){
                viewDistance++;
                break;
            }
            viewDistance++;
        }


        return viewDistance;
    }

    public static double distanceFromStart(int number, int[] subarray) {
        double viewDistance = 0;

        for (int i = subarray.length - 1; i >= 0; i--) {
            if (subarray[i] >= number){
                viewDistance++;
                break;
            }
            viewDistance++;
        }


        return viewDistance;
    }

    public static int[][] parseFile(){
        try {
            File file = new File("input.txt");
            Scanner scanner = new Scanner(file);
            ArrayList<String> grid = new ArrayList<String>();

            while (scanner.hasNext()) {

                grid.add(scanner.nextLine());
    
            }
    
            scanner.close();
            int[][] matrix = new int[grid.size()][];
            for (int i = 0; i < grid.size(); i++) {
                char[] tab = grid.get(i).toCharArray();
    
                matrix[i] = charToIntArray(tab);
    
            }
    
            return matrix;
    
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
            return null;
        }
    }

    public static int[] charToIntArray(char[] tab) {
        int[] intTab = new int[tab.length];
        for (int i = 0; i < tab.length; i++) {
            intTab[i] = Character.getNumericValue(tab[i]);
        }
        return intTab;
    }

}
