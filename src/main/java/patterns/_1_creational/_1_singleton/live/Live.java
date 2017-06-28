package patterns._1_creational._1_singleton.live;



/**
 * @author LinnykOleh
 */
public class Live {

    public static void main(String[] args) {
        final Runtime runTime = Runtime.getRuntime(); //singleton
        runTime.gc();

        final Runtime anotherRunTime = Runtime.getRuntime(); //singleton

        System.out.println(runTime == anotherRunTime); // true
    }
}
