
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class trebuchet {

    public static void main(String[] args) {
        System.out.println("Crunching numbers now...");
        // Prep total variable
        int total = 0;

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
                    String word = "";
                    // Parse each line one character at a time to replace word numbers
                    for (int i = 0; i < line.length(); i++) {
                        // Add the next character to the string
                        word += line.charAt(i);
                        // Check for numbers that need to be replaced
                        word = replaceWordNumbers(word);
                    }
                    // Remove all letters from the string
                    String nums = word.replaceAll("[a-z]", "");
                    // Get the first and last number
                    String number = "" + nums.charAt(0) + nums.charAt(nums.length() - 1);
                    // Add the number to the total
                    total += Integer.parseInt(number);
                }
                // Close the file and print the answer to console
                inp.close();
                System.out.println(total);

            } catch (Exception c) {
                System.err.println("Error Occured.. Closing File");
            }
        } catch (Exception e) {
            System.err.println("Closing File");
        }

    }

    public static String replaceWordNumbers(String word) {
        // For the input string, replace word numbers with numbers.
        // I left the last character of each number to handle edge cases where teo numbers share a last and first character.
        String nums = word.replaceAll("one", "1e");
        nums = nums.replaceAll("two", "2o");
        nums = nums.replaceAll("three", "3e");
        nums = nums.replaceAll("four", "4");
        nums = nums.replaceAll("five", "5e");
        nums = nums.replaceAll("six", "6");
        nums = nums.replaceAll("seven", "7n");
        nums = nums.replaceAll("eight", "8t");
        nums = nums.replaceAll("nine", "9e");
        return nums;
    }
}
