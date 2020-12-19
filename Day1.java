import java.io.*;
import java.util.*;

public class Day1 {
    public static void main(String[] args) throws IOException {
        File file = new File("advent.txt");
        Scanner input = new Scanner(file);
        Set<Integer> set = new HashSet<Integer>();
        List<Integer> list = new ArrayList<Integer>();
        while(input.hasNext()) {
            int num = input.nextInt();
            set.add(num);
            list.add(num);
        }
        for(int i = 0; i < list.size(); i++) {
            int a = list.get(i);
            for(int j = 0; j < list.size(); j++) {
                int b = list.get(j);
                for(int k = 0; k < list.size(); k++) {
                    int c = list.get(k);
                    if(a + b + c == 2020) {
                        System.out.println(a*b*c);
                    }
                }
            }
        }
    }
}