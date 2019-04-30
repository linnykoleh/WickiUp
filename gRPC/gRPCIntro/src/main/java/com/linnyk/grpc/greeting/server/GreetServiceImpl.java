package com.linnyk.grpc.greeting.server;

import com.proto.greet.*;
import io.grpc.stub.StreamObserver;

public class GreetServiceImpl extends GreetServiceGrpc.GreetServiceImplBase {

    /**
     * Unary
     */
    @Override
    public void greet(GreetRequest request, StreamObserver<GreetResponse> responseObserver) {
        System.out.println("Request for greet is: " + request.getGreeting());
        String firstName = request.getGreeting().getFirstName();

        String result = "Hello " + firstName;

        // create the response
        GreetResponse greetResponse = GreetResponse.newBuilder()
                .setResult(result)
                .build();

        //send the response
        responseObserver.onNext(greetResponse);

        // complete the RPC call
        responseObserver.onCompleted();
    }

    /**
     * Server streaming example
     */
    @Override
    public void greetManyTimes(GreetManyRequest request, StreamObserver<GreetManyTimesResponse> responseObserver) {
        System.out.println("Request for greetManyTimes is: " + request.getGreeting());
        String firstName = request.getGreeting().getFirstName();

        for (int i = 0; i < 10; i++) {
            String result = "Hello " + firstName + ", response number: " + i;

            // create the response
            GreetManyTimesResponse greetResponse = GreetManyTimesResponse.newBuilder()
                    .setResult(result)
                    .build();

            //send the response
            responseObserver.onNext(greetResponse);
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // complete the RPC call
        responseObserver.onCompleted();
    }

    /**
     * Client streaming example
     */
    @Override
    public StreamObserver<LongGreetRequest> longGreet(StreamObserver<LongGreetResponse> responseObserver) {
        System.out.println("Request for longGreet");

        return new StreamObserver<LongGreetRequest>() {
            String result = "";

            @Override
            public void onNext(LongGreetRequest value) {
                // client sends a message
                result = result + " Hello " + value.getGreeting().getFirstName() + " | ";
            }

            @Override
            public void onError(Throwable t) {
                // client sends an error
                System.out.println("Error " + t);
            }

            @Override
            public void onCompleted() {
                // client is done
                // this is when we want to return a response(responseObserver)

                responseObserver.onNext(LongGreetResponse.newBuilder().setResult(result).build());
                responseObserver.onCompleted();
            }
        };
    }

    /**
     * Bi Directional streaming example
     */
    @Override
    public StreamObserver<GreetEveryoneRequest> greetEveryone(StreamObserver<GreetEveryoneResponse> responseObserver) {
        System.out.println("Request for greetEveryone");

        return new StreamObserver<GreetEveryoneRequest>() {
            @Override
            public void onNext(GreetEveryoneRequest value) {
                String response = "Hello " + value.getGreeting().getFirstName();

                System.out.println("Request for :" + value.getGreeting().getFirstName());

                GreetEveryoneResponse greetEveryoneResponse = GreetEveryoneResponse.newBuilder()
                        .setResult(response)
                        .build();
                responseObserver.onNext(greetEveryoneResponse);
            }

            @Override
            public void onError(Throwable t) {
                // client sends an error
            }

            @Override
            public void onCompleted() {
                responseObserver.onCompleted();
            }
        };
    }
}
