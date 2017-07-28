package com.linnik.wickiup.patterns._2_structural._6_flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * Catalog acts as a factory and cache for Item flyweight objects
 *
 * @author LinnykOleh
 */
public class Catalog {

    private Map<String, Item> items = new HashMap<>();

    public Item lookUp(String itemName){
        if(!items.containsKey(itemName)){
            items.put(itemName, new Item(itemName));
        }
        return items.get(itemName);
    }

    public int totalItemsMade(){
        return items.size();
    }
}
