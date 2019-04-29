package com.linnyk.grpc.greeting.client;

import com.proto.greet.GreetRequest;
import com.proto.greet.GreetResponse;
import com.proto.greet.GreetServiceGrpc;
import com.proto.greet.Greeting;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GreetingClient {

    public static void main(String[] args) {
        System.out.println("Hello CalculatorClient");

        // Create channel
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 50051)
                .usePlaintext()
                .build();

        System.out.println("Creating stub");

        // Synchronous client
        GreetServiceGrpc.GreetServiceBlockingStub syncClient = GreetServiceGrpc.newBlockingStub(channel);

        // Asynchronous client
        GreetServiceGrpc.GreetServiceFutureStub asyncClient = GreetServiceGrpc.newFutureStub(channel);

        // Create greet request
        Greeting greeting = Greeting.newBuilder().setFirstName("Oleh").build();
        GreetRequest greetRequest = GreetRequest.newBuilder().setGreeting(greeting).build();

        System.out.println("Send request: " + greeting);

        // Call the RPC and get back response
        GreetResponse greetResponse = syncClient.greet(greetRequest);

        System.out.println("Response is: " + greetResponse.getResult());

        System.out.println("Shutting down channel");
        channel.shutdown();
    }
}
