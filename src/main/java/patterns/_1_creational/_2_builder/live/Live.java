package patterns._1_creational._2_builder.live;

/**
 * @author LinnykOleh
 */
public class Live {

    public static void main(String[] args) {
        final StringBuilder builder = new StringBuilder();

        builder.append(true);
        builder.append("hello");
        builder.append(123);
        builder.append(new Object());
        builder.append(0.001);

        final String result = builder.toString();

        System.out.println(result);
    }
}
