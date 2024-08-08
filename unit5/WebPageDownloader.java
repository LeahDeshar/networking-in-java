package unit5;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class WebPageDownloader {

    public static void main(String[] args) {
        String urlString = "http://example.com";  // URL of the web page to download
        String outputFileName = "downloaded_page.html";  // File to save the downloaded page

        try {
            // Step 1: Construct URL object
            URL url = new URL(urlString);

            // Step 2: Open connection to URL
            URLConnection conn = url.openConnection();

            // Step 3: Get the input stream from URL connection
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            // Step 4: Read data and save to file
            FileWriter fileWriter = new FileWriter(outputFileName);
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                fileWriter.write(inputLine + "\n");
            }

            // Step 5: Close the input stream and file writer
            in.close();
            fileWriter.close();

            System.out.println("Web page downloaded successfully and saved to " + outputFileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
