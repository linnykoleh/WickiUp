package lafore.data_structures.hash_tables.open_addressing.double_hashing;

/**
 * @author LinnykOleh
 */
public class DataItem {

    private int iData;

    public DataItem(int iData) {
        this.iData = iData;
    }

    public int getKey(){
        return this.iData;
    }
}
