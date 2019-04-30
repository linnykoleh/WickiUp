package com.linnyk.grpc.greeting.client;

import com.proto.greet.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.Iterator;
import java.util.concurrent.CountDownLatch;

public class GreetingClient {

    public static void main(String[] args) throws InterruptedException {
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
        GreetServiceGrpc.GreetServiceStub asyncClient = GreetServiceGrpc.newStub(channel);

//        unaryCall(syncClient);
//        serverStreamCall(syncClient);
//        clientStreamCall(asyncClient);
        biDirectionalStreamCall(asyncClient);

        System.out.println("Shutting down channel");
        channel.shutdown();
    }

    private static void unaryCall(GreetServiceGrpc.GreetServiceBlockingStub syncClient) {
        Greeting greeting = Greeting.newBuilder()
                .setFirstName("Oleh")
                .setLastName("Linnyk")
                .build();

        GreetRequest greetRequest = GreetRequest.newBuilder().setGreeting(greeting).build();

        System.out.println("Send request for unaryCall: " + greeting);

        // Call the RPC and get back response for unaryCall
        GreetResponse greetResponse = syncClient.greet(greetRequest);

        System.out.println("Response is: " + greetResponse.getResult());
    }

    private static void serverStreamCall(GreetServiceGrpc.GreetServiceBlockingStub syncClient) {
        Greeting greeting = Greeting.newBuilder()
                .setFirstName("Oleh")
                .setLastName("Linnyk")
                .build();

        System.out.println("Send request for serverStreamCall: " + greeting);

        // Call the RPC and get back response for serverStreamCall
        GreetManyRequest greetManyRequest = GreetManyRequest.newBuilder().setGreeting(greeting).build();
        Iterator<GreetManyTimesResponse> greetManyTimesResponseIterator = syncClient.greetManyTimes(greetManyRequest);

        // Stream responses
        greetManyTimesResponseIterator.forEachRemaining(greetManyTimesResponse -> {
            System.out.println("Response is: " + greetManyTimesResponse.getResult());
        });
    }

    private static void clientStreamCall(GreetServiceGrpc.GreetServiceStub asyncClient) throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(1);
        StreamObserver<LongGreetRequest> streamObserver = asyncClient.longGreet(new StreamObserver<LongGreetResponse>() {
            @Override
            public void onNext(LongGreetResponse value) {
                // we get response from the server
                // onNext will be called only once
                System.out.println("Received response from the server");
                System.out.println(value.getResult());
            }

            @Override
            public void onError(Throwable t) {
                // we get an error form server
            }

            @Override
            public void onCompleted() {
                // the server is done sending data
                // onCompleted will be called right after onNext
                //
                System.out.println("The server has completed sending data");
                countDownLatch.countDown();
            }
        });

        System.out.println("Sending messages...");
        for (int i = 0; i < 5; i++) {
            Greeting greeting = Greeting.newBuilder().setFirstName("Oleh #" + i).build();
            LongGreetRequest greetRequest = LongGreetRequest.newBuilder().setGreeting(greeting).build();

            streamObserver.onNext(greetRequest);
        }

        System.out.println("Finished sending messages...");
        // tell the server that client is done
        streamObserver.onCompleted();

        countDownLatch.await();
    }

    private static void biDirectionalStreamCall(GreetServiceGrpc.GreetServiceStub asyncClient) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);

        StreamObserver<GreetEveryoneRequest> requestObserver = asyncClient.greetEveryone(new StreamObserver<GreetEveryoneResponse>() {

            @Override
            public void onNext(GreetEveryoneResponse value) {
                System.out.println("Response is: " + value.getResult());
            }

            @Override
            public void onError(Throwable t) {
                countDownLatch.countDown();
            }

            @Override
            public void onCompleted() {
                System.out.println("Server is done sending data");
                countDownLatch.countDown();
            }
        });
        for (int i = 0; i < 10; i++) {
            Greeting greeting = Greeting.newBuilder().setFirstName("Oleh #" + i).build();
            requestObserver.onNext(GreetEveryoneRequest.newBuilder()
                    .setGreeting(greeting)
                    .build());
            Thread.sleep(500);
        }
        requestObserver.onCompleted();

        countDownLatch.await();

    }

}
