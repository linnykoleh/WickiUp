package patterns._2_structural._5_facade.live;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * @author LinnykOleh
 */
public class Live {

    public static void main(String[] args) throws IOException {
        final URL url = new URL("http", "google.com", 80, "/search");

        final BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

        String inputLine;

        while ((inputLine = in.readLine()) != null){
            System.out.println(inputLine);
        }
    }
}
