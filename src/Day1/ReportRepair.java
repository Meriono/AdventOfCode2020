package Day1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Hanna Edlund
 * Date: 2020-12-05
 * Time: 15:46
 * Project: AdventOfCode
 */
public class ReportRepair {
    public ReportRepair() {
        List<Integer> reportList = new ArrayList<>();

        try (Scanner s = new Scanner(new FileReader("src/Day1/Report.txt"))) {
            while (s.hasNext()) {
                reportList.add(s.nextInt());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
/*
        PART 1
                for (int i = 0; i < reportList.size(); i++) {
            for (int j = i+1; j < reportList.size(); j++) {
                if(reportList.get(i)+reportList.get(j) == 2020){
                    System.out.println(reportList.get(i) +" + " + reportList.get(j) + " = 2020");
                    System.out.println(reportList.get(i)*reportList.get(j));
                    System.exit(0);
                }
            }
        }
 */
        // PART 2
        for (int i = 0; i < reportList.size(); i++) {
            for (int j = i+1; j < reportList.size(); j++) {
                for (int k = j+1; k < reportList.size(); k++) {
                    if(reportList.get(i)+reportList.get(j)+ reportList.get(k) == 2020){
                        System.out.println(reportList.get(i) +" + " + reportList.get(j) + " + " + reportList.get(k) +" = 2020");
                        System.out.println(reportList.get(i)*reportList.get(j)*reportList.get(k));
                        System.exit(0);
                    }
                }

            }
        }

    }

    public static void main(String[] args) {
        ReportRepair rr = new ReportRepair();
    }
}
