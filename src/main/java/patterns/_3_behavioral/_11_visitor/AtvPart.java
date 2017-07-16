package patterns._3_behavioral._11_visitor;

/**
 * @author LinnykOleh
 */
public interface AtvPart {

    void accept(AtvPartVisitor visitor);
}
