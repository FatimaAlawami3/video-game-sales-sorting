/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author A NWAR DAHAN
 */
import java.io.FileWriter;
import java.io.IOException;

public class InsertionSort {
    public static void main(String[] args) {
      String[][] gameSales = {
    {"Super Mario Land", "18.14"}, 
    {"Call of Duty: Modern Warfare 3", "13.32"}, 
    {"Wii Sports", "82.54"},
    {"Mario Kart Wii", "35.57"},
    {"Pokemon Red/Pokemon Blue", "31.37"},
    {"Halo 3", "12.12"},
    {"New Super Mario Bros.", "29.81"}, 
    {"Grand Theft Auto III", "13.10"},
    {"Wii Fit", "22.70"}, 
    {"Duck Hunt", "28.31"}, 
    {"Animal Crossing: Wild World", "12.13"},
    {"Super Mario Bros.", "40.24"}, 
    {"Pokemon HeartGold/Pokemon SoulSilver", "11.77"},
    {"Call of Duty: Black Ops", "14.67"},
    {"Brain Age: Train Your Brain in Minutes a Day", "20.15"},
    {"Call of Duty: Black Ops 3", "14.80"},
    {"Grand Theft Auto: San Andreas", "20.81"},
    {"Super Smash Bros. Brawl", "12.87"},
    {"Pokemon Diamond/Pokemon Pearl", "18.25"}, 
    {"Nintendogs", "24.67"},
    {"Tetris", "30.26"},
    {"Call of Duty: Black Ops II", "13.69"},
    {"Wii Sports Resort", "32.78"},
    {"Mario Kart DS", "23.22"},
    {"Gran Turismo 3: A-Spec", "14.98"}, 
    {"Pokemon Omega Ruby/Pokemon Alpha Sapphire", "11.95"}, 
    {"Kinect Adventures!", "21.86"},
    {"Super Mario Bros. 3", "17.28"},
    {"New Super Mario Bros. Wii", "28.38"},
    {"Pokemon Black/Pokemon White", "15.14"},
    {"Grand Theft Auto V", "16.30"}, 
    {"Brain Age 2: More Training in Minutes a Day", "15.29"},
    {"Grand Theft Auto: Vice City", "16.15"}, 
    {"Pokemon X/Pokemon Y", "14.92"}, 
    {"Wii Fit Plus", "21.79"},
    {"Mario Kart 7", "13.04"},
    {"Super Mario 64", "11.89"},
    {"Grand Theft Auto V", "13.36"},
    {"Pokemon Ruby/Pokemon Sapphire", "15.85"},
    {"Pokemon Gold/Pokemon Silver", "23.10"},
    {"Call of Duty: Modern Warfare 2", "13.48"},
    {"Grand Theft Auto V", "21.12"},
    {"Grand Theft Auto V", "13.36"},
    {"Call of Duty: Black Ops", "12.64"},
    {"Pokemon Yellow: Special Pikachu Edition", "14.64"},
    {"Gran Turismo 4", "11.66"},
    {"Call of Duty: Modern Warfare 3", "14.77"},
    {"Call of Duty: Black Ops II", "13.79"},
    {"Super Mario World", "20.61"},
    {"Wii Play", "28.92"}
};





        // Record start time
        long startTime = System.nanoTime();

        // Insertion sort algorithm in decreasing order based on global sales
        for (int i = 1; i < gameSales.length; i++) {
            String[] current = gameSales[i];
            double currentSales = Double.parseDouble(current[1]);
            int j = i - 1;

            while (j >= 0 && Double.parseDouble(gameSales[j][1]) < currentSales) {
                gameSales[j + 1] = gameSales[j];
                j--;
            }
            gameSales[j + 1] = current;
        }

        // Record end time and calculate time taken
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) ; // Convert to milliseconds
        long durationInMicro = duration / 1000;  // Convert to microseconds
        // Write sorted data to a file
        try (FileWriter writer = new FileWriter("SortedGameSales(Insertion).txt")) {
            writer.write("Sorted Game Sales in Decreasing Order:\n");
            for (String[] game : gameSales) {
                writer.write("Game: " + game[0] + ", Global Sales: " + game[1] + " million\n");
            }
            writer.write("\nTime taken to sort: " + durationInMicro + " microSecond\n");
            System.out.println("Running time : "+ durationInMicro + " microSecond"  );
            System.out.println("Sorting complete. Check 'SortedGameSales(Insertion).txt' for the sorted results file .");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }
}
