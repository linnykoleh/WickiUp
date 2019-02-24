package com.linnyk.ocp;

public class ReferenceValuePassing {

    static class Pet {
        String name = "Dog";
    }

    public static void main(String[] args) {
        Pet pet = new Pet();
        System.out.println(pet);

        changeReference(pet);

        System.out.println(pet);
        // com.linnyk.ocp.ReferenceValuePassing$Pet@266474c2
        // com.linnyk.ocp.ReferenceValuePassing$Pet@266474c2

        updateObject(pet);

        System.out.println(pet.name);
        // Cat
    }

    static void changeReference(Pet pet) {
        pet = new Pet();
    }

    static void updateObject(Pet pet) {
        pet.name = "Cat";
    }
}