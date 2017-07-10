package patterns._3_behavioral._3_interpreter.live;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author LinnykOleh
 */
public class Live {

    public static void main(String[] args) {
        final String input = "Lions and tigers and bears! Oh, my!";

        final Pattern pattern = Pattern.compile("(lion|cat|dog|wolf|bear|human|tiger|liger|Lion)");

        final Matcher matcher = pattern.matcher(input);
        while (matcher.find()){
            System.out.println("Found a " + matcher.group());
        }
    }
}
