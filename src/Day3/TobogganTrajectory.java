package Day3;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Hanna Edlund
 * Date: 2020-12-05
 * Time: 17:43
 * Project: AdventOfCode
 */
public class TobogganTrajectory {
    public TobogganTrajectory() {
        List<String> mapList = new ArrayList<>();

        try (Scanner s = new Scanner(new FileReader("src/Day3/Map.txt"))) {
            while (s.hasNext()) {
                mapList.add(s.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        long trees = 0;
        trees = slopes(mapList,1,1);
        trees = trees * slopes(mapList,3,1);
        trees = trees * slopes(mapList,5,1);
        trees = trees * slopes(mapList,7,1);
        trees = trees * slopes(mapList,1,2);
        System.out.println(trees);

        // PART 1

//        int amountOfTrees = 0;
//        int charat = 0;
//
//        for (int i = 1; i < mapList.size(); i++) {
//            charat += 3;
//            if (charat >= mapList.get(i).length()) {
//                charat = charat - mapList.get(i).length();
//            }
//
//            if ("#".equalsIgnoreCase("" + mapList.get(i).charAt(charat))) {
//                amountOfTrees++;
//            }
//        }
//
//
//        System.out.println("Träd: " + amountOfTrees);
//        System.exit(0);
    }

    int slopes(List<String> mapList, int right, int down){
        int amountOfTrees = 0;
        int charat = 0;

        for (int i = down; i < mapList.size(); i += down) {
            charat += right;
            if (charat >= mapList.get(i).length()) {
                charat = charat - mapList.get(i).length();
            }

            if ("#".equalsIgnoreCase("" + mapList.get(i).charAt(charat))) {
                amountOfTrees++;
            }
        }

        System.out.println("Träd: " + amountOfTrees);
        return amountOfTrees;
    }

    public static void main(String[] args) {
        TobogganTrajectory tt = new TobogganTrajectory();
    }
}