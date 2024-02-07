package xcode_launch;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class CookieHandlerExample {
	
	
	public static void main(String[] args) {
        try {
            // Replace this URL with the actual URL you want to connect to
            String url = "https://www.xcite.com/";

            // Create a URL object
            URL obj = new URL(url);

            // Open a connection to the URL
            HttpURLConnection connection = (HttpURLConnection) obj.openConnection();

            // Get the response code
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            // Get and print cookies from the response header
            Map<String, List<String>> headerFields = connection.getHeaderFields();
            List<String> cookies = headerFields.get("Set-Cookie");

            if (cookies != null) {
                System.out.println("Cookies received:");

                for (String cookie : cookies) {
                    System.out.println(cookie);
                }
            } else {
                System.out.println("No cookies received.");
            }

            // Read the HTML content of the page
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }

            // Close the connection
            in.close();

            // Now you can process the HTML content as needed

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


