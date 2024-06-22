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

        // // Cube counts
        // int red = 12;
        // int green = 13;
        // int blue = 14;

        // Prepare regex for cube counts
        String redString = "(?<red>[0-9]+)(?: red)";
        String greenString = "(?<green>[0-9]+)(?: green)";
        String blueString = "(?<blue>[0-9]+)(?: blue)";
        Pattern redSearch = Pattern.compile(redString);
        Pattern greenSearch = Pattern.compile(greenString);
        Pattern blueSearch = Pattern.compile(blueString);

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
                    int minRed = 0;
                    int minGreen = 0;
                    int minBlue = 0;
                    boolean possible = true;
                    List<String> rounds = Arrays.asList(line.split(":|;"));
                    int game = Integer.parseInt(rounds.get(0).replaceAll("[^0-9]", ""));
                    for (String round : rounds) {
                        if (possible){
                            Matcher redCubes = redSearch.matcher(round);
                            boolean redSuccess = redCubes.find();
                            Matcher greenCubes = greenSearch.matcher(round);
                            boolean greenSuccess = greenCubes.find();
                            Matcher blueCubes = blueSearch.matcher(round);
                            boolean blueSuccess = blueCubes.find();
                        int redCount = Integer.parseInt( redSuccess ? redCubes.group("red") :"0") ;
                        int greenCount = Integer.parseInt( greenSuccess ? greenCubes.group("green") :"0") ;
                        int blueCount = Integer.parseInt( blueSuccess ? blueCubes.group("blue") :"0") ;
                        if (redCount > minRed) {
                            minRed = redCount;
                        }
                        if (greenCount > minGreen) {
                            minGreen = greenCount;
                        }
                        if (blueCount > minBlue) {
                            minBlue = blueCount;
                        }
                        }
                    }
                    total += minRed*minGreen*minBlue;
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
}
