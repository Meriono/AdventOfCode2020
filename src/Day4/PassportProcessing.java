package Day4;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Hanna Edlund
 * Date: 2020-12-05
 * Time: 22:57
 * Project: AdventOfCode
 */
public class PassportProcessing {
    public PassportProcessing() {
        List<String> passportList = new ArrayList<>();
        List<String> validPassportList = new ArrayList<>();
        String temp = "";

        try (Scanner s = new Scanner(new FileReader("src/Day4/Passports.txt"))) {
            while (s.hasNext()) {
                String next = s.nextLine();
                temp += next;
                temp += " ";
                if(next.equalsIgnoreCase("")){
                    passportList.add(temp);
                    temp = "";
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // PART 1

        for (int i = 0; i < passportList.size(); i++) {
            String passport = passportList.get(i);
            if(passport.contains("byr:") && passport.contains("iyr:") && passport.contains("eyr:") && passport.contains("hgt:") && passport.contains("hcl:")&& passport.contains("ecl:") && passport.contains("pid:")){
                validPassportList.add(passport);
            }
        }

        System.out.println("Valid: " + validPassportList.size());


        // PART 2
        int validPassports = 0;

        for (int i = 0; i < validPassportList.size(); i++) {
            String p = validPassportList.get(i);
            if(vByr(p) && vIyr(p) && vEyr(p) && vHgt(p) && vEcl(p) && vPid(p) && vHcl(p)){
                validPassports++;
            }
        }

        System.out.println("new Valid: " + validPassports);
        System.exit(0);
    }

    boolean vByr(String s){
        int from = 4;
        from += s.indexOf("byr:");
        int to = s.indexOf(" ", from);
        int check = Integer.parseInt(s.substring(from, to));
        if(check <= 2002 && check >= 1920)
            return true;
        else return false;
    }

    boolean vIyr(String s){
        int from = 4;
        from += s.indexOf("iyr:");
        int to = s.indexOf(" ", from);
        int check = Integer.parseInt(s.substring(from, to));
        if(check <= 2020 && check >= 2010)
            return true;
        else return false;
    }

    boolean vEyr(String s){
        int from = 4;
        from += s.indexOf("eyr:");
        int to = s.indexOf(" ", from);
        int check = Integer.parseInt(s.substring(from, to));
        if(check <= 2030 && check >= 2020)
            return true;
        else return false;
    }

    boolean vHgt(String s){
        int from = 4;
        from += s.indexOf("hgt:");
        int to = s.indexOf(" ", from);
        String check = s.substring(from, to);
        int length = check.length()-2;
        int c = Integer.parseInt(check.substring(0,length));
        if(check.endsWith("cm")){
            if(c <= 193 && c >= 150)
                return true;
            else
                return false;
        }
        else if(check.endsWith("in")){
            if(c <= 76 && c >= 59)
                return true;
            else
                return false;
        }
        else return false;
    }

    boolean vEcl(String s){
        int from = 4;
        from += s.indexOf("ecl:");
        int to = s.indexOf(" ", from);
        String check = s.substring(from, to);
        return switch (check) {
            case "amb" -> true;
            case "blu" -> true;
            case "brn" -> true;
            case "gry" -> true;
            case "grn" -> true;
            case "hzl" -> true;
            case "oth" -> true;
            default -> false;
        };
    }

    boolean vPid(String s){
        int from = 4;
        from += s.indexOf("pid:");
        int to = s.indexOf(" ", from);
        String check = s.substring(from, to);
        if(check.length() == 9 && check.matches("[0-9]+"))
            return true;
        else return false;
    }

    boolean vHcl(String s){
        int from = 4;
        from += s.indexOf("hcl:");
        int to = s.indexOf(" ", from);
        String check = s.substring(from, to);
        String after = check.substring(1);
        if(check.indexOf("#") == 0 && after.length() == 6 && after.matches("[0-9a-f]+"))
            return true;

        else return false;
    }


    public static void main(String[] args) {
        PassportProcessing pp = new PassportProcessing();
    }
}
