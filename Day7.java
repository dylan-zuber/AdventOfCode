import java.io.*;
import java.util.*;

public class Day7 {
    public static void main(String[] args) throws IOException {
        File file = new File("input.txt");
        Scanner input = new Scanner(file);
        Map<String, Map<String, Integer>> map = new HashMap<String, Map<String, Integer>>();
        String line = "";
        Set<String> set = new HashSet<String>();
        while(input.hasNextLine()) {
            line = input.nextLine();
            String name = input.next();
            String token = input.next();
            while(!token.equals("bags")) {
                name = name + " " + token;
                token = input.next();
            }
            input.next();
            int num;
            Map<String, Integer> buildMap = new HashMap<String, Integer>();
            String newName = "";
            while(input.hasNext()) {
                num = input.nextInt();
                newName = input.next();
                token = input.next();
                while(input.hasNext() && ((!token.equals("bags,") && !token.equals("bags.")))) {
                    newName = newName + " " + token;
                    token = input.next();
                }
                buildMap.put(newName, num);
            }
            map.put(name, buildMap);
        }
        System.out.println(map.toString());
    }
}