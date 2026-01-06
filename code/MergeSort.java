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

public class MergeSort {
    public static void main(String[] args) {
        // Game sales data (name and sales in millions)
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

        // Record the start time to measure sorting duration
        long startTime = System.nanoTime();

        // Apply merge sort on the game sales data
        mergeSort(gameSales, 0, gameSales.length - 1);

        // Record the end time and calculate duration
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        long durationInMicro = duration / 1000;  // Convert to microseconds
        // Write sorted data to a file
        try (FileWriter writer = new FileWriter("SortedGameSales(merge).txt")) {
            writer.write("Sorted Game Sales in Decreasing Order:\n");
            for (String[] game : gameSales) {
                writer.write("Game: " + game[0] + ", Global Sales: " + game[1] + " million\n");
            }
            writer.write("\nTime taken to sort: " + durationInMicro + " microSecond\n");
            System.out.println("Running time : "+ durationInMicro + " microSecond"  );
            System.out.println("Sorting complete. Check 'SortedGameSales(merge).txt' for the sorted results file .");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }

    // Recursive merge sort function to sort data in decreasing order
    public static void mergeSort(String[][] array, int left, int right) {
        if (left < right) {
            // Find the middle point of the current section
            int mid = left + (right - left) / 2;

            // Recursively sort each half
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);

            // Merge the sorted halves
            merge(array, left, mid, right);
        }
    }

    // Function to merge two sorted halves
    public static void merge(String[][] array, int left, int mid, int right) {
        // Determine the sizes of two halves
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Temporary arrays to hold the left and right halves
        String[][] leftArray = new String[n1][2];
        String[][] rightArray = new String[n2][2];

        // Copy data to temporary arrays
        for (int i = 0; i < n1; i++)
            leftArray[i] = array[left + i];
        for (int j = 0; j < n2; j++)
            rightArray[j] = array[mid + 1 + j];

        // Merge the two halves back into the main array in decreasing order
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (Double.parseDouble(leftArray[i][1]) >= Double.parseDouble(rightArray[j][1])) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Copy any remaining elements of leftArray, if any
        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        // Copy any remaining elements of rightArray, if any
        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }
}
