package com.linnyk.ocp.serialization;

import java.io.*;

class Boo implements Serializable {
    transient int ti = 10;
    static int si = 20;
}

public class TestSerialization {

    public static void main(String[] args) throws Exception {
        Boo boo = new Boo();
        boo.si++;
        System.out.println(boo.ti + " " + boo.si);
        FileOutputStream fos = new FileOutputStream("C:\\Users\\Админ\\Desktop\\IdeaProjects\\WickiUp\\OCP\\src\\main\\java\\com\\linnyk\\ocp\\serialization\\boo.ser");
        ObjectOutputStream os = new ObjectOutputStream(fos);
        os.writeObject(boo);
        os.close();

        FileInputStream fis = new FileInputStream("C:\\Users\\Админ\\Desktop\\IdeaProjects\\WickiUp\\OCP\\src\\main\\java\\com\\linnyk\\ocp\\serialization\\boo.ser");
        ObjectInputStream is = new ObjectInputStream(fis);
        boo = (Boo) is.readObject();
        is.close();
        System.out.println(boo.ti + " " + boo.si);
    }

}
