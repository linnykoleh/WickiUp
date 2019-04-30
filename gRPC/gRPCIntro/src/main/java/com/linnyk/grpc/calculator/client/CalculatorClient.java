package com.linnyk.grpc.calculator.client;

import com.proto.calculator.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.Iterator;

public class CalculatorClient {

    public static void main(String[] args) {
        System.out.println("Hello CalculatorClient");

        // Create channel
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 50051)
                .usePlaintext()
                .build();

        System.out.println("Creating stub");

        // Synchronous client
        CalculatorServiceGrpc.CalculatorServiceBlockingStub service = CalculatorServiceGrpc.newBlockingStub(channel);

        sum(service);
        primeNumber(service);
        sqrt(service);

        channel.shutdown();
    }

    private static void sqrt(CalculatorServiceGrpc.CalculatorServiceBlockingStub service) {
        SquareRootRequest rootRequest = SquareRootRequest.newBuilder()
                .setNumber(0)
                .build();
        try {
            SquareRootResponse squareRootResponse = service.squareRoot(rootRequest);
            double rootedNumber = squareRootResponse.getRootedNumber();
            System.out.println("RootedNumber is " + rootedNumber);
        } catch (Exception e) {
            System.out.println("Got an exception ");
            e.printStackTrace();
        }
    }

    private static void sum(CalculatorServiceGrpc.CalculatorServiceBlockingStub service) {
        SumRequest sumRequest = SumRequest.newBuilder().setFirstNumber(12).setSecondNumber(33).build();

        System.out.println("Send request : " + sumRequest);
        SumResponse sumResponse = service.sum(sumRequest);
        System.out.println("Response is: " + sumResponse.getSumResult());
    }

    private static void primeNumber(CalculatorServiceGrpc.CalculatorServiceBlockingStub service) {
        PrimeNumberDecompositionRequest sumRequest = PrimeNumberDecompositionRequest.newBuilder()
                .setNumber(Long.MAX_VALUE)
                .build();

        System.out.println("Send request : " + sumRequest);
        Iterator<PrimeNumberDecompositionResponse> primeNumberDecompositionResponseIterator = service.primeNumberDecomposition(sumRequest);
        primeNumberDecompositionResponseIterator.forEachRemaining(res -> {
            System.out.println("Response is: " + res.getPrimeFactor());
        });
    }
}
