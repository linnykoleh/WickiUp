package solid.step_by_step._2_plus_single_responsibility;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author LinnykOleh
 */
public class StoreCache {

    private Map<Integer, String> cache = new ConcurrentHashMap<>();

    public StoreCache() {
        this.cache = new ConcurrentHashMap<>();
    }

    public void putMessage(int id, String message){
        this.cache.put(id, message);
    }

    public String getMessage(int id, String defaultValue){
        return this.cache.getOrDefault(id, defaultValue);
    }
}
