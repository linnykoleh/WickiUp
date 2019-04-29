package com.linnyk.grpc.calculator.client;

import com.proto.calculator.CalculatorServiceGrpc;
import com.proto.calculator.SumRequest;
import com.proto.calculator.SumResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

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

        SumRequest sumRequest = SumRequest.newBuilder().setFirstNumber(12).setSecondNumber(33).build();

        System.out.println("Send request : " + sumRequest);
        SumResponse sumResponse = service.sum(sumRequest);

        System.out.println("Response is: " + sumResponse.getSumResult());
        channel.shutdown();
    }
}
