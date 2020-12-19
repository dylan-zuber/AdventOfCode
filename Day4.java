import java.io.*;
import java.util.*;

public class Day4 {
    public static void main(String[] args) throws IOException {
        File file = new File("input.txt");
        Scanner input = new Scanner(file);
        Map<String, String> map = new HashMap<String, String>();
        List<String> set = new ArrayList<String>();
        set.add("byr");
        set.add("iyr");
        set.add("eyr");
        set.add("hgt");
        set.add("hcl");
        set.add("ecl");
        set.add("pid");
        set.add("cid");
        int valid = 0;
        while(input.hasNextLine()) {
            String line = input.nextLine();
            if(line.equals("")) {
                if(map.size() == set.size() || (!map.containsKey("cid") && map.size() == set.size() - 1)){
                    if(isValid(map)) {
                        //System.out.println(map.toString());
                        valid++;
                    }
                }
                map = new HashMap<String, String>();
            }
            Scanner scan = new Scanner(line);
            while(scan.hasNext()) {
                String token = scan.next();
                String[] values = token.split(":");
                map.put(values[0], values[1]);
            }
        }
        if(map.size() == set.size() || (!map.containsKey("cid") && map.size() == set.size() - 1)){
            if(isValid(map)) {
                valid++;
               // System.out.println(map.toString());
            }
        } 
        System.out.println(valid);
    }

    public static boolean isValid(Map<String, String> map) {
        int count = 0;
        int byr = Integer.parseInt(map.get("byr"));
        int iyr = Integer.parseInt(map.get("iyr"));
        int eyr = Integer.parseInt(map.get("eyr"));
        String hgt = map.get("hgt");
        String hcl = map.get("hcl");
        String ecl = map.get("ecl");
        String pid = map.get("pid");
        
        if(String.valueOf(byr).length() == 4 && byr >= 1920 && byr <= 2002){
            count++;
         //   return true;
         //   System.out.println("hit byr");
        } 
        if(String.valueOf(iyr).length() == 4 && iyr >= 2010 && iyr <= 2020) {
            count++;
           // return true;
         //   System.out.println("hit iyr");
        } 
        if(String.valueOf(eyr).length() == 4 && eyr >= 2020 && eyr <= 2030){
            count++;
         //   return true;
         //   System.out.println("hit eyr");
        }
        int i = 0;
        while(i < hgt.length() && Character.isDigit(hgt.charAt(i))) {
            i++;
        }
        int hgtNum = Integer.parseInt(hgt.substring(0, i));
        String hgt2 = hgt.substring(i, hgt.length());
        if((hgt2.equals("cm") && hgtNum >= 150 && hgtNum <=193) || (hgt2.equals("in") && hgtNum >= 59 && hgtNum <= 76)){
           // System.out.println("hit hgt");
            count++;
          //  System.out.println(hgt);
          //  return true;
        }
        if(hcl.charAt(0) == '#') {
            int j = 1;
            while(j < hcl.length()) {
                if(Character.isDigit(hcl.charAt(j)) || hcl.charAt(j) == 'a' || hcl.charAt(j) == 'b' || hcl.charAt(j) == 'c' 
                || hcl.charAt(j) == 'd' || hcl.charAt(j) == 'e' || hcl.charAt(j) == 'f') {
                    j++;
                } else {
                    break;
                }
            }
            if( j == 7){
              //  System.out.println(hcl);
                count++;
              //  return true;
             //   System.out.println("hit hcl");
            }
        }

        if(ecl.equals("amb") || ecl.equals("blu") || ecl.equals("brn") || ecl.equals("gry") ||
        ecl.equals("grn") || ecl.equals("hzl") || ecl.equals("oth")){
           // System.out.println("hit ecl");
         //   System.out.println(ecl);
            count++;
        }

        i = 0;
        while(i < pid.length()) {
            if(Character.isDigit(pid.charAt(i))) {
                i++;
            } else {
                break;
            }
        }
        if(i == pid.length() && pid.length() == 9) {
         //   System.out.println("hit pid");
         System.out.println(pid);
            count++;
        }
     //   System.out.println(count);
        return count == 7;
    }
}