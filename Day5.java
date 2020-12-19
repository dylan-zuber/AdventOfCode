import java.io.*;
import java.util.*;

public class Day5 {
    public static void main(String[] args) throws IOException {
        File file = new File("input.txt");
        Scanner input = new Scanner(file);
        int max = 0;
        int[][] arr = new int[128][8];
        while(input.hasNextLine()) {
            String line = input.nextLine();
            String rows = line.substring(0, 8);
            String cols = line.substring(7);
            int min = 0;
            int max2 = 127;
            int col = 0;
            int row = 0;
            for(int i = 0; i < rows.length(); i++) {
                if(rows.charAt(i) == 'F') {
                    max2 = min + (max2 - min) / 2;
                } else if(rows.charAt(i) == 'B') {
                    min = min + (max2 - min) / 2 + 1;
                }

                if(i == rows.length() - 1) {
                    if(rows.charAt(i) == 'F') {
                        row = max2;
                    } else {
                        row = min;
                    }
                }
            }
            min = 0;
            max2 = 7;
            for(int i = 0; i < cols.length(); i++) {
                if(cols.charAt(i) == 'L') {
                    max2 = min + (max2 - min) / 2;
                } else if(cols.charAt(i) == 'R') {
                    min = min + (max2 - min) / 2 + 1;
                }

                if(i == cols.length() - 1) {
                    if(rows.charAt(i) == 'L') {
                        col = max2;
                    } else {
                        col = min;
                    }
                }
            }
            arr[row][col] = row * 8 + col;
        }
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}