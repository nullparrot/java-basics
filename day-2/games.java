import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class games {

    public static void main(String[] args) {
        System.out.println("Crunching numbers now...");
        // Prep total variable
        int total = 0;

        // Cube counts
        int red = 12;
        int green = 13;
        int blue = 14;

        // Prepare regex for cube counts
        String regexString = "(?<red>[0-9]+)(?: red)|(?<green>[0-9]+)(?: green)|(?<blue>[0-9]+)(?: blue)";
        Pattern search = Pattern.compile(regexString);

        // Try to open the input text file
        try {
            BufferedReader inp = new BufferedReader(
                    new InputStreamReader(new FileInputStream("input.txt"))
            );
            try {
                // Prepare to read each line of the file
                String line;
                // Iterate through the file
                while ((line = inp.readLine()) != null) {
                    boolean possible = true;
                    List<String> rounds = Arrays.asList(line.split(":|;"));
                    int game = Integer.parseInt(rounds.get(0).replaceAll("[^0-9]", ""));
                    rounds.removeFirst();
                    for (String round : rounds) {
                        Matcher cubes = search.matcher(round);
                        int redCount = 0;
                        try {
                            redCount = Integer.parseInt(cubes.group("green"));
                        } catch (UnsupportedOperationException e) {
                            redCount = 0;
                        }
                        System.out.println(redCount);
                    }
                }
                // Close the file and print the answer to console
                inp.close();
                System.out.println(total);

            } catch (Exception c) {
                System.err.println(c);
            }
        } catch (Exception e) {
            System.err.println("Closing File");
        }

    }

    // public static String replaceWordNumbers(String word) {
    //     // For the input string, replace word numbers with numbers.
    //     // I left the last character of each number to handle edge cases where teo numbers share a last and first character.
    //     String nums = word.replaceAll("one", "1e");
    //     nums = nums.replaceAll("two", "2o");
    //     nums = nums.replaceAll("three", "3e");
    //     nums = nums.replaceAll("four", "4");
    //     nums = nums.replaceAll("five", "5e");
    //     nums = nums.replaceAll("six", "6");
    //     nums = nums.replaceAll("seven", "7n");
    //     nums = nums.replaceAll("eight", "8t");
    //     nums = nums.replaceAll("nine", "9e");
    //     return nums;
    // }
}
