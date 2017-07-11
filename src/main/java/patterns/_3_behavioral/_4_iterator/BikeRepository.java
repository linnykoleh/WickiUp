package patterns._3_behavioral._4_iterator;

import java.util.Iterator;

/**
 * @author LinnykOleh
 */
public class BikeRepository implements Iterable<String>{

    private String[] bikes;
    private int index;

    public BikeRepository(){
        this.bikes = new String[10];
        this.index = 0;
    }

    public void addBike(String bike){
        if(index == bikes.length){
            String[] largeBikes = new String[bikes.length + 5];
            System.arraycopy(bikes, 0, largeBikes, 0, bikes.length);
            bikes = largeBikes;
            largeBikes = null;
        }
        bikes[index] = bike;
        index++;
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < bikes.length && bikes[currentIndex] != null;
            }

            @Override
            public String next() {
                return bikes[currentIndex++];
            }
        };
    }
}
