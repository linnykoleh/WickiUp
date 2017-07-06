package patterns._2_structural._6_flyweight;

/**
 * Instance of Item will be the Flyweight
 *
 * @author LinnykOleh
 */
public class Item {

    private final String name;

    public Item(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
