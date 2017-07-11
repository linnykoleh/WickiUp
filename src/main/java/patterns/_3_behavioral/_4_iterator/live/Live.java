package patterns._3_behavioral._4_iterator.live;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author LinnykOleh
 */
public class Live {

    public static void main(String[] args) {
        final List<String> names = new ArrayList<>();

        names.add("Bryan");
        names.add("Aaron");
        names.add("Jason");

        for (String name : names) { // used Iterator
            System.out.println(name);
        }

        final Iterator<String> namesItr = names.iterator();
        while (namesItr.hasNext()){
            final String name = namesItr.next();
            System.out.println(name);
            namesItr.remove();
        }

        System.out.println("Size: " + names.size());
    }
}
