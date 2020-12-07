package Day5;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Hanna Edlund
 * Date: 2020-12-07
 * Time: 01:26
 * Project: AdventOfCode
 */
public class BinaryBoarding {
    public BinaryBoarding() {
        List<String> boardingpassList = new ArrayList<>();

        try (Scanner s = new Scanner(new FileReader("src/Day5/Boardingpasses.txt"))) {
            while (s.hasNext()) {
                boardingpassList.add(s.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        BinaryBoarding bb = new BinaryBoarding();
    }
}
