package Day2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Hanna Edlund
 * Date: 2020-12-05
 * Time: 16:17
 * Project: AdventOfCode
 */

public class PasswordPhilosophy {
    public PasswordPhilosophy() {
        List<String> passwordList = new ArrayList<>();

        try (Scanner s = new Scanner(new FileReader("src/Day2/Passwords.txt"))) {
            while (s.hasNext()) {
                passwordList.add(s.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int correctPasswords = 0;
        int min;
        int max;
        String mustHave;
        String password;

/*
            PART 1

                    for (int i = 0; i < passwordList.size(); i++) {
            int from = passwordList.get(i).indexOf("-");
            min = Integer.parseInt(passwordList.get(i).substring(0,from));
            int policy = passwordList.get(i).indexOf(":") -1;
            max = Integer.parseInt(passwordList.get(i).substring(from+1, policy-1));
            mustHave = passwordList.get(i).substring(policy, policy+1);
            int passwordInt = passwordList.get(i).lastIndexOf(" ")+1;
            password = passwordList.get(i).substring(passwordInt);

            if(password.contains(mustHave)){
                int amountOfMustHave = 0;
                for (int j = 0; j < password.length(); j++) {
                    if(mustHave.equalsIgnoreCase(""+password.charAt(j))){
                        amountOfMustHave++;
                    }
                }
                if(amountOfMustHave >= min && amountOfMustHave <= max){
                    correctPasswords++;
                }
            }
        }

 */

//  PART 2

        for (int i = 0; i < passwordList.size(); i++) {
            int from = passwordList.get(i).indexOf("-");
            min = Integer.parseInt(passwordList.get(i).substring(0,from));
            int policy = passwordList.get(i).indexOf(":") -1;
            max = Integer.parseInt(passwordList.get(i).substring(from+1, policy-1));
            mustHave = passwordList.get(i).substring(policy, policy+1);
            int passwordInt = passwordList.get(i).lastIndexOf(" ")+1;
            password = passwordList.get(i).substring(passwordInt);

            if(password.contains(mustHave)){
                if(mustHave.equalsIgnoreCase(""+password.charAt(min-1)) && !(mustHave.equalsIgnoreCase(""+password.charAt(max-1)))){
                    correctPasswords++;
                }

                if(mustHave.equalsIgnoreCase(""+password.charAt(max-1)) && !(mustHave.equalsIgnoreCase(""+password.charAt(min-1)))){
                    correctPasswords++;
                }
            }
        }

        System.out.println("Antal rätt: " + correctPasswords);
        System.exit(0);
    }

    public static void main(String[] args) {
        PasswordPhilosophy pp = new PasswordPhilosophy();
    }
}
