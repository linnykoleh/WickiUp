package solid.l.bad.example1;

/**
 * @author LinnykOleh
 */
public abstract class Base {

    abstract void doIt1();

    abstract void doIt2();
}

class Child extends Base{

    @Override
    void doIt1() {
        throw new RuntimeException();
    }

    @Override
    void doIt2() {
        //some business logic
    }
}