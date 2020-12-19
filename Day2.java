import java.io.*;
import java.util.*;

public class Day2 {
    public static void main(String[] args) throws IOException {
        int result = 0;
        File file = new File("input.txt");
        Scanner input = new Scanner(file);
        while(input.hasNextLine()) {
            String line = input.next();
            Scanner scan = new Scanner(line);
            String range = scan.next();
            String c = input.next();
            char c2 = c.charAt(0);
            String password = input.next();

            int i = 1;
            for(i = 1; i < range.length(); i++) {
                if(range.charAt(i) == '-') {
                    break;
                }
            }
            int range1 = Integer.parseInt(range.substring(0, i));
            int range2 = Integer.parseInt(range.substring(i+1, range.length()));

            //wait until 2:11


            boolean test1 = false;
            if(range1-1 < password.length()) {
                test1 = password.charAt(range1-1) == c2;
            }
           // boolean test1 = password.charAt(range1+1) == c2;
            boolean test2 = false;
            if(range2-1 < password.length()) {
                test2 = password.charAt(range2-1) == c2;
            }

            if((test1 && !test2) || (!test1 && test2)) result++;
        }
        System.out.println(result);
    }
}