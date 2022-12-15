package Day_08;

import java.io.*;
import java.util.*;

public class Part_01 {
    
    public static void main(String[] args){
            int[][] grid = parseFile();
            System.out.println(countVisible(grid));
    }

    // Count the number of visible "trees"
    // A tree is visible if it there all the other trees between it and an edge are shorter
    public static int countVisible(int[][] grid){
        int count = grid.length * 2 + grid[0].length * 2 - 4;
        
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
                if (isVisible(grid[col][row], left) || isVisible(grid[col][row], right) || isVisible(grid[col][row], top) || isVisible(grid[col][row], down))
                    count++;
            }
        }

        return count;
    }

    public static boolean isVisible(int number, int[] subarray) {
		for (int i : subarray) {
			if (i >= number)
				return false;
		}
		return true;
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
