package patterns._3_behavioral._11_visitor;

/**
 * @author LinnykOleh
 */
public interface AtvPartVisitor {

    void visit(Fender fender);

    void visit(Oil oil);

    void visit(Wheel wheel);

    void visit(PartsOrder partsOrder);
}
