
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class gondola {

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
}
