import java.io.*;
import java.util.*;

public class Day6 {
    public static void main(String[] args) throws IOException {
        File file = new File("input.txt");
        Scanner input = new Scanner(file);
        int[] arr = new int[26];
        int sum = 0;
        int numPeople = 0;
        for(int i = 0; i < arr.length; i++) {
            arr[i] = 0;
        }
        while(input.hasNextLine()) {
            String line = input.nextLine();
            if(line.equals("")) {
                for(int i = 0; i < arr.length; i++) {
                    if(arr[i] == numPeople) sum++;
                }
                arr = new int[26];
                for(int i = 0; i < arr.length; i++) {
                    arr[i] = 0;
                }
                numPeople = 0;
            } else {
                numPeople++;
                for(int i = 0; i < line.length(); i++) {
                    arr[line.charAt(i) - 'a'] = arr[line.charAt(i) - 'a'] + 1;
                }
            }
        }
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == numPeople) sum++;
        }
        System.out.println(sum);
    }
}