package patterns._2_structural._6_flyweight.live;

/**
 * @author LinnykOleh
 */
public class Live {

    public static void main(String[] args) {
        final Integer f = Integer.valueOf(5);
        final Integer s = Integer.valueOf(5);
        final Integer t = Integer.valueOf(15);

        System.out.println(System.identityHashCode(f));
        System.out.println(System.identityHashCode(s));
        System.out.println(System.identityHashCode(t));
    }
}
