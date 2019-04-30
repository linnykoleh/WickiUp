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

        channel.shutdown();
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
