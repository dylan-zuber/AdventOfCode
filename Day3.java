import java.io.*;
import java.util.*;

public class Day3 {
    public static void main(String[] args) throws IOException {
        File file = new File("input.txt");
        Scanner input = new Scanner(file);
        char[][] arr = new char[323][31];
        int i = 0, j = 0;
        while(input.hasNextLine()) {
            String line = input.nextLine();
            for(i = 0; i < line.length(); i++) {
                arr[j][i] = line.charAt(i);
            }
            j++;
        }

        int result = 0;
        i = 0;
        for(int n = 0; n < 323; n++) {
            if(i >= 31) {
                i -= 31;
            }
            if(arr[n][i] == '#'){
                result++;
            } 
            i += 1;
        }

        i = 0;
        int result2 = 0;
        for(int n = 0; n < 323; n++) {
            if(i >= 31) {
                i -= 31;
            }
            if(arr[n][i] == '#'){
                result2++;
            } 
            i += 3;
        }
        result = result * result2;
        i = 0;
        result2 = 0;
        for(int n = 0; n < 323; n++) {
            if(i >= 31) {
                i -= 31;
            }
            if(arr[n][i] == '#'){
                result2++;
            } 
            i += 5;
        }
        result = result * result2;
        i = 0;
        result2 = 0;
        for(int n = 0; n < 323; n++) {
            if(i >= 31) {
                i -= 31;
            }
            if(arr[n][i] == '#'){
                result2++;
            } 
            i += 7;
        }
        result = result * result2;
        i = 0;
        result2 = 0;
        for(int n = 0; n < 323; n+=2) {
            if(i >= 31) {
                i -= 31;
            }
            if(arr[n][i] == '#'){
                result2++;
            } 
            i += 1;
        }
        result *= result2;

        System.out.println(result);

    }
}