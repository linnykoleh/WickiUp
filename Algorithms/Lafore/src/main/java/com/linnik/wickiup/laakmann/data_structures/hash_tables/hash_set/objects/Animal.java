package com.linnik.wickiup.laakmann.data_structures.hash_tables.hash_set.objects;

import java.util.Objects;

/**
 * @author LinnykOleh
 */
public class Animal {

    private String name;

    public Animal(String name) {
        this.name = name;
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public final boolean equals(Object o) {
        if (o == this)
            return true;
        if (o instanceof Animal) {
            Animal e = (Animal)o;
            return Objects.equals(name, e.name);
        }
        return false;
    }

}
