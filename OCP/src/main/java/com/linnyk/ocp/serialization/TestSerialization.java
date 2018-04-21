package com.linnyk.ocp.serialization;

import java.io.*;

class Boo implements Serializable {
    static String f1;
    static transient int f2;
    transient boolean f3;
    transient String f33;
    final static String f4 = "4";
    String f5 = "5";

    @Override
    public String toString() {
        return "Boo{" +
                "f1='" + f1 + '\'' +
                ", f2=" + f2 +
                ", f3=" + f3 +
                ", f33='" + f33 + '\'' +
                ", f4='" + f4 + '\'' +
                ", f5='" + f5 + '\'' +
                '}';
    }
}

public class TestSerialization {

    public static void main(String[] args) throws Exception {
        Boo boo = new Boo();
        boo.f1 = "f1";
        boo.f2 = 2;
        boo.f3 = true;
        boo.f33 = "33";
        System.out.println(boo);
        FileOutputStream fos = new FileOutputStream("C:\\Users\\Админ\\Desktop\\IdeaProjects\\WickiUp\\OCP\\src\\main\\java\\com\\linnyk\\ocp\\serialization\\boo.ser");
        ObjectOutputStream os = new ObjectOutputStream(fos);
        os.writeObject(boo);
        os.close();

        FileInputStream fis = new FileInputStream("C:\\Users\\Админ\\Desktop\\IdeaProjects\\WickiUp\\OCP\\src\\main\\java\\com\\linnyk\\ocp\\serialization\\boo.ser");
        ObjectInputStream is = new ObjectInputStream(fis);
        Boo booNew = (Boo) is.readObject();
        is.close();
        System.out.println(booNew);
    }

}
