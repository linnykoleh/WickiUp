package com.linnyk.ocp.concurrency.ocp._3;

import java.io.IOException;
import java.sql.Connection;

public class TestExceptionTryWithResources {

    public static void main(String[] args) throws Exception {
        readData("ddd");

        /*
         Exception in thread "main" java.lang.ClassNotFoundException
            at com.java.concurrency.ocp._3.TestExceptionTryWithResources.getConnection(TestExceptionTryWithResources.java:19)
            at com.java.concurrency.ocp._3.TestExceptionTryWithResources.readData(TestExceptionTryWithResources.java:14)
            at com.java.concurrency.ocp._3.TestExceptionTryWithResources.main(TestExceptionTryWithResources.java:9)
            Suppressed: java.io.IOException
                at com.java.concurrency.ocp._3.TestExceptionTryWithResources$FileReader.close(TestExceptionTryWithResources.java:28)
                at com.java.concurrency.ocp._3.TestExceptionTryWithResources.readData(TestExceptionTryWithResources.java:15)
                ... 1 more

		*/
    }

    public static void readData(String fileName) throws Exception {
        try(FileReader fr1 = new FileReader(fileName)){
            Connection c = getConnection();
        }
    }

    private static Connection getConnection() throws ClassNotFoundException {
        throw new ClassNotFoundException();
    }

    private static class FileReader implements AutoCloseable{

        public FileReader(String fileName) { }

        @Override
        public void close() throws Exception {
            throw new IOException();
        }
    }
}
